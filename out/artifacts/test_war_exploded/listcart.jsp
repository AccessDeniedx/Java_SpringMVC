<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物车列表</title>
    <script type="text/javascript">
        function deleteitem(id) {
            var b = window.confirm("您确认删除吗？");
            if (b) {
                //window代表当前浏览器窗口，location代表当前浏览器窗口的地址栏
                window.location.href = "${pageContext.request.contextPath }/DeleteItemServlet?id=" + id;
            }
        }

        function clearcart() {
            var b = window.confirm("您确认清空吗？");
            if (b) {
                window.location.href = "${pageContext.request.contextPath }/ClearCartServlet";
            }
        }

        function changeQuantity(input, id, oldValue) {
            var quantity = input.value;//得到要修改的数量
            //检查用户输入的数量是不是一个正整数
            if (quantity < 0 || quantity != parseInt(quantity)) {// 1.1 != 1     parseInt("abc")返回NaN
                alert("请输入一个正整数");
                input.value = oldValue;
                return;
            }

            var b = window.confirm("您确认把书的数量修改为" + quantity + "吗？");
            if (b) {
                window.location.href = "${pageContext.request.contextPath }/ChangeQuantity?id=" + id + "&quantity=" + quantity;
            }
        }
    </script>
</head>
<body style="text-align: center;">
<h1>购物车列表</h1>

<c:if test="${empty(cart.map) }">	<!-- el表达式中的empty()函数：检测map是否为null或""，若是则返回true -->
    您没有购买任何商品！！！
</c:if>

<c:if test="${!empty(cart.map) }">
    <table width="70%" border="1px" align="center">
        <tr>
            <td>编号</td>
            <td>名字</td>
            <td>单价</td>
            <td>数量</td>
            <td>小计</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach var="entry" items="${cart.map }">
            <tr>
                <td>${entry.value.fruit.fruitid }</td>
                <td>${entry.value.fruit.FNAME }</td>
                <td>${entry.value.fruit.getFprice() }</td>
                <td>
                    <input type="text" name="quantity" value="${entry.value.quantity }" style="width: 25px" onchange="changeQuantity(this, ${entry.key }, ${entry.value.quantity })" />
                </td>
                <td>${entry.value.price }</td>
                <td colspan="2">
                    <!-- javascript:void(0)：去掉超链接默认的行为 -->
                    <a href="javascript:void(0)" onclick="deleteitem(${entry.key})">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">总价</td>
            <td colspan="2">${cart.price }元</td>
            <td><a href="javascript:void(0)" onclick="clearcart()">清空购物车</a></td>
            <td><a href="gotopay.jsp">去结算</a></td>
        </tr>
    </table>
    <%--<a href="javascript:history.back(-1)">返回继续购物</a>--%>
    <a href="/test_war_exploded/ListCartServlet">返回继续购物</a>
</c:if>
</body>
</html>