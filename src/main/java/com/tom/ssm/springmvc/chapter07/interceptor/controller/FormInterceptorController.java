package com.tom.ssm.springmvc.chapter07.interceptor.controller;

/**
 * FormController
 *
 * @author Tom on 2021/2/13
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 动态页面跳转控制器
 * */
@Controller
public class FormInterceptorController{

    @GetMapping(value="/loginInterceptorForm")
    public String loginForm(){
        // 跳转到登录页面
        return "0702/loginForm";
    }

}
