<%@ page import="vn.edu.hcmuaf.model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/common/taglib.jsp"%>
<% ArrayList<Category> categoryList = (ArrayList<Category>) request.getAttribute("categoryList"); %>
<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 12/4/2023
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/category.css" rel="stylesheet" type="text/css">

<%--<div class="gemstone-categories">--%>
<%--    <h2 class="title-h2"> ĐÁ QUÝ</h2>--%>
<%--    <div class="grid-container">--%>
<%--        <%--%>
<%--            ArrayList<Category> categoryDAO = new CategoryDAO().getAllCategories();--%>
<%--            ArrayList<String> categoryNames = new CategoryDAO().getAllCategoryNames();--%>

<%--            for (Category c : categoryDAO) {--%>
<%--                if (categoryNames.contains(c.getCategoryName())) {--%>
<%--        %>--%>
<%--        <div class="category">--%>
<%--            <a class="category-item" href="<%=request.getContextPath()%>/category/<%= c.getCategoryName().toLowerCase() %>.jsp">--%>
<%--                <img src="<%= c.getImgURL()%>">--%>
<%--                <h1 class="category_name"><%= c.getCategoryName()%></h1>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--        <%--%>
<%--                }--%>
<%--            }--%>
<%--        %>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="gemstone-categories">
    <h2 class="title-h2"> ĐÁ QUÝ</h2>
    <div class="grid-container">

        <c:forEach items="${categoryList}" var="category" >
<%--            <c:if test="${categoryNames.contains(category.categoryName)}">--%>
<%--                <div class="category">--%>
<%--                    <a class="category-item" href="<%= request.getContextPath() %>/category/${category.categoryName.toLowerCase()}.jsp">--%>
<%--                        <img src="<c:out value="${category.imgURL}" />">--%>
<%--                        <h1 class="category_name"><c:out value="${category.categoryName}" /></h1>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </c:if>--%>
            <span>${category.categoryName}</span>

        </c:forEach>
    </div>
</div>
