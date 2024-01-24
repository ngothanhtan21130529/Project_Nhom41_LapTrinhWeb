<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 12/28/2023
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông báo đổi mật khẩu</title>

</head>
<body>
<h1>Đổi mật khẩu thành công bạn sẽ được chuyển trang sau 3 giây</h1>
</body>
<script>
    function popupnotify(){
       window.location.replace("<%=request.getContextPath()%>/views/index.jsp");
    }
    setTimeout(popupnotify,3000);
</script>
</html>
