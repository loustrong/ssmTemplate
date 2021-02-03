<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/3
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小脚本测试</title>
</head>
<body>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://10.62.240.45:3306/sakila","wcdmaria","wistron888");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from news_inf");
%>
<table bgcolor="#9999dd" border="1" width="300">
   <% // 遍历结果集
    while(rs.next()){
    %>
    <tr>
        <!-- 输出结果集-->
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
    </tr>
    <% }%>
</table>

</body>
</html>
