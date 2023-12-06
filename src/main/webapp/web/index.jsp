<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Trang chủ</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href=".../css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
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
    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.css">

</head>
<body>
<div class="container">
    <%--header--%>
    <jsp:include page="header.jsp"></jsp:include>
    <%--main--%>
    <div class="main">
        <div class="banner">
            <h1 class="tittle-name"> TTN STORE</h1>
            <p class="intro">TTN Shop tự hào là điểm đến lý tưởng cho những người yêu thích đá quý. Với một bộ sưu tập
                đa dạng, chúng tôi cung cấp những sản phẩm chất lượng cao, từ đá quý tự nhiên đến các mảnh nghệ thuật
                thủ công tinh tế. Khám phá sự đẹp tinh khôi của tự nhiên tại TTN Shop ngay hôm nay!</p>
        </div>
        <div class="categogies-grid-container">
            <jsp:include page="category.jsp"></jsp:include>
            <div class="jewelry-categogies">
                <h2> TRANG SỨC </h2>
                <div class="banner-jewelry">
                    <div class="w3-content w3-section" style="max-width:100%">
                        <img class="mySlides" src="./img/banner/jewelry.png" style="width:100%">
                        <img class="mySlides" src="./img/banner/jewelry-2.png" style="width:100%">
                        <img class="mySlides" src="./img/banner/jewelry-3.png" style="width:100%">
                    </div>
                </div>
                <div class="grid-container">
                    <div class="category">
                        <a href="product-details.html">
                            <img src="./img/gemstone/ruby/Vien-Ruby-facet-Luc-Yen-063ct-IRRF152-231006300000.jpg"
                                 alt="ruby">
                            <h3>Ruby</h3>
                        </a>
                    </div>
                    <div class="category">
                        <a href="product-details.html">
                            <img src="./img/gemstone/ruby/Vien-Ruby-facet-Luc-Yen-063ct-IRRF152-231006300000.jpg"
                                 alt="ruby">
                            <h3>Ruby</h3>
                        </a>
                    </div>
                    <div class="category">
                        <a href="product-details.html">
                            <img src="type2_image.jpg" alt="Type 2 Image">
                            <h3>Hổ phách</h3>
                        </a>
                    </div>
                    <div class="category">
                        <a href="product-details.html">
                            <img src="type2_image.jpg" alt="Type 2 Image">
                            <h3>Hổ phách</h3>
                        </a>
                    </div>
                    <div class="category">
                        <a href="product-details.html">
                            <img src="type2_image.jpg" alt="Type 2 Image">
                            <h3>Hổ phách</h3>
                        </a>
                    </div>
                    <div class="category">
                        <a href="product-details.html">
                            <img src="type2_image.jpg" alt="Type 2 Image">
                            <h3>Hổ phách</h3>
                        </a>
                    </div>
                </div>
            </div>
            <div class="categogies-new">
                <h2> SẢN PHẨM MỚI</h2>
                <div class="slider" id="slider">
                    <div class="slide" id="slide">
                        <div class="category">
                            <a href="product-details.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="product-details.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                        <div class="category">
                            <a href="amber.html">
                                <img class="item"
                                     src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg">
                                <h3>Topaz</h3>
                            </a>
                        </div>
                    </div>
                    <div class="ctrl-btn pro-prev"><i class="fa-solid fa-angle-left"></i></div>
                    <div class="ctrl-btn pro-next"><i class="fa-solid fa-angle-right"></i></div>
                </div>
            </div>
        </div>

        <jsp:include page="products.jsp"></jsp:include>
    </div>
    <%--footer--%>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {
            myIndex = 1
        }
        x[myIndex - 1].style.display = "block";
        setTimeout(carousel, 2000); // 2 giây chuyển
    }

    "use strict";

    productScroll();

    function productScroll() {
        let slider = document.getElementById("slider");
        let next = document.getElementsByClassName("pro-next");
        let prev = document.getElementsByClassName("pro-prev");
        let slide = document.getElementById("slide");
        let item = document.getElementById("slide");

        for (let i = 0; i < next.length; i++) {
            //refer elements by class name

            let position = 0; //slider postion

            prev[i].addEventListener("click", function () {
                //click previos button
                if (position > 0) {
                    //avoid slide left beyond the first item
                    position -= 1;
                    translateX(position); //translate items
                }
            });

            next[i].addEventListener("click", function () {
                if (position >= 0 && position < hiddenItems()) {
                    //avoid slide right beyond the last item
                    position += 1;
                    translateX(position); //translate items
                }
            });
        }

        function hiddenItems() {
            //get hidden items
            let items = getCount(item, false);
            let visibleItems = slider.offsetWidth / 210;
            return items - Math.ceil(visibleItems);
        }
    }

    function translateX(position) {
        //translate items
        slide.style.left = position * -210 + "px";
    }

    function getCount(parent, getChildrensChildren) {
        //count no of items
        let relevantChildren = 0;
        let children = parent.childNodes.length;
        for (let i = 0; i < children; i++) {
            if (parent.childNodes[i].nodeType != 3) {
                if (getChildrensChildren)
                    relevantChildren += getCount(parent.childNodes[i], true);
                relevantChildren++;
            }
        }
        return relevantChildren;
    }
</script>
</body>
</html>
