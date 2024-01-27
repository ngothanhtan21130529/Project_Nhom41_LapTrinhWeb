<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Trang chủ</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="../font/fontawesome-free-6.4.2/css/all.css">
    <link href="<%=request.getContextPath()%>/css/footer.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/tablist.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/details.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <%--    header--%>
    <jsp:include page="/views/header.jsp"></jsp:include>
    <%--    main--%>
    <div class="container" style="margin-top: 150px">
        <div class="light-box">
            <div class="slide-img">
                <c:forEach var="image" items="${productDetail.images}">
                    <div class="slide">
                        <img src="<c:out value="${image}" />" alt="">
                    </div>
                </c:forEach>
            </div>
            <div class="queue">
                <c:forEach var="image" items="${productDetail.images}" varStatus="loop">
                    <img class="col-${loop.index+1} row ${loop.index == 0 ? 'active' : ''}"
                         src="<c:out value="${image}" />"
                         alt="" onclick="change_to(event, '.slide-${loop.index+1}','col-${loop.index+1}')">
                </c:forEach>
            </div>
            <div class="close" onclick="blur_img()">&times;</div>
            <a class="prev" onclick="next_slide(-1)" style="color: black">&#10094;</a>
            <a class="next" onclick="next_slide(1)" style="color: black">&#10095;</a>
        </div>
        <div class="details non-light-box">
            <div class="details-text-box">
                <div class="product-id">
                    Mã: ${productDetail.getId()}
                </div>
                <div class="product-name">
                    ${productDetail.getProductName()}
                </div>

                <div class="black-line"></div>

                <div class="rating">
                    <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                    <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                    <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                    <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                    <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                </div>
                <div class="price">
                    <fmt:formatNumber pattern="###,###,### VNĐ" value="${productDetail.price}" />
                </div>
                <div class="status" style="position: absolute; margin-left: 20%; width: 300px; padding-top: 10px"><c:out value="${productDetail.status}" />
                </div>
                <div class="description-product">
                    <p>
                        ${productDetail.getDescription()}
                    </p>
                </div>
                <div class="criteria-product">
                    <ul>
                        <li>
                            Độ trong, sạch, lỗi: sạch 100%, lỗi rạn
                        </li>
                        <li>
                            Kiểm định và bảo hành trọn đời.
                        </li>
                        <li>
                            Miễn phí vận chuyển toàn quốc
                        </li>
                        <li>
                            Ship đảm bảo Quốc tế
                        </li>
                    </ul>
                </div>
                <div class="recommendation">
                    <p>
                        Hình ảnh, video trên website có thể chưa thể hiện vẻ đẹp, rõ nét nhất của thiết kế, kính mời quý
                        Anh/Chị liên hệ trực tiếp tham quan, trải nghiệm thực tế theo số ĐT: <a href="#">0856 174
                        581</a> hoặc qua
                        Zalo/Wechat: <a href="#">0856 174 581</a>để biết thêm chi tiết.
                    </p>
                </div>
                <div class="advice">
                    Tư vấn và thiết kế miễn phí 100%, đặt hàng theo mẫu khi quý khách mua Mẫu 3D của sản phẩm Spinel tím
                    ánh kim KG-SPF-027
                </div>
                <div class="payment-cart">
                    <a href="#" class="payment-button">
                        THANH TOÁN
                    </a>
                    <a href="#" class="cart-button">
                        GIỎ HÀNG
                    </a>
                </div>
                <div class="contact">
                    <div class="phone">
                        <i class="fa-solid fa-phone fa-sm" style="color: #495569;"></i>
                        Hotline:
                        <div class="phone-num">
                            0856 174 581
                        </div>
                    </div>
                    <div class="zalo">
                        Zalo:
                        <div class="zalo-num">0856 174 581</div>
                    </div>
                </div>
                <div class="social-contact">
                    <div class="contact-method">
                        <div class="facebook-icon">
                            <a href="#">
                                <i class="fa-brands fa-facebook fa-lg" style="color: #3a589d;"></i>
                            </a>
                        </div>
                        <div class="twitter-icon">
                            <a href="#">
                                <i class="fa-brands fa-square-twitter fa-lg" style="color: #2478ba;"></i>
                            </a>
                        </div>
                        <div class="google-plus-icon">
                            <a href="#">
                                <i class="fa-brands fa-google-plus fa-lg" style="color: #dd4e31;"></i>
                            </a>
                        </div>
                        <div class="mail-icon">
                            <a href="#">
                                <i class="fa-solid fa-envelope fa-lg" style="color: #111;"></i>
                            </a>
                        </div>
                        <div class="linkedin-icon">
                            <a href="#">
                                <i class="fa-brands fa-linkedin fa-lg" style="color: #0072b7;"></i>
                            </a>
                        </div>
                    </div>
                    <div class="share-on-social-media">
                        SHARE ON SOCIAL MEDIA
                    </div>
                </div>
            </div>
        </div>
        <div class="information-products">
            <div class="tab">
                <button class="tablinks" onclick="toggleTab(event, 'Tab1')"> Thông số kỹ thuật <i
                        class="fas fa-chevron-down"></i></button>
                <div id="Tab1" class="tabcontent">
                    <div class="column">
                        <ul>
                            <li><span>Loại đá:</span> Ruby</li>
                            <li><span>Màu đá:</span> Đỏ</li>
                            <li><span>Trọng lượng:</span> 1 carat</li>
                            <li><span>Kiểu cắt/mài: </span></li>
                        </ul>
                    </div>
                    <div class="column">
                        <ul>
                            <li><span>Kích thước:</span> 2.5x12-3.5mm</li>
                            <li><span>Độ trong:</span> Chất ngọc làm sạch</li>
                            <li><span> Chất liệu:</span> Chất liệu từ thiên nhiên</li>
                            <li><span>Mô tả:</span> ...</li>
                        </ul>
                    </div>
                </div>

                <button class="tablinks" onclick="toggleTab(event, 'Tab2')"> Bình luận <i class="fas fa-chevron-down"></i>
                </button>
                <div id="Tab2" class="tabcontent">
                    <div class="comment">
                        <div class="customer-name">tran tu nguyet</div>
                        <div class="media-upload">
                            <img class="image-upload" src="img/twitter_profile_image.png" alt="Image">
                            <video class="video-upload" controls>
                                <source src="video.mp4" type="video/mp4">
                            </video>
                        </div>
                        <p class="comment-text">Đẹp dữ lắm.</p>
                        <button class="btn-comment" onclick="openPopup()">Viết bình luận</button>
                    </div>

                    <div id="popup" class="popup">
                        <button class="btn-close" onclick="closePopup()"><i class="fas fa-times"></i></i></button>
                        <textarea placeholder="Viết bình luận"></textarea>
                        <div class="input-comment">
                            <input class="input-text" type="text" placeholder="Nhập tên">
                            <input class="input-file" type="file" accept="image/*">
                        </div>
                        <button class="btn-submit">Gửi</button>
                    </div>
                </div>
                <button class="tablinks" onclick="toggleTab(event, 'Tab3')"> Câu hỏi thường gặp <i
                        class="fas fa-chevron-down"></i></button>
                <div id="Tab3" class="tabcontent">
                    <h3>Mua Online có ưu đãi gì đặc biệt cho tôi?</h3>
                    <p>- Ưu đãi độc quyền Online với hình thức thanh toán đa dạng.</p>
                    <p>- Đặt giữ hàng Online, nhận tại cửa hàng.</p>
                    <h3>Có thu mua lại trang sức không?</h3>
                    <p>TTN có thu mua lại trang sức, nếu quý khách hàng muốn bán lại trang sức có thể liên hệ
                        thông
                        qua các phương thức liên hệ bên dưới. Chi tiết: <a href="views/contact.jsp">tại đây</a></p>
                </div>
            </div>
        </div>
        <div class="contact-number-choosing non-light-box">
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
    <%--    footer--%>
    <jsp:include page="/views/footer.jsp"></jsp:include>
    <script>
        function open_tab(evt, tab_name) {
            var i, tab_content, tab_links;

            tab_content = document.getElementsByClassName('tab-content');
            for (let i = 0; i < tab_content.length; i++) {
                tab_content[i].style.display = 'none';
            }

            tab_links = document.getElementsByClassName('tablinks');
            for (let i = 0; i < tab_links.length; i++) {
                tab_links[i].className = tab_links[i].className.replace(' active', '');
            }

            document.getElementById(tab_name).style.display = 'block';
            evt.currentTarget.className += ' active';
        }

        function scroll_down() {
            var screen = document.querySelector('.table-contents');
            if (screen.style.display == 'block' || screen.style.display == '') {
                screen.style.display = 'none';
            } else if (screen.style.display = 'none') {
                screen.style.display = 'block';
            }
        }

        document.getElementById('default-open').click();

        function blur_img() {
            let current = document.querySelectorAll('.img');
            let non_light_box = document.querySelectorAll('.non-light-box');
            non_light_box.forEach(element => {
                if (element.style.filter == 'blur(20px) brightness(50%)') {
                    element.style.filter = 'blur(0px) brightness()';
                    element.style.userSelect = 'auto';
                } else {
                    element.style.filter = 'blur(20px) brightness(50%)';
                    element.style.userSelect = 'none';
                }
            });

            if (document.body.style.overflow != 'hidden') {
                document.body.style.overflow = 'hidden';
            } else {
                document.body.style.overflow = 'auto';
            }
            let light_box = document.querySelector('.light-box');
            let queue = document.querySelector('.queue');
            if (light_box.style.visibility != 'visible') {
                document.querySelector('.default').style.visibility = 'visible';
                light_box.style.visibility = 'visible';
            } else {
                let slide_img = document.querySelectorAll('.slide');
                slide_img.forEach(element => {
                    element.style.visibility = 'hidden';
                });
                light_box.style.visibility = 'hidden';
            }
            let row = document.querySelectorAll('.row');
            row.forEach(e => {
                e.classList.remove('active');
            })
            document.querySelector('.col-1').className += ' active';
        }

        function change_to(event, img, selector) {
            let current = document.querySelectorAll(".slide");
            let queue = document.querySelectorAll('.row');
            current.forEach(current => {
                current.style.visibility = 'hidden';
            });
            queue.forEach(element => {
                element.classList.remove('active');
            });
            document.querySelector(img).style.visibility = 'visible';
            event.currentTarget.className += ' active';
        }

        var slide_index = 0;

        function next_slide(n) {
            show_slide(slide_index += n);
        }

        function show_slide(n) {
            let slides = document.querySelectorAll('.slide');
            let dots = document.querySelectorAll('.row');
            if (n == slides.length) slide_index = 0;
            else if (n < 0 || isNaN(n)) slide_index = slides.length - 1;
            slides.forEach(element => {
                element.style.visibility = 'hidden';
            });
            for (let i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(' active', '');
            }
            slides[slide_index].style.visibility = 'visible';
            dots[slide_index].className += ' active';
        }

        function setHiddenFieldValues() {
            var name = document.querySelector('.product-name');
            var price = document.querySelector('.price');
            var img = document.querySelector('.first-img').src;
            var nameHidden = document.querySelector('.nameHidden');
        }
    </script>
    <script>
        // Function to toggle a specific tab
        function toggleTab(evt, tabName) {
            var tabcontent = document.getElementById(tabName);

            if (tabcontent.style.display === "none") {
                // Hide all tab content
                var tabcontents = document.getElementsByClassName("tabcontent");
                for (var i = 0; i < tabcontents.length; i++) {
                    tabcontents[i].style.display = "none";
                }

                // Remove the "active" class from all tab buttons
                var tablinks = document.getElementsByClassName("tablinks");
                for (var i = 0; i < tablinks.length; i++) {
                    tablinks[i].classList.remove("active");
                }

                // Show the specific tab content and mark the button as active
                tabcontent.style.display = "block";
                evt.currentTarget.classList.add("active");
            } else {
                // Toggle off the specific tab content and remove the "active" class from the button
                tabcontent.style.display = "none";
                evt.currentTarget.classList.remove("active");
            }
        }

        //     popup
        function openPopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "block";
        }

        function closePopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "none";
        }
    </script>
    <script>
        // Function to toggle a specific tab
        function toggleTab(evt, tabName) {
            var tabcontent = document.getElementById(tabName);

            if (tabcontent.style.display === "none") {
                // Hide all tab content
                var tabcontents = document.getElementsByClassName("tabcontent");
                for (var i = 0; i < tabcontents.length; i++) {
                    tabcontents[i].style.display = "none";
                }

                // Remove the "active" class from all tab buttons
                var tablinks = document.getElementsByClassName("tablinks");
                for (var i = 0; i < tablinks.length; i++) {
                    tablinks[i].classList.remove("active");
                }

                // Show the specific tab content and mark the button as active
                tabcontent.style.display = "block";
                evt.currentTarget.classList.add("active");
            } else {
                // Toggle off the specific tab content and remove the "active" class from the button
                tabcontent.style.display = "none";
                evt.currentTarget.classList.remove("active");
            }
        }

        //     popup
        function openPopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "block";
        }

        function closePopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "none";
        }
    </script>
</div>
</body>
</html>