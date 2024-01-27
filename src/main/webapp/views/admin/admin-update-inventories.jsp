<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 26/01/2024
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="css/admin-adding-product.css?v=234" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/admin.js" type="text/javascript">
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
                    <a href="<%=request.getContextPath()%>/home">
                        <i class="fa-solid fa-tent-arrow-turn-left fa-sm" style="color: #B4B4B4 ;"></i>
                        Vào trang web
                    </a>
                </li>
                <li style="border-right: 1px solid #939393;" class="top-bar-element">
                    <a href="<%=request.getContextPath()%>/feedback">
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
            </div>
            <div class="ui-management">
                <button class="ui-management-button gray-color">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-list fa-sm" style="color: #428bca;"></i>
                        Quản trị giao diện
                    </a>
                </button>
            </div>
            <div class="information-management">
                <button class="information-management-button gray-color">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-dollar-sign fa-sm" style="color: #428bca;"></i>
                        Quản trị thông tin
                    </a>
                </button>
            </div>
            <div class="user-configuration">
                <button class="user-configuration-button gray-color">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="fa-solid fa-user fa-sm" style="color: #428bca;"></i>
                        Cấu hình người dùng
                    </a>
                </button>
            </div>
        </div>
        <div class="content-bar">
            <div class="product-tab">
                <form method="post" action="<%=request.getContextPath()%>/updateInventories">
                    <div class="user-information content-tab">
                        <div class="user-information-label">
                            Số lượng sản phẩm tồn kho
                        </div>
                        <div class="account-username-label">
                            <p>
                                Mã sản phẩm:
                            </p>
                        </div>
                        <div class="account-username">
                            <input type="text" name="id" value="${inventories.getId()}" readonly>
                        </div>
                        <div class="account-fullname-label">
                            <p>
                                Tên sản phẩm:
                            </p>
                        </div>
                        <div class="account-fullname-input">
                            <input type="text" name="name" value="${inventories.getProductName()}" readonly>
                        </div>
                        <div class="account-password-label">
                            <p>
                                Ngày tạo:
                            </p>
                        </div>
                        <div class="account-password-input">
                            <input type="text" value="${inventories.getCreatedAt()}" name="create-at" readonly>
                        </div>
                        <div class="account-password-label">
                            <p>
                                Còn lại:
                            </p>
                        </div>
                        <div class="account-password-input">
                            <input type="text" value="${inventories.getQuantity()}" name="quantity">
                        </div>
                        <div class="save-or-exit-box">
                            <button class="save-button">
                                Lưu
                            </button>
                            <button class="exit-button">
                                <a href="<%=request.getContextPath()%>/admin">
                                    Thoát
                                </a>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
