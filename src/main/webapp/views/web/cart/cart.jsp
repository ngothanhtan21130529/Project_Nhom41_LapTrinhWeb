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
    <h1><%="Item_1"%>
    </h1>
    <img src="https://iruby.vn/wp-content/uploads/2023/10/Vien-Peridot-xanh-la-ma-chieu-dep-407ct-IRPD36-231040700000.jpg"
         width="100px" height="100px">
    <p><%=2%>
    </p>
    <button style="background: #3d8c18; width: 50px; height: 50px; cursor: pointer">
        <a href="${pageContext.request.contextPath}/addproducts?name=<%="Item_1"%>&img=<%="https://iruby.vn/wp-content/uploads/2023/10/Vien-Peridot-xanh-la-ma-chieu-dep-407ct-IRPD36-231040700000.jpg"%>&price=<%=2%>">Mua
            hàng</a>
    </button>
    <button style="background: #3d8c18; width: 50px; height: 50px; cursor: pointer">
        <a href="${pageContext.request.contextPath}/removeproducts?name=<%="Item_1"%>&img=<%="https://iruby.vn/wp-content/uploads/2023/10/Vien-Peridot-xanh-la-ma-chieu-dep-407ct-IRPD36-231040700000.jpg"%>&price=<%=2%>">Xóa
            hàng</a>
    </button>
    <form action="${pageContext.request.contextPath}/orderdetails" method="post">
        <input type="number" name="quantity" width="500px">
        <button style="background: #3d8c18; width: 50px; height: 50px; cursor: pointer">
            Thanh toán
        </button>
    </form>

</div>

</body>
</html>

