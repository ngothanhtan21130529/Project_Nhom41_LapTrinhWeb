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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/category.css" rel="stylesheet" type="text/css">

<div class="gemstone-categories">
    <h2 class="title-h2"> ĐÁ QUÝ</h2>
    <div class="grid-container">
        <%
            ArrayList<Category> categoryDAO = new CategoryDAO().getListCategory();
            ArrayList<Category> categoriesName = new CategoryDAO().getNameCategory();

            for (Category c : categoryDAO) {
                for (Category name : categoriesName) {
                    if (c.getCategoryName().equals(name.getCategoryName())) {
        %>
        <div class="category">
            <a class="category-item" href="<%=request.getContextPath()%>/category/<%= c.getCategoryName().toLowerCase() %>.jsp">
                <img src="<%= c.getImgURL()%>">
                <h1 class="category_name"><%= c.getCategoryName()%></h1>
            </a>
        </div>
        <%
                        break; // Nếu trùng khớp, thoát khỏi vòng lặp
                    }
                }
            }
        %>
    </div>
</div>
</div>