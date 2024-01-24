<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/6/2024
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanh toán thành công</title>
</head>
<body>
<h1>Thanh toán thành công sẽ chuyển về trang chủ trong 3 giây nữa</h1>
</body>
<script>
    setTimeout(function(){
        window.location.replace("http://localhost:8080/Project_Nhom_41_war/view/index.jsp");
    }, 3000);
</script>
</html>
