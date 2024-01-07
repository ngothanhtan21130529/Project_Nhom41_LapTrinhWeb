<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/common/taglib.jsp"%>
<link href="../../../css/category.css" rel="stylesheet" type="text/css">

<%
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");
    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
%>

<div class="grid-container">
    <c:forEach var="product" items="${products}">
        <c:if test="${!'Ngừng bán'.equals(product.getStatus())}">
            <div class="category">
                <a class="product" href="product-details.jsp">
                    <img src="<c:out value="${product.getImgURL()}" />">
                    <div class="status"><c:out value="${product.getStatus()}" /></div>
                    <h3 class="product_name"><c:out value="${product.getProductName()}" /></h3>
                    <div class="price"><c:out value="${decimalFormat.format(product.getPrice())}" /></div>
                </a>
            </div>
        </c:if>
    </c:forEach>
</div>
