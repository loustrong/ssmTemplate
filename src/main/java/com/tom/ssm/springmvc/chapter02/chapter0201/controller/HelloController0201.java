package com.tom.ssm.springmvc.chapter02.chapter0201.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloController
 *
 * @author Tom on 2021/2/11
 */
public class HelloController0201 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("handleRequest is called.");
        // 创建准备返回的ModelAndView对象,该对象通常包含了返回视图的路径,模型名称和模型对象
        ModelAndView mv = new ModelAndView();
        // 添加模型数据, 可以是任意的POJO对象
        mv.addObject("message", "Hello World!");
        // 设置逻辑视图名,视图解析器会根据该名称解析到具体的视图页面
        mv.setViewName("content/welcome");
        return mv;
    }
}
