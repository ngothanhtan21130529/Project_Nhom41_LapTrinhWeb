<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/23/2024
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css" type="text/css">
</head>
<body>
<main class="content">
    <h1>Giỏ hàng của bạn</h1>

    <div class="shopping-cart">

        <div class="column-labels">
            <label class="product-image">Ảnh</label>
            <label class="product-details">Sản phẩm</label>
            <label class="product-price">Giá</label>
            <label class="product-quantity">Số lượng</label>
            <label class="product-removal">Xóa</label>
            <label class="product-line-price">Tổng</label>
        </div>
        <c:set var="cart" value="${sessionScope.list}"/>
        <c:forEach items="${cart}" var="cart">

<%--        <div class="product">--%>
<%--            <div class="product-image">--%>
<%--                <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg">--%>
<%--            </div>--%>
<%--            <div class="product-details">--%>
<%--                <input type="hidden" value="" name="id">--%>
<%--                <div class="product-title">Kim cương</div>--%>
<%--                <p class="product-description">dafsd</p>--%>
<%--            </div>--%>
<%--            <div class="product-price">12.990.000</div>--%>
<%--            <div class="product-quantity">--%>
<%--                <input type="number" value="2" min="1">--%>
<%--            </div>--%>
<%--            <div class="product-removal">--%>
<%--                <button class="remove-product">--%>
<%--                    Xóa--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="product-line-price">25.98</div>--%>
<%--        </div>--%>

<%--        <div class="product">--%>
<%--            <div class="product-image">--%>
<%--                <img src="https://s.cdpn.io/3/large-NutroNaturalChoiceAdultLambMealandRiceDryDogFood.png">--%>
<%--            </div>--%>
<%--            <div class="product-details">--%>
<%--                <input type="hidden" value="" name="id">--%>
<%--                <div class="product-title">Kim cương</div>--%>
<%--                <p class="product-description">Kim cương</p>--%>
<%--            </div>--%>
<%--            <div class="product-price">45.000.000</div>--%>
<%--            <div class="product-quantity">--%>
<%--                <input type="number" value="1" min="1">--%>
<%--            </div>--%>
<%--            <div class="product-removal">--%>
<%--                <button class="remove-product">--%>
<%--                    Xóa--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="product-line-price">10.000.000</div>--%>
<%--        </div>--%>

        <div class="totals">
            <div class="totals-item">
                <label>Subtotal</label>
                <div class="totals-value" id="cart-subtotal">71.970.0000</div>
            </div>
            <div class="totals-item">
                <label>Tax (5%)</label>
                <div class="totals-value" id="cart-tax">3.60</div>
            </div>
            <div class="totals-item">
                <label>Shipping</label>
                <div class="totals-value" id="cart-shipping">15.00</div>
            </div>
            <div class="totals-item totals-item-total">
                <label>Grand Total</label>
                <div class="totals-value" id="cart-total">90.57</div>
            </div>
        </div>

        <button class="checkout"><a href="checkout.html">Thanh toán</a></button>

    </div>
</main>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>
