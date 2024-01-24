<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Font+Name">
    <link rel="stylesheet" href="css/login.css">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="../../css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    <div style="color:red"><%=(request.getAttribute("notify")!=null ? request.getAttribute("notify") : "")%>
    </div>
    <div class="img-ttn">
        <img src="./img/banner/TTN.png">
    </div>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <div id="logo">
            <img src="./img/logo.png" alt="logo">
        </div>
        <div id="log_in">
            <h1>Đăng nhập</h1>
        </div>
        <div id="username_password">
            <label for="username">Tài khoản:</label>
            <input type="text" name="username" placeholder="username" value="" id="username">
            <br>
            <label for="password">Mật khẩu:</label>
            <input type="password" name="password" placeholder="password" value="" id="password">
        </div>

        <div id="login">
            <button id="submit"><h2>Đăng nhập</h2></button>
        </div>
        <div id="register_forget">
            <div id="register">
                <a href="register.jsp">Đăng ký</a>
            </div>
            <div id="forget_pass">
                <a href="forgot-password.html">Quên mật khẩu ?</a>
            </div>
        </div>
<%--        <div id="remember">--%>
<%--            <input type="checkbox" id="checkbox">--%>
<%--            <h3 id="text_ghi_nho">Ghi nhớ đăng nhập</h3>--%>
<%--        </div>--%>
    </form>
</div>
</body>
</html>
