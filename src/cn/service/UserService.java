package cn.service;

import cn.po.User;

/**
 * servide类
 */
public interface UserService {

    public User findUser(String usercode, String password);
}
