package cn.controller;

import cn.po.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUser")
    public String findUserById(int id, Model model){
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "user";
    }
}
