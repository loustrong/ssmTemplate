package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;


import com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * OrderController
 *
 * @author Tom on 2021/2/12
 */
@Controller
public class OrderController {
    @PostMapping("/searchAdvisor")
    public String search() throws Exception{
        try{
            int i = 5/0;
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            throw new OrderException("订单查询失败");
        }
    }
    @GetMapping("/findAdvisor")
    public String find() throws Exception{
        int i = 5/0;
        return "success";
    }

    @GetMapping("/indexAdvisor")
    public String index(Model model) throws Exception{
        User user = new User("jack", "男", 28);
        model.addAttribute("user", user);
        return "0302/handler/advisorException";
    }
}
