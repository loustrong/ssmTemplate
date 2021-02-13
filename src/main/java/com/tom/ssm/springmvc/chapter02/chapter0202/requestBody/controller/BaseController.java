package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * BaseController
 *
 * @author Tom on 2021/2/12
 */
public class BaseController {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", e);
        mav.setViewName("0302/model/exceptionError");
        return mav;
    }
}
