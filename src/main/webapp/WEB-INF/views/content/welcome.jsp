<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/11
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎页面</title>
</head>
<body>
<!-- 页面可以访问Controller传递传递出来的message -->
${requestScope.message}
</body>
</html>
