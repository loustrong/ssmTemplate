package com.tom.ssm.springmvc.chapter06.chapter0601.controller;

import com.tom.ssm.springmvc.chapter06.chapter0601.converter.DateEditor;
import com.tom.ssm.springmvc.chapter06.chapter0601.domain.User;
import com.tom.ssm.springmvc.chapter06.chapter0601.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

/**
 * UserConverterController
 *
 * @author Tom on 2021/2/13
 */
@Controller
public class UserConverterController {
//    @Autowired
//    @Qualifier("userValidator")
//    private UserValidator userValidator;

    @GetMapping(value="/converterIndex")
    public String registerForm(){
        return "0601/converterIndex";
    }

    @GetMapping(value="/validatorIndex")
    public String validatorForm(  Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "0601/validatorIndex";
    }
    @PostMapping(value = "converterRegister")
    public String register(
            @ModelAttribute User user,
            Model model
    ){
        System.out.println(user);
        model.addAttribute("user", user);
        return "0601/converterSuccess";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(Date.class,new DateEditor());
//    }
    @PostMapping(value="/binderRegister")
    public String binderRegister(
            @Valid @ModelAttribute User user,
            Errors errors,
            Model model

    ){
        System.out.println(user);
//        model.addAttribute("user",user);
//        userValidator.validate(user, errors);
        if(errors.hasErrors()){
            return "0601/validatorIndex";
        }
        model.addAttribute("user", user);
        return "0601/converterSuccess";
    }
}
