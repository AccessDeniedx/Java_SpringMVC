<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/19
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + '/';
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>登录失败</title>
    <meta http-equiv="refresh" content ="3;url=index.jsp">
</head>
<body>

<b>用户名或密码错误！登陆失败！3秒后将跳转到登录页！
    <a href="index.jsp">点击此处直接跳转</a></b>

</body>
</html>
