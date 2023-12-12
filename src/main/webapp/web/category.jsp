<%@ page import="model.Category" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 12/4/2023
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/products.css" rel="stylesheet" type="text/css">
<div class="gemstone-categories">
    <h2> ĐÁ QUÝ</h2>
    <div class="grid-container">
        <% ArrayList<Category> categoryDAO = new CategoryDAO().getListCategory();
            for (Category c : categoryDAO) { %>
        <div class="category">
            <a href="product.jsp">
                <img src="<%= c.getImgURL()%>">
                <h1 class="category_name"><%= c.getCategoryName()%>
                </h1>
            </a>
        </div>
        <%}%>
    </div>
</div>