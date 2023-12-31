<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 12/28/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đổi mật khẩu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/change-pass.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    <div><h1><%=(session!=null&&session.getAttribute("notify")!=null)?session.getAttribute("notify"):""%></h1></div>
    <form action="<%=request.getContextPath()%>/changepassword" method="post">
        <section id="head"><h1>Đổi mật khẩu</h1></section>
<%--        <label for="email" class="email-label">Nhập Email</label>--%>
        <label for="currentpassword" class="current-password-label">Mật khẩu cũ</label>
<%--        <input type="email" name="email" id="email" placeholder="Email">--%>
        <input type="password" name="currentpassword" placeholder="Mật khẩu cũ" id="currentpassword">
        <label for="newpassword" class="new-password-label">Mật khẩu mới</label>
        <label for="repeatpassword" class="retype-password-label">Nhập lại mật khẩu mới</label>
        <input type="password" name="newpassword" placeholder="Mật khẩu mới" id="newpassword">
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
