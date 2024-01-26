<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/21/2024
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang cá nhân</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="css/personal.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.css">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
</head>
<body>
<div id="container">
    <div class="ui">
        <div class="tab-bar">
            <div class="profile">
                <button class="profile-button">
                    Hồ sơ cá nhân
                </button>
            </div>
            <div class="order">
                <button class="order-button">
                    Hóa đơn
                </button>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/updateprofile" class="form" method="post">
            <div class="image">
                <img src="${pageContext.request.contextPath}/img/avatar.png" alt="">
            </div>
            <div class="item">
                <label for="name">Họ và tên:</label>
                <br>
                <input type="text" id="name">
                <br>
                <label for="phone">Số điện thoại:</label>
                <br>
                <input type="text" id="phone">
                <br>
                <label for="email">Email:</label>
                <br>
                <input type="email" id="email">
                <br>
                <label for="address">Địa chỉ:</label>
                <br>
                <input type="address" id="address">
                <br>
                <label for="gender" class="gender-label">Giới tính:</label>
                <br>
                <div id="gender">
                    <input type="radio" name="gender">Nam
                    <input type="radio" name="gender">Nữ
                    <input type="radio" name="gender">Khác
                </div>
                <div class="date">
                    <label for="date">Ngày sinh:</label>
                    <input type="date" id="date">
                </div>


                <button id="btn-change">
                    <i class="fa-solid fa-key fa-5xs"></i>
                    Đổi mật khẩu
                </button>
                <button id="save">
                    Lưu thay đổi
                </button>
            </div>

        </form>
    </div>
</div>
</body>
</html>
