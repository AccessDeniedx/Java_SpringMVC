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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>水果清单</title>
</head>
<body style="text-align: center;background-image: url(picture/5.jpg);
background-size:100% 100%;">
<h1>水果清单</h1>
<table width="70%" border="1px" align="center">
    <tr>
        <td>编号</td>
        <td>名字</td>
        <td>价格</td>
    </tr>

    <c:forEach var="entry" items="${listfruit}">
        <tr>
            <td>${entry.fruitid }</td>
            <td>${entry.FNAME}</td>
            <td>${entry.getFprice()}</td>
            <%--<td>
                <a href="${pageContext.request.contextPath }/BuyServlet?id=${entry.fruitid}" target="_blank">购买</a>
            </td>--%>
        </tr>
    </c:forEach>

</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>
