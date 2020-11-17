<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/20
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除水果</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">
<form action="fruitservlet?flag=shanchuf" method="post">
    <br><br><br><br><br><br><br><br>
    <h1>请删除水果信息：</h1>
    编号：<input type="text" name="id" /> <br>
    名字：<input type="text" name="fname" /> <br>
    <input type="submit" value="删除" /> <br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
</body>
</html>
