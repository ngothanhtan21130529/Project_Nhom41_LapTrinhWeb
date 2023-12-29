<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 12/28/2023
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên Mật Khẩu</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/forgotpassword.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
<form action="<%=request.getContextPath()%>/forgotpassword" method="post">
    <div class="title"><h1>Quên mật khẩu</h1></div>
    <div class="item">
        <input type="email" name="email" id="email" placeholder="Nhập email" style="width: 300px;border-radius: 6px">
    </div>
    <div id="btn">
        <div>
            <button type="submit">Xác nhận</button>
        </div>
        <a href="<%=request.getContextPath()%>/views/login/login.jsp" id="login">Đăng nhập</a>
        <a href="<%=request.getContextPath()%>/views/login/register.jsp" id="register">Đăng kí</a>
    </div>

</form>
</div>
</body>
</html>
