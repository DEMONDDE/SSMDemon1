package cn.service;

import cn.po.Customer;
import cn.utils.Page;

public interface CustomerService {

    //查询客户列表
    public Page<Customer> findCustomerList(int page, int rows, String custName, String custSource, String custIndustry, String custlevel);

    //创建用户
    public int createCustomer(Customer customer);

    //通过Id获取用户
    public Customer getCustomerById(int id);

    //更新用户
    public int updateCustomer(Customer customer);

    //删除用户
    public int customerDelete(int id);
}
