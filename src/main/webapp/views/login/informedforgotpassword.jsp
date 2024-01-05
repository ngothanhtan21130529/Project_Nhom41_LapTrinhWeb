<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/4/2024
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông báo cập nhật mật khẩu thành công</title>
</head>
<body>
<h1>Cập nhật mật khẩu thành công!!!Sẽ chuyển trang sau 3 giây nữa</h1>
</body>
<script>
    setTimeout(function () {
        window.location.replace("<%=request.getContextPath()%>/views/login/login.jsp")
    }, 3000);
</script>
</html>
