package cn.controller;

import cn.po.BaseDick;
import cn.po.Customer;
import cn.po.User;
import cn.service.BaseDickService;
import cn.service.CustomerService;
import cn.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDickService baseDictService;

    @RequestMapping("/test.action")
    public void test(Integer id){
        id++;
        System.out.println(id);
    }

    //客户列表
    @RequestMapping("/customer/list.action")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows, String custName, String custSource,
                       String custIndustry, String custlevel, Model model){
        Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custlevel);
        model.addAttribute("page", customers);
        //来源
        List<BaseDick> fromType = baseDictService.findBaseDictByTypeCode("002");
        //所属行业
        List<BaseDick> industryType = baseDictService.findBaseDictByTypeCode("001");
        //客户级别
        List<BaseDick> levelType = baseDictService.findBaseDictByTypeCode("006");
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName",custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel",custlevel);
        return "customer";
    }

    @RequestMapping("/customer/create.action")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session){
        User user = (User) session.getAttribute("USER_SESSION");
        customer.setCust_create_id(user.getUser_id());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);
        int rows = customerService.createCustomer(customer);
        if(rows >0){
            return "OK";
        }else {
            return "FAIL";
        }
    }

    @RequestMapping("/customer/getCustomerById.action")
    @ResponseBody
    public Customer getCustomerById(int id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("/customer/update.action")
    @ResponseBody
    public String updateCustomer(Customer customer){
        int rows = customerService.updateCustomer(customer);
        if(rows >0){
            return "OK";
        }else {
            return "FAIL";
        }
    }

    //删除
    @RequestMapping("/customer/delete.action")
    @ResponseBody
    public String customerDelete(int id){
        int rows = customerService.customerDelete(id);
        if(rows >0){
            return "OK";
        }else {
            return "FAIL";
        }
    }

    /**
     * 测试代码
     */
    public void test1(){
        int aaa;
    }
    /**
     * 测试代码
     */
    public void test2(){

    }
    /**
     * 测试代码
     */
    public void test3(){

    }
}
