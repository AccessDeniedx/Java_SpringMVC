<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/20
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改水果信息</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">
<form action="fruitservlet?flag=xiugaif" method="post">
    <br><br><br><br><br><br><br>
    <h1>请修改水果信息：</h1>
    名字：<input type="text" name="fname"/> <br>
    价格：<input type="text" name="fprice"/> <br>
    编号：<input type="text" name="id" /> <br>
    <input type="submit" value="修改" /> <br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
</body>
</html>
