<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/19
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>新建水果</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">
<form action="fruitservlet?flag=zengjiaf" method="post">
    <br><br><br><br><br><br><br>
    <h1>请新建水果信息：</h1>
    编号：<input type="text" name="id" /> <br>
    名字：<input type="text" name="fname" /> <br>
    价格：<input type="text" name="fprice" /> <br>
    <input type="submit" value="添加" /> <br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
</body>
</html>
