<%@ page import="model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 11/21/2023
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Chi tiết sản phẩm</title>
</head>
<body>

<%--<div class="grid-container">--%>
<%--    <%--%>
<%--        ArrayList<Product> productDAO = new ProductDAO().getListProduct();--%>
<%--        DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");--%>
<%--        for (Product product : productDAO) {--%>
<%--            if (product.getProductName().startsWith("TRANG SỨC")) {--%>
<%--    %>--%>

<%--    <div class="category">--%>
<%--        <a class="product" href="product-details.jsp?productId=<%= product.getProductId() %>">--%>
<%--            <img src="<%= product.getImgURL()%>">--%>
<%--            <div class="status"><%= product.getStatus() %></div>--%>
<%--            <h3 class="product_name"><%= product.getProductName() %></h3>--%>
<%--            <div class="price"><%= decimalFormat.format(product.getPrice()) %></div>--%>
<%--        </a>--%>
<%--    </div>--%>
<%--    <%--%>
<%--            }--%>
<%--        }--%>
<%--    %>--%>
<%--</div>--%>

</body>
</html>
