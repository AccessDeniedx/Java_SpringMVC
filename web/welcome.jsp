<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>欢迎管理员登录！</title>
    <link rel="stylesheet" type="text/css" href="welcome.css"/>
</head>
<div id="wrap">
<body>
<%--${currUser.username }--%>
<%--管理员登录界面！--%>


<div style="text-align: center;"><h1>欢迎${currusername}登录你家楼下水果店自助系统!</h1>
<br><br>
    <a href="Servlet?flag=toAddUserPage"><img src ="picture/sg1.jpg" width="200" height="200" /></a>
    <a href="Servlet?flag=toAddUserPage">添加顾客</a>
    <a href="Servlet?flag=toUpdateUserPage"><img src ="picture/sg5.jpg" width="200" height="200"/></a>
    <a href="Servlet?flag=toUpdateUserPage">编辑顾客</a>
    <a href="Servlet?flag=toDelUserPage"> <img src ="picture/sg2.jpg" width="200" height="200"/></a>
    <a href="Servlet?flag=toDelUserPage">删除顾客</a>
    <a href="Servlet?flag=chaxunAll"><img src ="picture/sg3.jpg" width="200" height="200" /></a>
    <a href="Servlet?flag=chaxunAll">查询所有顾客</a>
    <br><br><br>
    <a href="fruitservlet?flag=toAddfruitPage"><img src ="picture/sg6.jpg" width="200" height="200" /></a>
    <a href="fruitservlet?flag=toAddfruitPage">添加水果</a>
    <a href="fruitservlet?flag=toUpdateFruitPage"><img src ="picture/sg7.jpg" width="200" height="200" /></a>
    <a href="fruitservlet?flag=toUpdateFruitPage">编辑水果</a>
    <a href="fruitservlet?flag=toDelFruitPage"><img src ="picture/sg4.jpg" width="200" height="200" /></a>
    <a href="fruitservlet?flag=toDelFruitPage">删除水果</a>
    <a href="fruitservlet?flag=chaxunAllFruit"><img src ="picture/sg8.jpg" width="200" height="200" /></a>
    <a href="fruitservlet?flag=chaxunAllFruit">查询所有水果</a>
    <br><br><br><br><br>
</div>

</body></div>
</html>