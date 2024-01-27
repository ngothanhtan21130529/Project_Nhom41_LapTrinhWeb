<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/admin" method="get">
    <button type="submit">submit</button>
</form>
<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/Test">
    <input class="choosing-button" type="file" name="thumnail" accept="image/*">
    <input class="choosing-button" type="file" name="imgs" accept="image/*"
           multiple="multiple">
    <input name="a">
    <input name="b">
    <input name="c">
    <input name="d">
    <input name="e">
    <button type="submit">submit</button>
</form>
<script>
</script>
</body>
</html>
