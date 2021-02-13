<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/12
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>异常处理示例</title>
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#search").click(function(){
                $.post("${pageContext.request.contextPath}/search",null,
                    function(data){
                        // 处理异常
                        if (data.message)
                        {
                            alert("与服务器交互出现异常：" + data.message);
                        }
                        else
                        {
                            // 获取服务器响应，显示所有订单信息

                        }
                    },"json");
            });
        })
    </script>
</head>
<body>
<br>
<a href="find">@ControllerAdvice异常处理</a><br><br>
<hr>
<button id="search">查询订单（返回JSON）</button>
</body>
</html>
