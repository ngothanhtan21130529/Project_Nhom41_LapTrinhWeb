<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/common/taglib.jsp" %>
<link href="<%=request.getContextPath()%>/css/category.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/products.css" rel="stylesheet" type="text/css">

<%
    ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");
%>

<div class="grid-container">
    <c:forEach var="product" items="${productList}">
    <div class="category">
        <a class="product" href="product-details.jsp">
            <img src="<c:out value="${product.imgURL}" />">
            <div class="status"><c:out value="${product.status}" /></div>
            <h3 class="product_name"><c:out value="${product.productName}" /></h3>
            <div class="price"><c:out value="${decimalFormat.format(product.price)}" /></div>
        </a>
    </div>
    </c:forEach>
</div>

<%--<div class="grid-container">--%>
<%--    <div class="category">--%>
<%--        <a href="product-details.html">--%>
<%--            <img src="./img/gemstone/ruby/Vien-Ruby-facet-Luc-Yen-063ct-IRRF152-231006300000.jpg"--%>
<%--                 alt="ruby">--%>
<%--            <div class="status"></div>--%>
<%--            <h3 class="product_name">Ruby</h3>--%>
<%--            <div class="price"></div>--%>
<%--        </a>--%>
<%--    </div>--%>
<%--</div>--%>

