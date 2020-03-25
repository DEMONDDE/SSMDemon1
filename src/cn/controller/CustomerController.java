package cn.controller;

import cn.po.BaseDick;
import cn.po.Customer;
import cn.service.BaseDickService;
import cn.service.CustomerService;
import cn.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDickService baseDictService;

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
}
