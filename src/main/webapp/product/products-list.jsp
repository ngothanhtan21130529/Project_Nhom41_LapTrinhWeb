<%@ page import="model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 11/21/2023
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/category.css" rel="stylesheet" type="text/css">

<%--<%--%>
<%--    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");--%>
<%--%>--%>

<%--<div class="grid-container">--%>
<%--    <% ArrayList<Product> productDAO = new ProductDAO().getListProduct();--%>
<%--        for (Product p : productDAO) { %>--%>
<%--    <div class="category">--%>
<%--        <a class="product" href="product-details.jsp">--%>
<%--            <img src="<%= p.getImgURL()%>">--%>
<%--            <div class="status"><%= p.getStatus() %></div>--%>
<%--            <h3 class="product_name"><%= p.getProductName() %></h3>--%>
<%--            <div class="price"><%= decimalFormat.format(p.getPrice()) %></div>--%>
<%--        </a>--%>
<%--    </div>--%>
<%--    <% } %>--%>
<%--</div>--%>

<%
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");
%>

<div class="grid-container">
    <%
        ArrayList<Product> productDAO = new ProductDAO().getListProduct();
        for (Product p : productDAO) {
            if (!"Ngừng bán".equals(p.getStatus())) {
    %>
    <div class="category">
        <a class="product" href="product-details.jsp">
            <img src="<%= p.getImgURL()%>">
            <div class="status"><%= p.getStatus() %></div>
            <h3 class="product_name"><%= p.getProductName() %></h3>
            <div class="price"><%= decimalFormat.format(p.getPrice()) %></div>
        </a>
    </div>
    <%
            }
        }
    %>
</div>
