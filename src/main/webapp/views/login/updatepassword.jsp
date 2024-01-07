<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/4/2024
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật mật khẩu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/updatepassword.css" type="text/css">
</head>
<body>
<div style="color: red"><%=(request.getAttribute("notification")!=null?request.getAttribute("notification"):"")%></div>
<form action="<%=request.getContextPath()%>/updatepassword" method="post">
    <section id="head"><h1>Cập nhật mật khẩu mới</h1></section>
    <input type="hidden" name="email" value="<%=request.getAttribute("email")!=null?request.getAttribute("email"):""%>">
    <label for="newpassword" class="new-password-label">Mật khẩu mới</label>
    <label for="repeatpassword" class="retype-password-label">Nhập lại mật khẩu mới</label>
    <input type="password" name="newpassword" placeholder="Mật khẩu mới" id="newpassword">
    <input type="password" name="repeatpassword" placeholder="Mật khẩu mới" id="repeatpassword">
    <div id="btn">
        <button>
         Cập nhật mật khẩu mới
        </button>
    </div>
</form>
</body>
</html>
