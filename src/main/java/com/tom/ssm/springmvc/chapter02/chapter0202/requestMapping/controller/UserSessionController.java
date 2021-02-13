package com.tom.ssm.springmvc.chapter02.chapter0202.requestMapping.controller;

import com.tom.ssm.springmvc.chapter02.chapter0202.requestMapping.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * UserController
 *
 * @author Tom on 2021/2/11
 */

@Controller
@SessionAttributes("user")
@RequestMapping(value="/session")
public class UserSessionController {

    // 该方法映射的请求为http://localhost:8080/SessionAttributesTest/login
    @RequestMapping(value="/sessionLogin")
    public String login(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model ) {
        // 创建User对象，装载用户信息
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername("admin");
        // 将user对象添加到Model当中
        model.addAttribute("user",user);
        return "0302/crossWelcome";
    }

    @RequestMapping(value="/index")
    public String index() {
        return "0302/sessionLoginForm";
    }

}
