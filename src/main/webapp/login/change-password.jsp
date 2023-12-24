<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ChangePassword</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="./css/changepass.css">
</head>
<body>
<div id="container">
    <form action="<%=request.getContextPath()%>/changepassword" method="post">
        <section id="head"><h1>Đổi mật khẩu</h1></section>
        <label for="email">Nhap Email</label>
        <br>
        <input type="email" name="email" id="email" placeholder="Email">
        <label for="currentpassword">Mật khẩu cũ</label>
        <br>
        <input type="password" name="currentpassword" placeholder="Mật khẩu cũ" id="currentpassword">
        <br>
        <label for="newpassword">Mật khẩu mới</label>
        <br>
        <input type="password" name="newpassword" placeholder="Mật khẩu mới " id="newpassword">
        <br>
        <label for="repeatpassword">Nhập lại mật khẩu mới</label>
        <br>
        <input type="password" name="repeatpassword" placeholder="Mật khẩu mới" id="repeatpassword">
        <div id="btn">
            <button>
                Đổi mật khẩu
            </button>
        </div>
    </form>
</div>
</body>
</html>
