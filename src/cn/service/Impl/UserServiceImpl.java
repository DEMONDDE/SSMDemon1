package cn.service.Impl;

import cn.dao.UserDao;
import cn.po.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户service实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String usercode, String password) {
        return userDao.findUser(usercode, password);
    }
}
