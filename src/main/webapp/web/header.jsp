<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.css">
<link href="../css/header.css" rel="stylesheet" type="text/css">

<header class="header">
    <div class="container">
        <div class="box">
            <div class="logo">
                <img src="../img/logo.png" alt="Logo" class="logo-img"/>
            </div>
            <nav class="navigation">
                <ul class="navigation-list">
                    <li class="navigation-item active">
                        <a href="index.jsp">Trang chủ</a>
                    </li>
                    <li class="navigation-item">
                        <a href="products.jsp">Sản phẩm</a>
                    </li>
                    <li class="navigation-item">
                        <a href="products.jsp">Trang sức</a>
                    </li>
                    <li class="navigation-item">
                        <a href="category.jsp">Đá quý</a>
                        <i class="fa-solid fa-caret-down"></i>
                        <ul class="dropdown-gem">
                            <li class="dropdown-item">
                                <a href="products.jsp">Spinel</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Kim cương</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Ruby</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Hổ phách</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Topaz</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Aquamarine</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Tourmaline</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Jade</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Emerald</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Garnet</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.jsp">Các loại đá khác</a>
                            </li>
                        </ul>
                    </li>
                    <li class="navigation-item">
                        <a href="contact.jsp">Liên hệ</a>
                    </li>
                    <li class="navigation-item">
                        <a href="policy.jsp">Chính sách</a>
                    </li>
                </ul>
            </nav>
            <div class="header-btn">
                <ul class="header-list">
                    <li class="header-item header-search">
                        <form role="search" action="../SearchController" method="get">
                            <input type="hidden" name="index" value="1">
                            <input
                                    type="search"
                                    name="txtSearch"
                                    class="search-input"
                                    placeholder="Tìm sản phẩm"
                                    autocomplete="off"
                            />
                            <button type="submit" class="header-search-btn">
                                <i class="fa-sharp fa-solid fa-magnifying-glass" style="color: #000000;"></i>
                            </button>
                        </form>
                    </li>
                  <jsp:include page="cart.jsp"></jsp:include>
                    <li class="header-item sign-in" style="position: fixed;z-index: 4"><a href="<%=request.getContextPath()%>/logout"><%=session.getAttribute("name")%></a></li>
                </ul>
            </div>
        </div>
    </div>
</header>