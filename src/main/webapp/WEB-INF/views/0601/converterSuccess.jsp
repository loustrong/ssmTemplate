<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/13
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试ConversionService</title>
</head>
<body>
登录名：${requestScope.user.loginname }<br>
生日：<fmt:formatDate value="${requestScope.user.birthday}"
                   pattern="yyyy年MM月dd日"/><br>
总数:${requestScope.user.total }<br>
</body>
</html>