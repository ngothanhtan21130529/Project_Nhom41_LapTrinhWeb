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

<div class="gemstone-categories">
    <h2> ĐÁ QUÝ</h2>
    <div class="grid-container">
        <% ArrayList<Category> categoryDAO=new CategoryDAO().getListCategory();
            for (Category c : categoryDAO) { %>
                <h1><%= c.getCategoryName()%></h1>
                <img src="<%= c.getImgURL()%>">
            <%}%>
    </div>
</div>