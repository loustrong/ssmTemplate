package com.tom.ssm.springmvc.chapter02.chapter0202.requestMapping.controller;

import com.tom.ssm.springmvc.chapter02.chapter0202.requestMapping.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * UserController
 *
 * @author Tom on 2021/2/11
 */

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(value="/requestMappingUser")
public class UserMappingController {

    private static List<User> userList;
    public UserMappingController(){
        super();
        userList = new ArrayList<User>();
    }
    // 该方法映射的请求为http://localhost:8080/context/user/register，该方法支持GET请求
    @GetMapping(value="/register")
    public String registerForm(){
        System.out.println("register Get方法被调用");
        return "0302/registerForm";
    }
    // 该方法映射的请求为http://localhost:8080/RequestMappingTest/user/register，该方法支持POST请求
    @PostMapping(value = "/register")
    public String register(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            @RequestParam("username") String username
    ){
        System.out.println("register POST 方法被调用");
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername(username);
        userList.add(user);
        return "0302/loginForm";
    }
    @RequestMapping("/login")
    public String login(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model
    ){
        System.out.println("登录名:" + loginname);
        for(User user: userList){
            if(user.getLoginname().equals(loginname) && user.getPassword().equals(password)){
              model.addAttribute("user", user);
              return "0302/welcome";
            }
        }
        return "0302/loginForm";
    }

    @RequestMapping(value="/ModelMapTest")
    public String ModelMapTest(ModelMap modelMap){
        System.out.println("ModelMapTest");
        User user = new User();
        // 设置user对象的username属性
        user.setUsername("疯狂软件");
        // 将User对象添加到ModelMap当中
        modelMap.addAttribute("user", user);
        return "0302/result2";
    }
    @RequestMapping(value="/ModelAndViewTest")
    public ModelAndView ModelAndViewTest(ModelAndView mv){
        System.out.println("ModelAndViewTest");
        User user = new User();
        // 设置user对象的username属性
        user.setUsername("疯狂软件");
        // 将User对象添加到ModelAndView当中
        mv.addObject("user", user);
        // 设置要转发的页面
        mv.setViewName("0302/result");
        return mv;
    }

    // 测试@CookieValue注解
    // 该方法映射的请求为 /cookieValueTest
    @GetMapping(value="/attrbuteTest")
    public ModelAndView attrbuteTest(ModelAndView mv) {
        System.out.println("attributeTest方法被调用...");
        // 客户端重定向到main请求，会被自定义过滤器拦截
        mv.setViewName("redirect:main");;
        return mv;
    }

    /*
     *  该方法映射的请求为/main
     *  @RequestAttribute("school")会获取request作用范围中名为"school"的属性的值赋给school变量
     *  @SessionAttribute("author")会获取session作用范围中名为"author"的属性的值赋给author变量
     */
    @RequestMapping("/main")
    public String main(
            @RequestAttribute("school") String school,
            @SessionAttribute("author") String author) {
        System.out.println("main方法被调用...");
        // 输出@RequestAttribute获得的school
        System.out.println("school: " + school);
        // 输出@SessionAttribute获得的author
        System.out.println("author: " + author);

        return "0302/attributeWelcome";
    }


    // 测试@PathVariable注解
    // 该方法映射的请求为/VariableTest/pathVariableTest/1
    @GetMapping(value="/pathVariableTest/{userId}")
    public void pathVariableTest(
            @PathVariable Integer userId) {
        System.out.println("通过@PathVariable获得数据： userId=" + userId);
    }

    // 测试@MatrixVariable注解
    // 该方法映射的请求为/VariableTest/matrixVariableTest/1;name=jack;age=23
    @GetMapping(value="/matrixVariableTest/{userId}")
    public void matrixVariableTest(
            @PathVariable Integer userId,
            @MatrixVariable(value="name",pathVar="userId") String name,
            @MatrixVariable(value="age",pathVar="userId") Integer age){
        System.out.println("通过@PathVariable获得数据： userId=" + userId);
        System.out.println("通过@MatrixVariable获得数据： name="  + name + " age="+ age);
    }

    // 测试@MatrixVariable注解的复杂例子
    // 该方法映射的请求为//VariableTest/productTest/computer;brand=apple,acer;low=2000;height=10000
    @GetMapping(value="/productTest/{goods}")
    public void productTest(
            @PathVariable String goods,
            @MatrixVariable(value="brand",pathVar="goods") List<String> brand,
            @MatrixVariable(value="low",pathVar="goods") Integer low,
            @MatrixVariable(value="height",pathVar="goods") Integer height){
        System.out.println("通过@PathVariable获得数据： goods=" + goods);
        System.out.println("通过@MatrixVariable获得数据：brand="  + brand);
        System.out.println("通过@MatrixVariable获得数据： low="  + low + " height="+ height);
    }

    // 测试@CrossOrigin注解
    @CrossOrigin(origins="http://localhost:8089/requestMappingUser")
    @GetMapping(value="/welcome")
    public String welcome() {
        System.out.println("处理跨域请求");
        return "0302/crossWelcome";
    }

    // 测试@RequestHeader注解
    // 该方法映射的请求为 /requestHeaderTest
    @GetMapping(value="/requestHeaderTest")
    public void requestHeaderTest(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader(value="Accept") String[] accepts) {
        System.out.println("通过@requestHeaderTest获得User-Agent： " + userAgent);
        System.out.println("通过@requestHeaderTest获得Accept： ");
        // 循环输出头信息
        for(String accept : accepts){
            System.out.println(accept);
        }
    }

}
