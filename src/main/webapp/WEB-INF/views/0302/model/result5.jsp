<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/11
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试@ModelAttribute注释一个方法的参数</title>
</head>
<body>
访问request作用范围域中的user对象的loginname属性：${requestScope.user.loginname }<br>
访问request作用范围域中的user对象的password属性：${requestScope.user.password }<br>
访问request作用范围域中的user对象的username属性：${requestScope.user.username }<br>
<br>
</body>
</html>
