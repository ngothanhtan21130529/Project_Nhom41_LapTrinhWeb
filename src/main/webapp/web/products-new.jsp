<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link href="../css/category.css" rel="stylesheet" type="text/css">

<%
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VNĐ");
    ArrayList<Product> products = ProductDAO.getListProduct();
%>

<div class="slider" id="slider">
    <div class="slide" id="slide">
        <% for (Product p : products) { %>
        <div class="category">
            <a class="product" href="product-details.jsp">
                <img src="<%= p.getImgURL()%>">
                <div class="status"><%= p.getStatus() %></div>
                <h3 class="product_name"><%= p.getProductName() %></h3>
                <div class="price"><%= decimalFormat.format(p.getPrice()) %></div>
            </a>
        </div>
        <% } %>
    </div>
    <div class="ctrl-btn pro-prev"><i class="fa-solid fa-angle-left"></i></div>
    <div class="ctrl-btn pro-next"><i class="fa-solid fa-angle-right"></i></div>
</div>

<script>
    "use strict";

    productScroll();

    function productScroll() {
        let slider = document.getElementById("slider");
        let next = document.getElementsByClassName("pro-next")[0];
        let prev = document.getElementsByClassName("pro-prev")[0];
        let slide = document.getElementById("slide");
        let item = document.getElementsByClassName("category");

        let position = 0; // slider position

        prev.addEventListener("click", function () {
            // click previous button
            if (position > 0) {
                // avoid slide left beyond the first item
                position -= 1;
                translateX(position); // translate items
            }
        });

        next.addEventListener("click", function () {
            if (position >= 0 && position < hiddenItems()) {
                // avoid slide right beyond the last item
                position += 1;
                translateX(position); // translate items
            }
        });

        function hiddenItems() {
            // get hidden items
            let items = getCount(item, false);
            let visibleItems = slider.offsetWidth / item[0].offsetWidth;
            return items - Math.ceil(visibleItems);
        }
    }

    function translateX(position) {
        // translate items
        let slide = document.getElementById("slide");
        slide.style.left = position * -80 + "%";
    }

    function getCount(parent, getChildrensChildren) {
        // count no of items
        let relevantChildren = 0;
        let children = parent.length;
        for (let i = 0; i < children; i++) {
            if (parent[i].nodeType !== 3) {
                if (getChildrensChildren)
                    relevantChildren += getCount(parent[i].childNodes, true);
                relevantChildren++;
            }
        }
        return relevantChildren;
    }
</script>
