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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css
">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css">
</head>
<body>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<div id="data">
    <button><a href="#">Hồ sơ</a></button>
</div>
<div>
    <table class="table table-striped" id="table-list" style="width:50%">
        <tr>
            <th>Mã đơn hàng</th>
            <th>Tên khách hàng</th>
            <th>Ngày đặt hàng</th>
            <th>Ngày giao hàng</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        <tr>
            <td>1</td>
            <td>Nguyễn Thị Thanh Huyền</td>
            <td>20/10/2021</td>
            <td>20/10/2021</td>
            <td>Đã giao</td>
            <td>
                <button><a href="#">Chi tiết</a></button>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>Nguyễn Thị Thanh Huyền</td>
            <td>20/10/2021</td>
            <td>20/10/2021</td>
            <td>Đã giao</td>
            <td>
                <button><a href="#">Chi tiết</a></button>
            </td>
        </tr>
        <tr>
            <td>3</td>
            <td>Nguyễn Thị Thanh Huyền</td>
            <td>20/10/2021</td>
            <td>20/10/2021</td>
            <td>Đã giao</td>
            <td>
                <button><a href="#">Chi tiết</a></button>
            </td>
        </tr>
        <tr>
            <td>4</td>
            <td>Nguyễn Thị Thanh Huyền</td>
            <td>20/10/2021</td>
            <td>20/10/2021</td>
            <td>Đã giao</td>
            <td>
                <button><a href="#">Chi tiết</a></button>
            </td>
        </tr>
        <tr>
            <td>5</td>
            <td>Nguyễn Thị Thanh Huyền</td>
            <td>20/10/2021</td>
            <td>20/10/2021</td>
        </tr>
    </table>
</div>
<%--<jsp:include page="footer.jsp"></jsp:include>--%>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#table-list').DataTable();
    });
</script>
</html>
