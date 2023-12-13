<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 09/12/2023
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Sản phẩm</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.css">
    <link rel="stylesheet" href="css/products.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<div class="pro-main">
    <div class="galery">
        <%--        header--%>
        <jsp:include page="header.jsp"></jsp:include>
        <%--        main--%>
        <div class="products">
            <div class="grid-container">
                <%
                    ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
                    for (int i = 0; i < list.size(); i++) {
                %>
                <div class="category">
                    <a href="<%= list.get(i).getImgURL()%>">
                        <img src="<%= list.get(i).getImgURL()%>"
                             alt="ruby">
                        <%--                <div class="status">Đặt hàng</div>--%>
                        <h3><%=list.get(i).getProductName()%>></h3>
                        <div class="price"><%=list.get(i).getPrice()%><span>VNĐ</span></div>
                    </a>
                </div>
                <%}%>
            </div>
        </div>
    </div>
    <div class="pagination">
        <%int end = (int) request.getAttribute("end");%>
        <%for (int i = 1; i <= end; i++) {%>
        <a id="<%=i%>" href="SearchController?index=<%=i%>&txtSearch=<%=request.getAttribute("txtSearch")%>">
            <%=i%>
        </a>
        <%}%>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<script>
    document.getElementById("<%=request.getAttribute("index")%>").classList.add('active');
</script>
</body>
</html>
