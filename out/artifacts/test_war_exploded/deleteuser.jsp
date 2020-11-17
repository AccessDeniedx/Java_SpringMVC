<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/19
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>删除用户</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">

<form action="Servlet?flag=shanchu" method="post">
    <br><br><br><br><br><br><br>
    <h1>请删除用户信息：</h1>
    编号：<input type="text" name="id" /> <br>
    名字：<input type="text" name="username" /> <br>
    <input type="submit" value="删除" /> <br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>

</body>
</html>
