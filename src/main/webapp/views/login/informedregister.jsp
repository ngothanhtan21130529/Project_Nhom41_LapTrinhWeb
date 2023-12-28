<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 12/28/2023
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông báo Đăng kí</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/informedregister.css" type="text/css">
</head>
<body>
    <div>
       <a href="<%=request.getContextPath()%>/views/login/login.jsp"> <h1> <%=(session!=null&&session.getAttribute("informed")!=null)?session.getAttribute("informed"):""%></h1></a>

    </div>
</body>
</html>
