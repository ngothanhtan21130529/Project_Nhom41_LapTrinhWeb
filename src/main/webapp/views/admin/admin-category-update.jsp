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
    <title>Document</title>
    <link rel="stylesheet" href="css/admin-category-update.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
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
                    <a href="<%=request.getContextPath()%>/AdminDisplayment">
                        <i class="fa-solid fa-house fa-sm" style="color: #428bca;"></i>
                        Trang chủ admin
                    </a>
                </div>
            </div>
            <div class="categories-management">
                <button class="categories-management-button gray-color">
                    <a href="<%=request.getContextPath()%>/AdminDisplayment">
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
                    <a href="<%=request.getContextPath()%>/AdminDisplayment">
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
                    <a href="<%=request.getContextPath()%>/AdminDisplayment">
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
                    <a href="<%=request.getContextPath()%>/AdminDisplayment">
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
            <div class="categories-tab">
                <div class="categories-adding-tab content-tab">
                    <form method="post" action="<%=request.getContextPath()%>/UpdateCategoryStage2"
                          enctype="multipart/form-data">
                        <div class="categories-adding-tab-general-infomation">
                            <div class="general-infomation-label">
                                THÔNG TIN CHUNG
                            </div>
                            <div class="img-current-label">
                                <p>
                                    Hình ảnh hiện tại:
                                </p>
                            </div>
                            <div class="image-current">
                                <img src="<%=request.getContextPath()%>${category.getImgURL()}">
                            </div>
                            <div class="img-label">
                                <p>
                                    Hình ảnh mới:
                                </p>
                            </div>
                            <div class="img-input input-box" style="width: 100%">
                                <input class="choosing-button" type="file" name="category-new-img" accept="image/*"
                                       style="width: 100%">
                            </div>
                            <div class="categories-detail-title">
                                <p>
                                    Tiêu đề:
                                </p>
                            </div>
                            <div class="categories-detail-title-input-box">
                                <input class="input-box" name="categories-name-input"
                                       value="${category.getCategoryName()}">
                            </div>
                            <div class="numerial-order-label">
                                <p>
                                    Số thứ tự:
                                </p>
                            </div>
                            <div class="numerial-order-input input-box">
                                <input type="text" name="categories-order" value="${category.getId()}" readonly>
                            </div>
                            <div class="categories-action-label">
                                <p>
                                    Tác vụ:
                                </p>
                            </div>
                            <div class="categories-action-choose">
                                <div>
                                    <input type="checkbox" name="categories-status"
                                           ${category.getStatus()==null?"":"checked"}>
                                </div>
                                <div class="categories-action-choose-label">
                                    Hiển thị
                                </div>
                            </div>
                            <div class="save-or-exit-box">
                                <button class="save-button" type="submit">
                                    Lưu
                                </button>
                                <button class="exit-button">
                                    Thoát
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>