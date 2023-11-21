<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>



<header class="header">
    <div class="container">
        <div class="box">
            <div class="logo">
                <img src="./img/logo.png" alt="Logo" class="logo-img"/>
            </div>
            <nav class="navigation">
                <ul class="navigation-list">
                    <li class="navigation-item active">
                        <a href="index.html">Trang chủ</a>
                    </li>
                    <li class="navigation-item">
                        <a href="products.html">Sản phẩm</a>
                    </li>
                    <li class="navigation-item">
                        <a href="products.html">Trang sức</a>
                    </li>
                    <li class="navigation-item">
                        <a href="products.html">Đá quý</a>
                        <i class="fa-solid fa-caret-down"></i>
                        <ul class="dropdown-gem">
                            <li class="dropdown-item">
                                <a href="products.html">Spinel</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Kim cương</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Ruby</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Hổ phách</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="topaz.html">Topaz</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Aquamarine</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Tourmaline</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Jade</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Emerald</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Garnet</a>
                            </li>
                            <li class="dropdown-item">
                                <a href="products.html">Các loại đá khác</a>
                            </li>
                        </ul>
                    </li>
                    <li class="navigation-item">
                        <a href="contact.html">Liên hệ</a>
                    </li>
                    <li class="navigation-item">
                        <a href="policy.html">Chính sách</a>
                    </li>
                </ul>
            </nav>
            <div class="header-btn">
                <ul class="header-list">
                    <li class="header-item header-search">
                        <form role="search" action="" method="get">
                            <input
                                    type="search"
                                    name="search"
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
                        <a href="cart.html">
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
                                                src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg"
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
                                                src="./img/gemstone/ruby/Vien-Ruby-facet-Luc-Yen-063ct-IRRF152-231006300000.jpg"
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
                                                src="./img/gemstone/jewels/Nhan-nam-Kim-Cuong-Vang-trang-Au18k-MA-K-6000000.jpg"
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
                                                src="img/gemstone/spinel/Vien-Spinel-sac-cobalt-sieu-VIP-175ct-IRSI65-231117500000.jpg"
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
                                                src="./img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg"
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
                                    <a href="cart.html" class="header__drop__btn">
                                        Xem giỏ hàng
                                    </a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="header-item sign-in"><a href="login.html">Đăng nhập</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>