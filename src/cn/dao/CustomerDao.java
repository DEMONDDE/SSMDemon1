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
}
