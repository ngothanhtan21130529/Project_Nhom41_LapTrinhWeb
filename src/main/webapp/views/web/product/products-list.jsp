<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/common/taglib.jsp"%>
<link href="../../../css/category.css" rel="stylesheet" type="text/css">

<%
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");
    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
%>

<div class="grid-container">
    <% if (products != null) { %>
    <% for (Product product : products) { %>
    <div class="category">
        <a class="product" href="product-details.jsp">
            <p><b>Product Name:</b> <%= product.getProductName() %></p>
            <p><b>Price:</b> <%= decimalFormat.format(product.getPrice()) %></p>
            <p><b>Status:</b> <%= product.getStatus() %></p>
        </a>
    </div>
    <% } %>
    <% } else { %>
    <p>No products available.</p>
    <% } %>
</div>
