<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Font+Name">
    <link rel="stylesheet" href="css/register.css">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.css">
    <link href="../css/register.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div id="container">
        <div class="img-register">
            <img src="./img/banner/TTN-2.png">
        </div>
        <form action="./register" method="post">
            <div class="logo">
                <img src="img/logo.png">
            </div>
            <div id="dang_ki">
                <h2>Đăng ký</h2>
            </div>
            <div id="thongtin">
<%--                <label for="hoten">Họ và tên:</label>--%>
                <br>
                <input type="text" name="hoten" placeholder="Họ tên">
                <br>
<%--                <label for="taikhoan">Tài khoản:</label>--%>
                <br>
                <input type="text" name="user" placeholder="Tài khoản">
                <br>
<%--                <label for="matkhau">Mật khẩu:</label>--%>
                <br>
                <input type="password" name="pass" placeholder="Mật khẩu">
                <br>
<%--                <label for="nhaplai">Nhập lại mật khẩu:</label>--%>
                <br>
                <input type="password" name="nhaplai" placeholder="Nhập lại mật khẩu">
                <br>
<%--                <label for="e_mail">Email:</label>--%>
                <br>
                <input type="email" name="email" placeholder="Nhập email">
                <br>
<%--                <label for="ngaysinh">Ngày sinh:</label>--%>
                <br>
                <input type="date" name="ngaysinh">
                <br>

<%--                <label for="dienthoai">Số điện thoại:</label>--%>
                <br>
                <input type="tel" name="dienthoai">
                <br>
                <div class="commit">
                <input type="checkbox" name="dieukhoan" id="dieukhoan">Tôi cam kết đã đọc và chấp nhận tất cả điều khoản và điều kiện của dịch vụ/sản phẩm này.
                </div>
                <button id="btn" >Đăng ký</button>

            </div>
        </form>
    </div>
</body>

</html>