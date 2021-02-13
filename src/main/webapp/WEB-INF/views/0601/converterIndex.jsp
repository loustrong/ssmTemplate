<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/13
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试ConversionService</title>
</head>
<body>
<h3>注册页面</h3>
<form action="converterRegister" method="post">
    <table>
        <tr>
            <td><label>登录名: </label></td>
            <td><input type="text" id="loginname" name="loginname" ></td>
        </tr>
        <tr>
            <td><label>生日: </label></td>
            <td><input type="text" id="birthday" name="birthday" ></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="登录"></td>
        </tr>
    </table>
</form>

<h3>测试@InitBinder</h3>
<form action="binderRegister" method="post">
    <table>
        <tr>
            <td><label>登录名: </label></td>
            <td><input type="text" id="loginname1" name="loginname" ></td>
        </tr>
        <tr>
            <td><label>生日: </label></td>
            <td><input type="text" id="birthday1" name="birthday" ></td>
        </tr>
        <tr>
            <td><label>整数类型: </label></td>
            <td><input type="text" id="total" name="total" ></td>
        </tr>
        <tr>
            <td><input id="submit1" type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>