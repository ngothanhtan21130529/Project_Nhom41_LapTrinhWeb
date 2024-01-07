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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>
<body>
<form action="${pageContext.request.contextPath}/checkorder" method="post">
    <label for="fullname">Họ tên</label>
    <input type="text" id="fullname" name="fullname">
    <label for="email">Email</label>
    <input type="email" name="email" id="email">
    <label for="phone">Số điện thoại</label>
    <input type="tel" name="phone" id="phone">
    <label for="address">Địa chỉ</label>
    <input type="text" name="address" id="address">
    <input type="submit" value="Đặt hàng" id="submit">
</form>
<div id="note">
    <h2>Lưu ý:Vui lòng nhập đúng email mà bạn đã đăng ký với tài khoản trước đó</h2>
</div>
</body>
<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</html>
