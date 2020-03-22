package cn.controller;

import cn.po.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器类
 */
@Controller
public class Usercontroller {

    @Autowired
    private UserService userService;

    //用户登陆
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session){
        User user = userService.findUser(usercode, password);
        if(user != null){
            session.setAttribute("USER_SESSION", user);
            return "customer";
        }
        model.addAttribute("msg", "账号或密码错误");
        return "login";
    }
}
