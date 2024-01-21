<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quên Mật Khẩu</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/forgotpassword.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
<div id="container">

    <form action="<%=request.getContextPath()%>/forgot" method="post">
        <div class="item">
            <h2>Quên Mật Khẩu</h2>
        </div>
        <div class="item">
            <label for="email">Nhập email để khôi phục</label>
        </div>
        <div class="item">
            <input type="email" name="email" id="email" placeholder="Nhập email">
        </div>
        <div id="btn">
            <button>Xác nhận</button>
            <a href="<%=request.getContextPath()%>/login/login.jsp">Đăng nhập</a>
        </div>

    </form>
</div>
</body>
</html>