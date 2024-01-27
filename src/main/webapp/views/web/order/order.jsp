<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/5/2024
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đặt hàng</title>
    <style>
        #orderDetails {
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        #totalPrice {
            text-align: right;
            font-size: 18px;
            color: orangered;
        }


        /* Thiết lập kiểu đầu vào của biểu mẫu đặt hàng */
        form {
            max-width: 400px;
            margin: 0 auto;
        }

        /* Định dạng nhãn và đầu vào trong biểu mẫu */
        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
        }

        #submit {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
        }

        #submit:hover {
            background-color: #45a049;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>
<jsp:include page="/views/header.jsp"></jsp:include>
<div id="orderDetails">
    <table>
        <tr>
            <th>Số lượng</th>
            <th>Tên</th>
        </tr>
        <c:set var="items" value="${sessionScope.listorders}"/>
        <c:forEach var="entry" items="${items}">
            <tr>
                <td><c:out value="${entry.key}"/></td>
                <td><c:out value="${entry.value.productName}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div id="totalPrice">
    <p>Total Price: <c:out value="${sessionScope.totalprice}"/></p>
</div>
<form action="${pageContext.request.contextPath}/checkorder" method="post">
    <label for="fullname">Họ tên</label>
    <input type="text" id="fullname" name="fullname">
    <label for="phone">Số điện thoại</label>
    <input type="tel" name="phone" id="phone">
    <label for="address">Địa chỉ</label>
    <input type="text" name="address" id="address">
    <input type="submit" value="Đặt hàng" id="submit">
</form>
</body>
<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</html>
