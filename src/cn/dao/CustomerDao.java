package cn.dao;

import cn.po.Customer;

import java.util.List;

/**
 * 客户表操作类
 */
public interface CustomerDao {

    //客户表
    public List<Customer> selectCustomerList(Customer customer);

    //客户数
    public Integer selectCustomerListCount(Customer customer);

    //创建客户
    public Integer createCustomer(Customer customer);

    //获取用户
    public Customer getCustomerById(Integer id);

    public int updateCustomer(Customer customer);

    public int customerDelete(int id);
}
