<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ page import="vn.edu.hcmuaf.dao.ProductDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 11/21/2023
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<<< HEAD:src/main/webapp/views/web/product/jewelrys-list.jsp
<link href="../../../css/category.css" rel="stylesheet" type="text/css">


========
<link href="../../css/category.css" rel="stylesheet" type="text/css">
>>>>>>>> 3903fc4 (commit):src/main/webapp/views/product/jewelrys-list.jsp
<div class="grid-container">
<%
    ArrayList<Product> productDAO = new ProductDAO().getListProduct();
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");
    for (Product product : productDAO) {
        if (product.getProductName().startsWith("TRANG SỨC")) {
%>

<%--    <%--%>
<%--        for (Product p : productDAO) { %>--%>
    <div class="category">
        <a class="product" href="product-details.jsp">
            <img src="<%= product.getImgURL()%>">
            <div class="status"><%= product.getStatus() %>
            </div>
            <h3 class="product_name"><%= product.getProductName() %>
            </h3>
            <div class="price"><%= decimalFormat.format(product.getPrice()) %>
            </div>
        </a>
    </div>
    <%
//                }
            }
        }
    %>
</div>
