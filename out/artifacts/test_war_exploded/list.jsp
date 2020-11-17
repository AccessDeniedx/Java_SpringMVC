<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">
<h1>用户列表</h1>
<table width="70%" border="1px" align="center">
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>密码</td>
		<td>邮箱</td>
	</tr>

	<c:forEach var="entry" items="${list }">
		<tr>
			<td>${entry.id }</td>
			<td>${entry.username }</td>
			<td>${entry.pass}</td>
			<td>${entry.email}</td>

			<%--<td>
				<a href="${pageContext.request.contextPath }/Servlet?flag=xiugai" target="_blank">编辑</a>

			</td>--%>
		</tr>
	</c:forEach>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>