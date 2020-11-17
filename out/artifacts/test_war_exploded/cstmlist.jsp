<%@ page import="java.util.Map" %>
<%@ page import="model.fruitinfo" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2019/12/20
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%


    String headerUrl = request.getHeader("Referer");
    request.setAttribute("headerUrl", headerUrl);

%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎选购</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">

<h1>${currusername},欢迎您光临你家楼下水果店自助系统</h1>
<h2>水果清单</h2>
<table width="70%" border="1px" align="center">
    <tr>
        <td>编号</td>
        <td>名字</td>
        <td>价格</td>
        <td>操作</td>
    </tr>

    <c:forEach var="entry" items="${listfruitzxy}">
        <tr>
            <td>${entry.fruitid }</td>
            <td>${entry.FNAME}</td>
            <td>${entry.getFprice()}</td>
            <td>
                <a href="${pageContext.request.contextPath }/BuyServlet?id=${entry.fruitid}" target="_self">加购</a>
            </td>
        </tr>
    </c:forEach>

</table>
<a href="listcart.jsp">查看购物车</a>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>
