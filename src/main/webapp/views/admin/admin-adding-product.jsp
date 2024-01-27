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
    <link rel="stylesheet" href="css/admin-adding-product.css?v=123" type="text/css">
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
                <form method="post" action="<%=request.getContextPath()%>/addProduct"
                      enctype="multipart/form-data">
                    <c:set var="imgProductIsNull" value="${param.imgProductIsNull}"></c:set>
                    <c:if test="${imgProductIsNull=='imgProductIsNull'}">
                        <script>alert("Vui lòng thêm hình cho sản phẩm");</script>
                    </c:if>
                    <div class="product-adding-tab content-tab">
                        <div class="product-adding-tab-general-infomation">
                            <div class="general-infomation-label">
                                THÔNG TIN CHUNG
                            </div>
                            <div class="img-adding-label">
                                Hình thumbnail:
                            </div>
                            <div class="img-adding-url">
                                <input class="choosing-button" type="file" name="thumbnail" accept="image/*">
                            </div>
                            <div class="img-adding-label">
                                Hình ảnh:
                            </div>
                            <div class="img-adding-url">
                                <input class="choosing-button" type="file" name="imgs" accept="image/*"
                                       multiple="multiple">
                            </div>
                            <div class="categories-product-label">
                                Danh mục
                            </div>
                            <div class="categories-product-input">
                                <select name="category">
                                    <c:forEach items="${categoryNameArrayList}" var="category">
                                        <option value="${category.getId()}">${category.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Giá
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="price">
                                </div>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Giảm giá:
                                </p>
                            </div>
                            <div class="product-action-choose">
                                <input type="checkbox" name="sale">
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Sản phẩm mới:
                                </p>
                            </div>
                            <div class="product-action-choose">
                                <input type="checkbox" name="hot">
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Màu sắc:
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="color">
                                </div>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Độ trong suốt:
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="opacity">
                                </div>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Kích thước:
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="size">
                                </div>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Trọng lượng:
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="weight">
                                </div>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Hình cắt mài:
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="shape">
                                </div>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Chất liệu:
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="material">
                                </div>
                            </div>
                            <div class="product-price-label">
                                <p>
                                    Số lượng trong kho:
                                </p>
                            </div>
                            <div class="product-price-input-output">
                                <div class="product-price-input">
                                    <input type="text" name="quantity">
                                </div>
                            </div>
                        </div>
                        <div class="product-tab-detail-information">
                            <div class="details-infomation-label">
                                THÔNG TIN CHI TIẾT
                            </div>
                            <div class="title-product">
                                Tiêu đề sản phẩm:
                            </div>
                            <div class="title-input-box">
                                <input type="text" name="name">
                            </div>
                            <div class="product-description-label">
                                Mô tả:
                            </div>
                            <div class="product-description-input">
                                <input type="text" placeholder="Nhập dòng mô tả ngắn sản phẩm, bài viết tại khung này"
                                       name="discription">
                            </div>
                            <div class="product-content-information-label">
                                Thông tin nội dung:
                            </div>
                            <div class="product-description-input">
                                <textarea name="content" cols="30" rows="10"
                                          placeholder="Nhập thông tin sản phẩm chi tiết tại đây"></textarea>
                            </div>
                            <div class="product-action-label">
                                Hiển thị:
                            </div>
                            <div class="product-action-choose">
                                <input type="checkbox" name="status">
                            </div>
                            <div class="save-or-exit-box">
                                <button class="save-button" type="submit">
                                    Lưu
                                </button>
                                <button class="exit-button">
                                    <a href="<%=request.getContextPath()%>/admin">
                                        Thoát
                                    </a>
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
