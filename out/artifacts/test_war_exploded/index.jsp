<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/17
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>欢迎登录</title>
    <link rel="stylesheet" type="text/css" href="div.css"/>
</head>
<body>
<div class="header" id="head">
    <div class="title">欢迎登录本系统</div>

</div>

<div class="wrap" id="wrap" >
    <div class="logGet">
        <!-- 头部提示信息 -->
        <div class="logD logDtip">
            <p class="p1">登录</p>
        </div>
        <!-- 输入框 -->
        <form name="loginform" action="Servlet?flag=chaxun" method="post">
            <div class="lgD">
                <img src="picture/3.png" width="20" height="20" alt=""/>
                <input type="text"
                       placeholder="输入用户名" name="username"/>
            </div>
            <div class="lgD">
                <img src="picture/4.png" width="20" height="20" alt=""/>
                <input type="password"
                       placeholder="输入密码" name="pass"/>
            </div>
            <div class="logC">
                <a href="LoginSuccess.html" target="_self" type="submit"><button>登 录</button></a>
                <!--<input type="submit" name="tj" target="_self" value="提交">-->
            </div>
        </form>
        <div class="fgtpwd">
            <a href="inter.jsp">忘记密码？点此找回</a><br>
            <a href="adduser.jsp">新用户？点此注册</a>
        </div>
    </div>
</div>

<div class="footer" id="foot">
    <div class="copyright">
        <p>Made by AccessDenied.</p>
    </div>

</div>

</body>
</html>
