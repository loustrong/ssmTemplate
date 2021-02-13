package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * UserController
 *
 * @author Tom on 2021/2/12
 */
@Controller
public class UserHandlerController extends BaseController{

    @GetMapping("/handlerLogin")
    public String login(String username){
        if(username == null){
            throw new NullPointerException("用户名不存在");
        }
        return "success";
    }

    @GetMapping("/handlerIndex")
    public String index(String username){
        return "0302/model/handlerIndex";
    }
}
