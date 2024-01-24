<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/5/2024
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật ảnh đại diện</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/uploadimage" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file"/>
    <input type="submit" value="Upload" name="submit"/>
</form>
</body>
</html>
