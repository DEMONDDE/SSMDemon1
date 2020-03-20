package cn.service.Impl;

import cn.dao.UserMapper;
import cn.po.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUser(int id) {
        return this.userMapper.findUser(id);
    }
}
