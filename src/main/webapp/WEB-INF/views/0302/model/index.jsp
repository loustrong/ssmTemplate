<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/11
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试@ModelAttribute</title>
</head>
<body>
<h3>测试@ModelAttribute的不同用法</h3>
<a href="loginForm1">测试@ModelAttribute(value="")注释返回具体类的方法 </a><br><br>
<a href="loginForm2">测试@ModelAttribute注释void返回值的方法</a><br><br>
<a href="loginForm3">测试@ModelAttribute注释返回具体类的方法</a><br><br>
<a href="loginForm4">测试@ModelAttribute和@RequestMapping同时注释一个方法 </a><br><br>
<a href="loginForm5">测试@ModelAttribute注释一个方法的参数 </a><br><br>
</body>
</html>
