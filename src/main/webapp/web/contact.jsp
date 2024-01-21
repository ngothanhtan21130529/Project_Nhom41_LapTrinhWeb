<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liên hệ</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/contact.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">--%>
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.min.css">

</head>

<body>
<div class="container">
    <header class="header">
        <div class="container">
            <div class="box">
                <div class="logo">
                    <img src="<%=request.getContextPath()%>/img/logo.png" alt="Logo" class="logo-img"/>
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
                        <li class="navigation-item">
                            <a href="about.html">Giới thiệu</a>
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
                                <i class="fa-solid fa-cart-shopping"></i>
                            </a>
                            <!-- if card have product -> add class header__drop__empty -->
                            <div class="header__drop-list">
                                <div class="header__mt">
                                    <img
                                            src="<%=request.getContextPath()%>/images/cart-empty.png"
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
                                                    src="<%=request.getContextPath()%>/img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg"
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
                                                    src="<%=request.getContextPath()%>/img/gemstone/ruby/Vien-Ruby-facet-Luc-Yen-063ct-IRRF152-231006300000.jpg"
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
                                                    src="<%=request.getContextPath()%>/img/gemstone/jewels/Nhan-nam-Kim-Cuong-Vang-trang-Au18k-MA-K-6000000.jpg"
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
                                                    src="<%=request.getContextPath()%>/img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg"
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
    <div class="place">
        <div class="place-img">
            <img src="<%=request.getContextPath()%>img/dai-hoc-long-lam.jpg" alt="">
        </div>
        <div class="place-map">
            <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.1986922460546!2d106.78813967465993!3d10.872487157415222!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRQLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1698824490776!5m2!1svi!2s"
                    width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
    </div>
    <div class="contact">
        <div class="contact-label">
            Liên Hệ
        </div>
        <div class="contact-number-choosing">
            <a href="#" class="landline">
                <div class="landline-label">
                    Số máy bàn
                </div>
                <div class="landline-num">
                    08856 174 581
                </div>
            </a>
            <a href="#" class="hotline">
                <div class="hotline-label">
                    Hotline
                </div>
                <div class="hotline-num">
                    0856 174 581
                </div>
                <div class="time-line">
                    (8h00 - 21h00)
                </div>
            </a>
            <a href="#" class="counselors">
                <div class="counselors-label">
                    Tư vấn viên
                </div>
                <div class="counselors-num">
                    0988 458 352
                </div>
            </a>
            <a href="#" class="chat-zalo-whatapp-wechat">
                <div class="chat-zalo-whatapp-wechat-label">
                    Chat Zalo/Whatapp/Wechat
                </div>
                <div class="chat-zalo-whatapp-wechat-num">
                    0856 174 581
                </div>
            </a>
        </div>
    </div>
    <div class="contact-us">
        <div class="all-store-and-showroom">
            <div class="showroom pull-up">
                <div class="showroom-label normal-text">
                    SHOWROOM
                </div>
                <div class="showroom-text small-text">
                    Khu phố 6, phường Linh Trung, Thành phố Thủ Đức, Thành phố Hồ Chí Minh
                </div>
            </div>
            <div class="store-1 pull-down">
                <div class="store-1-label normal-text">
                    STORE 1
                </div>
                <div class="store-1-text small-text">
                    Tòa thiên lý (khu phố 6, phường Linh Trung, Thành phố Thủ Đức, Thành phố Hồ Chí Minh)
                </div>
            </div>
            <div class="store-2 pull-up">
                <div class="store-2-label normal-text">
                    STORE 2
                </div>
                <div class="store-2-text small-text">
                    Tòa Phượng Vỹ (khu phố 6, phường Linh Trung, Thành phố Thủ Đức, Thành phố Hồ Chí Minh)
                </div>
            </div>
            <div class="store-3 pull-down">
                <div class="store-3-label normal-text">
                    STORE 3
                </div>
                <div class="store-3-text small-text">
                    Khoa Công Nghệ Thông Tin (khu phố 6, phường Linh Trung, Thành phố Thủ Đức, Thành phố Hồ Chí
                    Minh)
                </div>
            </div>
        </div>
        <div class="contact-us-right-box">
            <div class="contact-us-label">
                LIÊN HỆ VỚI CHÚNG TÔI
            </div>
            <form action="<%=request.getContextPath()
         %>/contact" method="post">
                <input type="text" class="full-name input-box" placeholder="Họ tên(*)" name="fullname">
                <input type="text" class="phone-num input-box" placeholder="Số điện thoại(*)" name="phone">
                <input type="text" class="email input-box" placeholder="Email" name="email">
                <input type="text" class="title input-box" placeholder="Tiêu đề" name="subject">
                <textarea name="content" id="content" class="content input-box" cols="30" rows="10"
                          placeholder="Nội dung" name="content"></textarea>
                <button class="sending">
                    Gửi
                </button>
            </form>

        </div>
    </div>
    <section class="footer">
        <div class="social-media">
            <div class="label">
                LIÊN LẠC THÔNG QUA MẠNG XÃ HỘI
            </div>
            <div class="way">
                <div class="phone">
                    <i class="fa-solid fa-phone fa-sm" style="color: #495569;"></i>
                    <div class="phone-num">
                        Hotline: 0856174581
                    </div>
                </div>
                <div class="social-meida-way">
                    <div class="facebook-icon">
                        <a href="#">
                            <i class="fa-brands fa-facebook-f fa-xs" style="color: black;"></i>
                        </a>
                    </div>
                    <div class="instagram-icon">
                        <a href="#">
                            <i class="fa-brands fa-instagram fa-xs" style="color: black"></i>
                        </a>
                    </div>
                    <div class="tiktok-icon">
                        <a href="#">
                            <i class="fa-brands fa-tiktok fa-xs" style="color: black"></i>
                        </a>
                    </div>
                    <div class="youtube-icon">
                        <a href="#">
                            <i class="fa-brands fa-youtube fa-xs" style="color: black"></i>
                        </a>
                    </div>
                </div>
                <div class="zalo">
                    <img src="img/zalo-icon.png" alt="">
                    <div class="zalo-phone-num">
                        Zalo: 0856174581
                    </div>
                </div>
            </div>
        </div>
        <div class="end-footer">
            <div class="customer-about">
                <div class="customer-care">
                    <div class="customer-care-label">
                        CHĂM SÓC KHÁCH HÀNG
                    </div>
                    <ul>
                        <li>
                            <a href="#">Câu hỏi thường gặp</a>
                        </li>
                        <li>
                            <a href="#">Hướng dẫn mua hàng</a>
                        </li>
                        <li>
                            <a href="#">Quy định thanh toán</a>
                        </li>
                        <li>
                            <a href="#">Chính sách bảo hành</a>
                        </li>
                    </ul>
                </div>
                <div class="about-us">
                    <div class="about-us">
                        <div class="about-us-label">
                            VỀ CHÚNG TÔI
                        </div>
                        <div class="about-us-box">
                            <ul>
                                <li>
                                    <a href="#" class="home-page">Trang chủ</a>
                                </li>
                                <li>
                                    <a href="#" class="security">Bảo mật</a>
                                </li>
                                <li>
                                    <a href="#" class="blog">Blog</a>
                                </li>
                                <li>
                                    <a href="#" class="knowledge">Kiến thức</a>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <a href="#" class="introduce">Giới thiệu</a>
                                </li>
                                <li>
                                    <a href="#" class="promotion">Khuyến mãi</a>
                                </li>
                                <li>
                                    <a href="#" class="contact">Liên hệ</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- line -->
        <div class="line"></div>
        <div class="disigner">
            Được thiết kế bởi Thanh Tân, Tú Nguyệt, Nhựt Tân
        </div>
    </section>
</div>
</body>

</html>