package com.tom.ssm.springmvc.chapter02.chapter0202.requestMapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */

// Controller注解用于指示该类是一个控制器，可以同时处理多个请求动作
@Controller
@RequestMapping(value="/modelAttribute")
public class FormController{

	// 该方法映射的请求为http://localhost:8080/ModelAttributeTest/{formName}
	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		// 动态跳转页面
		return "0302/model/" + formName;
	}
	@RequestMapping(value="/index")
	public String index() {
		return "0302/model/index";
	}

}

