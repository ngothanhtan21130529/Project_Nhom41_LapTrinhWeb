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
<h1>
    Đăng kí thành công bạn sẽ được chuyển trang sau 3 giây nữa</h1>

</body>
<script>
   function notify() {
       window.location.replace( "<%=request.getContextPath()%>/views/index.jsp") ;
   }
   setTimeout(notify,3000);

</script>
</html>
