<%--
  Created by IntelliJ IDEA.
  User: nttan
  Date: 1/19/2024
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lí đơn hàng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderdetail.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
<div id="button">
    <button style="color:red;width:200px;height: 200px">Thêm dữ liệu</button>
</div>
<div id="data">

</div>
</body>
<script>
    function loaddata(){
        $.ajax({
            url: "ordermanage",
            type: "GET",
            success: function (response) {
                let data = document.getElementById("data");
                for(let i=0;i<response.length;i++){
                    data.innerHTML+=response[i];
                }
            },
            error: function (error) {
            console.log("lỗi không load được dữ liệu");
            }
        });
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</html>
