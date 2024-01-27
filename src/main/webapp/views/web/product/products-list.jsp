<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/common/taglib.jsp" %>
<link href="<%=request.getContextPath()%>/css/category.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/products.css" rel="stylesheet" type="text/css">

<%
    ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
%>

<div class="category">
    <c:forEach items="${productList}" var="product">
        <a class="product" href="<%=request.getContextPath()%>/productDetail?id=<c:out value="${product.id}"/>">
            <img src="<c:out value="${product.imgURL}" />">
            <div class="status"><c:out value="${product.status}" /></div>
            <h3 class="product_name"><c:out value="${product.productName}" /></h3>
            <div class="price">
                <fmt:formatNumber pattern="###,###,### VNĐ" value="${product.price}" />
            </div>
        </a>
    </c:forEach>
</div>
