<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">    <link rel="stylesheet" href="../font/fontawesome-free-6.4.2/css/all.css">
<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css">

<header class="header">
    <div class="container">
        <div class="box">
            <div class="logo">
                <img src="../img/logo.png" alt="Logo" class="logo-img"/>
            </div>
            <nav class="navigation">
                <ul class="navigation-list">
                    <li class="navigation-item active">
                        <a href="${pageContext.request.contextPath}/headerController?action=home">Trang chủ</a>
                    </li>
                    <li class="navigation-item">
                        <a href="${pageContext.request.contextPath}/products">Sản phẩm</a>
                    </li>
                    <li class="navigation-item">
                        <a href="${pageContext.request.contextPath}/products">Trang sức</a>
                    </li>
                    <li class="navigation-item">
                        <a href="${pageContext.request.contextPath}/products"> Đá quý </a>
                        <i class="fa-solid fa-caret-down"></i>
                        <ul class="dropdown-gem">
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Spinel</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Kim cương</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Ruby</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Hổ phách</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Topaz</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Aquamarine</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Tourmaline</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Jade</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="${pageContext.request.contextPath}/headerController?action=products">Emerald</a>
                            </li>
                            <li class="dropdown-item">
                                <<a href="${pageContext.request.contextPath}/headerController?action=products">Garnet</a>
                            </li>
                        </ul>
                    </li>
                    <li class="navigation-item">
                        <a href="${pageContext.request.contextPath}/headerController?action=contact">Liên hệ</a>
                    </li>
                    <li class="navigation-item">
                        <a href="${pageContext.request.contextPath}/headerController?action=policy">Chính sách</a>
                    </li>
                    <li class="navigation-item">
                        <a href="${pageContext.request.contextPath}/headerController?action=about">Giới thiệu</a>
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
                    <li class="header-item header__drop">
                        <a href="web/cart/cart.jsp">
                            <i class="fa-solid fa-cart-shopping" ></i>
                        </a>
                        <!-- if card have product -> add class header__drop__empty -->
                        <div class="header__drop-list">
                            <div class="header__mt">
                                <img
                                        src="./images/cart-empty.png"
                                        alt="Giỏ hàng trống"
                                        class="header__mt-img"
                                />
                                <h4 class="header__mt-msg">Chưa có sản phẩm</h4>
                            </div>

                            <div class="header__drop-no-mt">
                                <p class="heading__drop__no-mt-msg">
                                    Sản phẩm mới thêm
                                </p>

                                <div class="header__product-list">
                                    <div class="header__product-item">
                                        <img
                                                src="../img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg"
                                                alt="Header product card 1"
                                                class="header__product-item-img"
                                        />
                                        <span class="header__product-item-name">
                                                    Viên Topaz tự nhiên trắng tinh khiết - 283ct-IRTP56
                                                </span>
                                        <span class="header__product-item-price">
                                                    129.000.000
                                                </span>
                                    </div>
                                    <div class="header__product-item">
                                        <img
                                                src="../img/gemstone/ruby/Vien-Ruby-facet-Luc-Yen-063ct-IRRF152-231006300000.jpg"
                                                alt="Header product card 1"
                                                class="header__product-item-img"
                                        />
                                        <span class="header__product-item-name">
                                                    Viên Ruby facet Lục Yên 063ct-IRRF152
                                                </span>
                                        <span class="header__product-item-price">
                                                    129.000.000
                                                </span>
                                    </div>
                                    <div class="header__product-item">
                                        <img
                                                src="../img/gemstone/jewels/Nhan-nam-Kim-Cuong-Vang-trang-Au18k-MA-K-6000000.jpg"
                                                alt="Header product card 1"
                                                class="header__product-item-img"
                                        />
                                        <span class="header__product-item-name">
                                                    Nhẫn nam Kim Cương Vàng trắng Au18k-MA-K
                                                </span>
                                        <span class="header__product-item-price">
                                                    129.000
                                                </span>
                                    </div>
                                    <div class="header__product-item">
                                        <img
                                                src="../img/gemstone/spinel/Vien-Spinel-sac-cobalt-sieu-VIP-175ct-IRSI65-231117500000.jpg"
                                                alt="Header product card 1"
                                                class="header__product-item-img"
                                        />
                                        <span class="header__product-item-name">
                                                    Viên Spinel sắc cobalt siêu VIP 175ct-IRSI65
                                                </span>
                                        <span class="header__product-item-price">
                                                    129.000.000
                                                </span>
                                    </div>
                                    <div class="header__product-item">
                                        <img
                                                src="../img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg"
                                                alt="Header product card 1"
                                                class="header__product-item-img"
                                        />
                                        <span class="header__product-item-name">
                                                    Kim cương tự nhiên
                                                </span>
                                        <span class="header__product-item-price">
                                                    129.000.000
                                                </span>
                                    </div>
                                </div>
                                <div class="header__drop__bottom">
                                    <p class="heading__drop__bottom-msg">
                                        5 sản phẩm mới thêm vào giỏ hàng
                                    </p>
                                    <a href="web/cart/cart.jsp" class="header__drop__btn">
                                        Xem giỏ hàng
                                    </a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="header-item sign-in"><a href="<%=request.getContextPath()%>/login/login.jsp">Đăng nhập</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>