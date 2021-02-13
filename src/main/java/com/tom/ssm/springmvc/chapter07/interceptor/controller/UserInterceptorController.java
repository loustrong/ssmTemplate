package com.tom.ssm.springmvc.chapter07.interceptor.controller;

import com.tom.ssm.springmvc.chapter07.interceptor.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * UserController
 *
 * @author Tom on 2021/2/13
 */
@Controller
public class UserInterceptorController {

    /**
     * 处理/login请求
     * */
    @PostMapping(value="/loginInterceptor")
    public ModelAndView login(
            String loginname,String password,
            ModelAndView mv,
            HttpSession session){
        // 模拟数据库根据登录名和密码查找用户，判断用户登录
        if(loginname != null && loginname.equals("fkit")
                && password!= null && password.equals("123456")){
            // 模拟创建用户
            User user = new User();
            user.setLoginname(loginname);
            user.setPassword(password);
            user.setUsername("管理员");
            // 登录成功，将user对象设置到HttpSession作用范围域
            session.setAttribute("user", user);
            // 转发到main请求
            mv.setViewName("redirect:mainInterceptor");
        }else{
            // 登录失败，设置失败提示信息，并跳转到登录页面
            mv.addObject("message", "登录名或密码错误，请重新输入!");
            mv.setViewName("0702/loginForm");
        }
        return mv;
    }


}

