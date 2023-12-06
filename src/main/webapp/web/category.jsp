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
        <c:forEach var="category" items="${categories}">
            <div class="category">
                <a href="product-details.html">
                    <img src="${category.imgUrl}" alt="${category.categoryName}">
                    <h3>${category.categoryName}</h3>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
