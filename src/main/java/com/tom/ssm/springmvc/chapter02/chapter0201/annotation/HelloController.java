package com.tom.ssm.springmvc.chapter02.chapter0201.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * HelloController
 *
 * @author Tom on 2021/2/11
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello0202",
            method = RequestMethod.GET
//            consumes = "application/json",produces = "application/json"
    )
    public ModelAndView hello(){
        System.out.println("Hello method is called.");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World!");
        mv.setViewName("content/welcome");
        return mv;
    }

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model){
        model.addAttribute("message", "Hello World!");
        return "0301/helloWorld";
    }
}
