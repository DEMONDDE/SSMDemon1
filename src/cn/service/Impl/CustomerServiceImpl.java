package cn.service.Impl;

import cn.dao.CustomerDao;
import cn.po.Customer;
import cn.service.CustomerService;
import cn.utils.Page;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Override
    public Page<Customer> findCustomerList(int page, int rows, String custName, String custSource,
                                           String custIndustry, String custlevel) {
        Customer customer = new Customer();
        if(StringUtils.isNotBlank(custName)){
            customer.setCust_name(custName);
        }
        if(StringUtils.isNotBlank(custSource)){
            customer.setCust_source(custSource);
        }
        if(StringUtils.isNotBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }        if(StringUtils.isNotBlank(custlevel)){
            customer.setCust_level(custlevel);
        }
        customer.setStart((page-1)*rows);
        customer.setRows(rows);
        List<Customer> customers = customerDao.selectCustomerList(customer);
        int count = customerDao.selectCustomerListCount(customer);
        Page<Customer> result = new Page<Customer>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }
}
