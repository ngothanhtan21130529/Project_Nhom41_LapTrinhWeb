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
    <title>Quên mật khẩu</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/forgotpassword" method="post">
        <input type="text">
        <input type="submit">
    </form>
</body>
</html>
