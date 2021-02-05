<%--
  Created by IntelliJ IDEA.
  User: D14052172
  Date: 2021/2/5
  Time: 下午 01:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2018, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date:
--%>

<%@ page import="org.springframework.web.context.*" %>
<%@ page import="org.springframework.web.context.support.*" %>
<%@ page import="com.tom.ssm.spring5.chapter0704.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring Bean的作用域</title>
</head>
<body>
<%
    // 获取Web应用初始化的Spring容器
    WebApplicationContext ctx =
            WebApplicationContextUtils.getWebApplicationContext(application);
// 两次获取容器中id为p的Bean
    Person p1 = (Person)ctx.getBean("chinese");
    Person p2 = (Person)ctx.getBean("chinese");
    out.println((p1 == p2) + "<br/>");
    out.println(p1);
%>
</body>
</html>