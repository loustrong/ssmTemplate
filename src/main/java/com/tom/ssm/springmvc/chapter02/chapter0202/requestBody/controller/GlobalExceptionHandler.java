package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler
 *
 * @author Tom on 2021/2/12
 */

//@ControllerAdvice
    @RestControllerAdvice
public class GlobalExceptionHandler {
    // 处理Exception类型异常
    @ExceptionHandler(value = Exception.class)
    public ModelAndView globalErrorHandler(Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", e);
        mav.setViewName("0302/model/exceptionError");
        return mav;

    }

    @ExceptionHandler(value= OrderException.class)
    @ResponseBody
    public Object OrderErrorHnadler(Exception e)throws Exception{
        // 创建返回对象Map并设置属性,会被@ResponseBody注解转换为json返回
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("message", e.getMessage());
        map.put("data","请求失败");
        return map;
    }
}
