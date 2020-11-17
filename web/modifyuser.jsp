<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
<div style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">
<form action="Servlet?flag=xiugai" method="post">
    <br><br><br><br><br><br><br>
    <h1>请修改用户信息：</h1>
新名字：<input type="text" name="username"  /> <br>
新密码：<input type="text" name="pass" /> <br>
原编号：<input type="text" name="id"  /> <br>
<input type="submit" value="修改" /> <br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
</div>
</body>
</html>