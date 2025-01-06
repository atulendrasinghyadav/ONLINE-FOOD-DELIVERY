<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
    <h1>Order List</h1>
    <c:forEach var="order" items="${orderList}">
        <p>Food: ${order.foodItem}, Quantity: ${order.quantity}, Address: ${order.address}</p>
    </c:forEach>
</body>
</html>
