<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.hcmuaf.model.Category" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="vn.edu.hcmuaf.dao.ProductDAO" %>
<%@ page import="vn.edu.hcmuaf.dao.CategoryDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hoá đơn chi tiết</title>
    <link rel="stylesheet" href="css/admin-order-details.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    </script>
    <%--    jQuerry--%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <%--    Data Table--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css" type="text/css">
    <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <%--    JavaScript--%>
    <script src="<%=request.getContextPath()%>/js/adminDataTable.js"></script>
</head>
<body>
<div class="container">
    <div class="top-bar">
        <div class="left-top-bar">
            <ul>
                <li style="border-right: 1px solid #939393;" class="top-bar-element">
                    Administrator
                </li>
                <li style="border-right: 1px solid #939393;" class="top-bar-element">
                    <a href="<%=request.getContextPath()%>/views/index.jsp">
                        <i class="fa-solid fa-tent-arrow-turn-left fa-sm" style="color: #B4B4B4 ;"></i>
                        Vào trang web
                    </a>
                </li>
                <li style="border-right: 1px solid #939393;" class="top-bar-element">
                    <a href="<%=request.getContextPath()%>/views/contact.jsp">
                        Liên hệ
                    </a>
                </li>
                <li style="cursor: pointer;" class="top-bar-element">
                    Đơn hàng
                </li>
            </ul>
        </div>
        <div class="right-top-bar" class="top-bar-element">
            Xin chào admin
        </div>
    </div>
    <div class="ui">
        <div class="nav-bar">
            <div class="go-to-homepage-admin gray-color">
                <div class="hompage-admin">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-house fa-sm" style="color: #428bca;"></i>
                        Trang chủ admin
                    </a>
                </div>
            </div>
            <div class="categories-management">
                <button class="categories-management-button gray-color">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-table-cells-large fa-sm" style="color: #428bca;"></i>
                        Quản trị danh mục
                    </a>
                </button>
                <ul>
                    <li class="element categories-tab-element">
                        <div class="category-type">Loại danh mục</div>
                    </li>
                    <li class="element categories-tab-element">
                        <div class="category-product">Sản phẩm</div>
                    </li>
                </ul>
            </div>
            <div class="ui-management">
                <button class="ui-management-button gray-color">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-list fa-sm" style="color: #428bca;"></i>
                        Quản trị giao diện
                    </a>
                </button>
                <ul>
                    <li class="element ui-tab-element">
                        <div>Slide show sản phẩm</div>
                    </li>
                    <li class="element ui-tab-element">
                        <div>Slide show trang sức</div>
                    </li>
                    <li class="element ui-tab-element">
                        <div>Slide show đá quý</div>
                    </li>
                    <li class="element ui-tab-element">
                        <div>Slide show trang chủ</div>
                    </li>
                    <li class="element ui-tab-element">
                        <div>Hỗ trợ trực tuyến</div>
                    </li>
                    <li class="element ui-tab-element">
                        <div>Thông tin</div>
                    </li>
                </ul>
            </div>
            <div class="information-management">
                <button class="information-management-button gray-color">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-dollar-sign fa-sm" style="color: #428bca;"></i>
                        Quản trị thông tin
                    </a>
                </button>
                <ul>
                    <li class="element infor-tab-element">
                        <div>Danh sách đơn hàng</div>
                    </li>
                    <li class="element infor-tab-element">
                        <div>Khách hàng liên hệ</div>
                    </li>
                </ul>
            </div>
            <div class="user-configuration">
                <button class="user-configuration-button gray-color">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-user fa-sm" style="color: #428bca;"></i>
                        Cấu hình người dùng
                    </a>
                </button>
                <ul>
                    <li class="element user-config-element">
                        <div>Quản lý người dùng</div>
                    </li>
                    <li class="element user-config-element">
                        <div>Thông tin người dùng</div>
                    </li>
                    <li class="element user-config-element">
                        <div>Thoát</div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="content-bar">
            <div class="information-management">
                <div class="order-list content-tab">
                    <div class="order-list-table">
                        <table id="order-list-table">
                            <thead>
                            <tr>
                                <th>Mã đơn hàng</th>
                                <th>Tên sản phẩm</th>
                                <th>Giá thành</th>
                                <th>Số lượng</th>
                                <th>Tổng giá sản phẩm</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderDetailArrayList}" var="orderDetails">
                            <tr>
                                <td>${orderDetails.getOrderID()}</td>
                                <td>${orderDetails.getProductName()}</td>
                                <td>${orderDetails.getPrice()}</td>
                                <td>${orderDetails.getQuantity()}</td>
                                <td>${orderDetails.getTotalPrice()}</td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>