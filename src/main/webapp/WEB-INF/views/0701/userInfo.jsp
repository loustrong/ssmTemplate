<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/13
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件下载</title>
</head>
<body>
<h3>文件下载</h3>
<br>
<a href="javascript:window.location.href = 'download?filename=' + encodeURIComponent( '${requestScope.filename }' )">
    ${requestScope.filename }
</a>

</body>
</html>
