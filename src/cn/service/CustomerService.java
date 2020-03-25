package cn.service;

import cn.po.Customer;
import cn.utils.Page;

public interface CustomerService {

    //查询客户列表
    public Page<Customer> findCustomerList(int page, int rows, String custName, String custSource, String custIndustry, String custlevel);
}
