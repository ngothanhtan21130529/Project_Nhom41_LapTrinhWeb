<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 12/22/2023
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Xin chào </h1>
<h2><%
 Cookie [] cookies=   request.getCookies();
 for(Cookie cookie:cookies){%>
     <h2><%=cookie%></h2>
<% }%>
</h2>
</body>
</html>
