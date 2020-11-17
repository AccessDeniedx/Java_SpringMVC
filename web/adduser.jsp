<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建用户</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">
<form action="Servlet?flag=zengjia" method="post">
    <br><br><br><br><br><br><br>
    <h1>请新建用户信息：</h1>
    编号：<input type="text" name="id" /> <br>
    名字：<input type="text" name="username" /> <br>
    密码：<input type="password" name="pass" /> <br>
    邮箱：<input type="text" name="email" /> <br>
    <input type="submit" value="添加" /> <br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
</body>
</html>