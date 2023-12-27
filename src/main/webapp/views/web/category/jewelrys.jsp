<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 12/15/2023
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Trang sức</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.css">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/banner.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/products.css" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="/views/header.jsp" ></jsp:include>
<div class="main">
    <div class="banner">
        <img class="background-image" src="../../../img/banner/banner.png" alt="Background Image">
        <div class="content">
            <h1 class="title-name"> TRANG SỨC </h1>
            <p class="intro">TTN Shop tự hào là điểm đến lý tưởng cho những người yêu thích đá quý. Với một bộ sưu tập
                đa dạng, chúng tôi cung cấp những sản phẩm chất lượng cao, từ đá quý tự nhiên đến các mảnh nghệ thuật
                thủ công tinh tế. Khám phá sự đẹp tinh khôi của tự nhiên tại TTN Shop ngay hôm nay!</p>
        </div>
    </div>
    <div class="categogies-grid-container">
        <div class="filter">
            <i class="fa-solid fa-filter"><p> Bộ lọc</p></i>
            <div class="filter-item">
                <label for=""> Loại </label>
                <select name="category">
                    <option value="">---</option>
                    <option value="diamond">Kim cương</option>
                    <option value="ruby">Ruby</option>
                    <option value="topaz">Topaz</option>
                    <option value="amber">Hổ phách</option>
                    <option value="jade">Jade</option>
                </select>
            </div>
            <div class="filter-item">
                <label for=""> Giá </label>
                <select name="category">
                    <option value="">---</option>
                    <option value="diamond">Kim cương</option>
                    <option value="ruby">Ruby</option>
                    <option value="topaz">Topaz</option>
                    <option value="amber">Hổ phách</option>
                    <option value="jade">Jade</option>
                </select>
            </div>
            <div class="filter-item">
                <label for=""> Màu sắc</label>
                <select name="category">
                    <option value="">---</option>
                    <option value="diamond">Kim cương</option>
                    <option value="ruby">Ruby</option>
                    <option value="topaz">Topaz</option>
                    <option value="amber">Hổ phách</option>
                    <option value="jade">Jade</option>
                </select>
            </div>
        </div>
        <jsp:include page="/product/jewelrys-list.jsp"></jsp:include>
        <div class="pagination">
            <a href="#">&laquo;</a>
            <a href="#">1</a>
            <a class="active" href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">&raquo;</a>
        </div>
    </div>
</div>
<jsp:include page="/views/footer.jsp"></jsp:include>
</body>
</html>
