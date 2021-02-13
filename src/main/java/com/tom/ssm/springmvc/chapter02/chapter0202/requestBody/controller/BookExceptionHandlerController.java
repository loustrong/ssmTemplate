package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

/**
 * BookExceptionHandlerController
 *
 * @author Tom on 2021/2/12
 */
@Controller
public class BookExceptionHandlerController extends BaseController{

    @GetMapping("/handlerFind")
    public String find() throws Exception{
        try{
            int i = 5/0;
            return "success";
        }catch(Exception e){
            throw new SQLException("查找图书信息失败！");
        }
    }
}
