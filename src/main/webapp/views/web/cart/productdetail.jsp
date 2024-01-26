<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 11/21/2023
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<div>
    <h1><%="VIÊN SPINEL HỒNG DÂU LỤC YÊN 3,56CT"%>
    </h1>
    <img src="https://iruby.vn/wp-content/uploads/2023/12/Vien-Spinel-hong-dau-Luc-Yen-356ct-IRSI76-231235600000.jpg"
         width="100px" height="100px">
    <p><%=2%>
    </p>
    <button style="background: #3d8c18; width: 50px; height: 50px; cursor: pointer">
        <a href="${pageContext.request.contextPath}/addproducts?name=<%="VIÊN SPINEL HỒNG DÂU LỤC YÊN 3,56CT"%>&img=<%="https://iruby.vn/wp-content/uploads/2023/12/Vien-Spinel-hong-dau-Luc-Yen-356ct-IRSI76-231235600000.jpg"%>&price=<%=2%>">Mua
            hàng</a>
    </button>
    <h1><%="VIÊN SPINEL ĐỎ RỰC LỬA CHIẾU TOÀN VIÊN 2,56CT"%>
    </h1>
    <img src="https://iruby.vn/wp-content/uploads/2023/12/Vien-Spinel-do-ruc-lua-chieu-toan-vien-256ct-IRSI75-231225600000-1.jpg"
         width="100px" height="100px">
    <p><%=2%>
    </p>
    <button style="background: #3d8c18; width: 50px; height: 50px; cursor: pointer">
        <a href="${pageContext.request.contextPath}/addproducts?name=<%="VIÊN SPINEL ĐỎ RỰC LỬA CHIẾU TOÀN VIÊN 2,56CT"%>&img=<%="https://iruby.vn/wp-content/uploads/2023/12/Vien-Spinel-do-ruc-lua-chieu-toan-vien-256ct-IRSI75-231225600000-1.jpg"%>&price=<%=2%>">Mua
            hàng</a>
    </button>
<%--    <button style="background: #3d8c18; width: 50px; height: 50px; cursor: pointer">--%>
<%--        <a href="${pageContext.request.contextPath}/removeproducts?name=<%="VIÊN SPINEL HỒNG DÂU LỤC YÊN 3,56CT"%>&img=<%="https://iruby.vn/wp-content/uploads/2023/12/Vien-Spinel-hong-dau-Luc-Yen-356ct-IRSI76-231235600000.jpg"%>&price=<%=2%>">Xóa--%>
<%--            hàng</a>--%>
<%--    </button>--%>
<%--    <form action="${pageContext.request.contextPath}/orderdetails" method="post">--%>
<%--        <input type="number" name="quantity" width="500px">--%>
<%--        <button style="background: #3d8c18; width: 50px; height: 50px; cursor: pointer">--%>
<%--            Thanh toán--%>
<%--        </button>--%>
</div>

</body>
</html>

