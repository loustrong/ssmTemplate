﻿<%--
  Created by IntelliJ IDEA.
  User: D14052172
  Date: 2021/2/4
  Time: 下午 03:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!-- 导入标签库，指定mytag前缀的标签，
由URI为http://www.crazyit.org/mytaglib的标签库处理 -->
<%@ taglib uri="http://www.crazyit.org/mytaglib" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>自定义标签示范</title>
    <meta name="website" content="http://www.crazyit.org" />
</head>
<body bgcolor="#ffffc0">
<h2>下面显示的是自定义标签中的内容</h2>
<!-- 使用标签 ，其中mytag是标签前缀，根据taglib的编译指令，
	mytag前缀将由URI为http://www.crazyit.org/mytaglib的标签库处理 -->
<mytag:helloWorld/><br/>
</body>
</html>
