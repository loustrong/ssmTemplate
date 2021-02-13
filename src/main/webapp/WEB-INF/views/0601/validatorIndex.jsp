<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/13
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>登录页面</h3>
<!-- 绑定user -->
<form:form modelAttribute="user" method="post" action="binderRegister" >
    <table>
        <tr>
            <td>登录名:</td>
            <td><form:input path="loginname"/></td>
            <!-- 显示loginname属性的错误信息 -->
            <td><form:errors path="loginname" cssStyle= "color:red"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><form:input path="password"/></td>
            <!-- 显示password属性的错误信息 -->
            <td><form:errors path="password" cssStyle= "color:red"/></td>
        </tr>
        <tr>
            <td>生日:</td>
            <td><form:input path="birthday"/></td>
            <td><form:errors path="birthday" cssStyle= "color:red"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>