package cn.dao;

import cn.po.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

    public User findUser(@Param("usercode") String usercode, @Param("password") String password);

}
