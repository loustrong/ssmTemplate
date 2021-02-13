<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 2021/2/12
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试接收JSON格式的数据</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="../js/json2.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            testRequestBody();
        });
        function testRequestBody(){
            $.ajax("${pageContext.request.contextPath}/json/testRequestBody",// 发送请求的URL字符串。
                {
                    dataType : "json", // 预期服务器返回的数据类型。
                    type : "post", //  请求方式 POST或GET
                    contentType:"application/json", //  发送信息至服务器时的内容编码类型
                    // 发送到服务器的数据。
                    data:JSON.stringify({id : 1, name : "Spring+MyBatis企业应用实战"}),
                    async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
                    // 请求成功后的回调函数。
                    success :function(data){
                        console.log(data);
                        $("#id").html(data.id);
                        $("#name").html(data.name);
                        $("#author").html(data.author);
                    },
                    // 请求出错时调用的函数
                    error:function(){
                        alert("数据发送失败");
                    }
                });

            $.post("${pageContext.request.contextPath}/jsonRest/testRequestBody",null,
                function(data){
                    $.each(data,function(){
                        var tr  = $("<tr align='center'/>");
                        $("<td/>").html(this.id).appendTo(tr);
                        $("<td/>").html(this.name).appendTo(tr);
                        $("<td/>").html(this.author).appendTo(tr);
                        $("#booktable").append(tr);
                    })
                },"json");
        }
    </script>
</head>
<body>
编号：<span id="id"></span><br>
书名：<span id="name"></span><br>
作者：<span id="author"></span><br>

<table id="booktable" border="1"  style="border-collapse: collapse;">
    <tr align="center">
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
    </tr>

</table>
</body>
</html>
