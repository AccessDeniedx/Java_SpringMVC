<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/22
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码找回</title>
</head>
<body>
<h1>请输入您的姓名，我们将以邮件的形式告知您。</h1>
<form action="EMAIL" method="post">
姓名：<input type="text" name="username">
    <input type="submit" name="确认找回">
</form>
</body>
</html>
