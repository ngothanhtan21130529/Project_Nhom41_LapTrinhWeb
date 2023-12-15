<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 12/19/2023
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<<< HEAD:src/main/webapp/views/contact.jsp
========
<link href="../../css/style.css" rel="stylesheet" type="text/css">
>>>>>>>> 3903fc4 (commit):src/main/webapp/views/product/product-details.jsp
<html>
<head>
    <title>Liên hệ</title>
    <link rel="stylesheet" href="css/contact.css?v=2">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css" type="text/css">
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="place">
        <div class="place-img">
            <img src="${pageContext.request.contextPath}/img/dai-hoc-long-lam.jpg" alt="">
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
        <form method="post" action="<%=request.getContextPath()+"/feedback"%>" method="post">
            <div class="contact-us-right-box">
                <div class="contact-us-label">
                    LIÊN HỆ VỚI CHÚNG TÔI
                </div>
                <input type="text" class="full-name input-box" placeholder="Họ tên(*)" name="fullname">
                <input type="text" class="phone-num input-box" placeholder="Số điện thoại(*)" name="phone">
                <input type="text" class="email input-box" placeholder="Email" name="email">
                <input type="text" class="title input-box" placeholder="Tiêu đề" name="phone">
                <textarea name="content" id="content" class="content input-box" cols="30" rows="10"
                          placeholder="Nội dung" name="content"></textarea>
                <button class="sending" type="submit">
                    Gửi
                </button>
            </div>
        </form>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</html>
