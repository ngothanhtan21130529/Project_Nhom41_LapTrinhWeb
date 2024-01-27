<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="css/admin.css?v=95" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/admin.js?v=264" type="text/javascript">
    </script>
    <%--    jQuerry--%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <%--    Data Table--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css" type="text/css">
    <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <%--    JavaScript--%>
    <script src="<%=request.getContextPath()%>/js/adminDataTable.js?v=522"></script>
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
                    <a>
                        <i class="fa-solid fa-house fa-sm" style="color: #428bca;"></i>
                        Trang chủ admin
                    </a>
                </div>
            </div>
            <div class="categories-management">
                <button class="categories-management-button gray-color" onclick="scrollDownCategoriesManagement()">
                    <i class="fa-solid fa-table-cells-large fa-sm" style="color: #428bca;"></i>
                    Quản trị danh mục
                </button>
                <ul>
                    <li class="element categories-tab-element" onclick="changeToCategoriesTab()">
                        <div class="category-type">Loại danh mục</div>
                    </li>
                    <li class="element categories-tab-element" onclick="changeToProductTab()">
                        <div class="category-product">Sản phẩm</div>
                    </li>
                </ul>
            </div>
            <div class="ui-management">
                <button class="ui-management-button gray-color" onclick="scrollDownUIMangement()">
                    <i class="fa-solid fa-list fa-sm" style="color: #428bca;"></i>
                    Quản trị giao diện
                </button>
                <ul>
                    <li class="element ui-tab-element" onclick="changeToProductSlideShow()">
                        <div>Slide show sản phẩm</div>
                    </li>
                    <li class="element ui-tab-element" onclick="changeToJewelrySlideShow()">
                        <div>Slide show trang sức</div>
                    </li>
                    <li class="element ui-tab-element" onclick="changeToGemSlideShow()">
                        <div>Slide show đá quý</div>
                    </li>
                    <li class="element ui-tab-element" onclick="changeToHomePageSlideShow()">
                        <div>Slide show trang chủ</div>
                    </li>
                    <li class="element ui-tab-element" onclick="changeToOnlineSupportTab()">
                        <div>Hỗ trợ trực tuyến</div>
                    </li>
                </ul>
            </div>
            <div class="information-management">
                <button class="information-management-button gray-color"
                        onclick="scrollDownInformationManagement()">
                    <i class="fa-solid fa-dollar-sign fa-sm" style="color: #428bca;"></i>
                    Quản trị thông tin
                </button>
                <ul>
                    <li class="element infor-tab-element" onclick="changeToOrderListTab()">
                        <div>Danh sách đơn hàng</div>
                    </li>
                    <li class="element infor-tab-element" onclick="changeToCustomerContactTab()">
                        <div>Khách hàng liên hệ</div>
                    </li>
                </ul>
            </div>
            <div class="user-configuration">
                <button class="user-configuration-button gray-color" onclick="scrollDownUserConfiguration()">
                    <i class="fa-solid fa-user fa-sm" style="color: #428bca;"></i>
                    Cấu hình người dùng
                </button>
                <ul>
                    <li class="element user-config-element" onclick="changeToUserManagement()">
                        <div>Quản lý người dùng</div>
                    </li>
                    <li class="element user-config-element" onclick="changeToUserInformationTab()">
                        <div>Quản lý số lượng tồn kho</div>
                    </li>
                    <li class="element user-config-element">
                        <div>Thoát</div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="content-bar">
            <div class="go-to-homepage-website gray-color active">
                <a class="homepage-website">
                    <i class="fa-solid fa-house fa-sm" style="color: #428bca;"></i>
                    <p class="homepage-website-text">
                        Trang chủ website
                    </p>
                </a>
            </div>
            <div class="hompage-admin-tab content-tab">
                <div class="note">
                    <div class="text">
                        Nếu cần hỗ trợ kỹ thuật, quý khách vui lòng thực hiện một trong ba cách sau:
                    </div>
                    <ol>
                        <li>
                            Truy cập: <a href="https://dkmh.hcmuaf.edu.vn/#/home"
                                         target="_blank">https://dkmh.hcmuaf.edu.vn</a> và gởi yêu cầu hỗ trợ.
                        </li>
                        <li>
                            Gởi email cho phòng kỹ thuật: <span>info@st.hcmuaf.edu.vn</span>.
                        </li>
                        <li>
                            Gọi số Hotline hỗ trợ khách hàng: <span>028 3896 6780</span>.
                        </li>
                    </ol>
                </div>
            </div>
            <div class="categories-tab">
                <div class="categories-main-tab content-tab">
                    <div class="categories-tab-function-box function-box">
                        <div class="adding-box box" onclick="changeToCategoriesAddingTab()">
                            <button>
                                <i class="fa-solid fa-plus fa-lg" style="color: white;"></i>
                                <p>
                                    Thêm mới
                                </p>
                            </button>
                        </div>
                    </div>
                    <div class="categories-table">
                        <table id="categories-table" style="min-width: 100%">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Danh mục</th>
                                <th style="width: 20%;">Hình ảnh</th>
                                <th>Ngày tạo</th>
                                <th>Ngày sửa</th>
                                <th>Ngày ẩn</th>
                                <th>Hiển thị</th>
                                <th>Tác vụ</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${categoryArrayList}" var="category">
                                <tr>
                                    <td>
                                            ${category.getId()}
                                    </td>
                                    <td>
                                            ${category.getCategoryName()}
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${category.getImgURL()==null}">
                                                Chưa có hình
                                            </c:when>
                                            <c:when test="${fn:containsIgnoreCase(category.getImgURL(), 'img/data')}">
                                                <img src="<%=request.getContextPath()%>${category.getImgURL()}" alt="">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="${category.getImgURL()}" alt="">
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                            ${category.getCreatedAt()}
                                    </td>
                                    <td>
                                            ${category.getUpdatedAt()}
                                    </td>
                                    <td>
                                            ${category.getDeletedAt()}
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${category.getStatus()==null}">
                                                Ẩn
                                            </c:when>
                                            <c:otherwise>
                                                Hiện
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <div>
                                            <a href="getCategory?id=${category.getId()}&imgID=${category.getImgID()}">
                                                <i class="fa-solid fa-pen-to-square fa-lg" style="color: #5b85cd;"></i>
                                            </a>
                                            <a href="#" onclick="showMessCategory(${category.getId()})">
                                                <i class="fa-solid fa-x fa-lg" style="color: #5b85cd;"></i>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="categories-adding-tab content-tab">
                    <form method="post" action="<%=request.getContextPath()%>/AddCategory"
                          enctype="multipart/form-data">
                        <div class="categories-adding-tab-general-infomation">
                            <div class="general-infomation-label">
                                THÔNG TIN CHUNG
                            </div>
                            <div class="img-label">
                                <p>
                                    Hình ảnh:
                                </p>
                            </div>
                            <div class="img-input input-box" style="width: 100%">
                                <input class="choosing-button" type="file" name="category-img" accept="image/*"
                                       style="width: 100%">
                            </div>
                            <div class="categories-detail-title">
                                <p>
                                    Tiêu đề:
                                </p>
                            </div>
                            <div class="categories-detail-title-input-box">
                                <input class="input-box" name="categories-name-input">
                            </div>
                            <div class="categories-action-label">
                                <p>
                                    Tác vụ:
                                </p>
                            </div>
                            <div class="categories-action-choose">
                                <div>
                                    <input type="checkbox" name="categories-displayment">
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
            <div class="product-tab">
                <div class="product-main-tab content-tab">
                    <div class="product-tab-function-box function-box">
                        <div class="adding-box box">
                            <button>
                                <a href="<%=request.getContextPath()%>/goToAddingProduct"
                                   style="color: white; text-decoration: none">
                                    <i class="fa-solid fa-plus fa-sm" style="color: white;"></i>
                                    Thêm mới
                                </a>
                            </button>
                        </div>
                    </div>
                    <div class="product-table" style="overflow-x: auto;">
                        <table id="product-table">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tiêu đề</th>
                                <th>Danh mục</th>
                                <th>Hình ảnh</th>
                                <th>Giá</th>

                                <th>Giảm giá</th>
                                <th>Sản phẩm mới</th>
                                <th>Mô tả</th>
                                <th>Ngày tạo</th>
                                <th>Ngày sửa</th>

                                <th>Ngày xoá</th>
                                <th>Màu sắc</th>
                                <th>Trọng lượng</th>
                                <th>Kích thước</th>
                                <th>Độ trong suốt</th>

                                <th>Kiểu cắt mài</th>
                                <th>Chất liệu</th>
                                <th>Tình trạng</th>
                                <th>Tác vụ</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${productArrayList}" var="product">
                                <tr>
                                    <td>
                                            ${product.getId()}
                                    </td>
                                    <td>
                                            ${product.getProductName()}
                                    </td>
                                    <td>
                                            ${product.getCategoryName()}
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${product.getImgURL()==null}">
                                                Chưa có hình
                                            </c:when>
                                            <c:when test="${fn:containsIgnoreCase(product.getImgURL(), 'img/data')}">
                                                <img src="<%=request.getContextPath()%>${product.getImgURL()}" alt="">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="${product.getImgURL()}" alt="">
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                            ${product.getPrice()}
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${product.getSale()==1}">
                                                Có
                                            </c:when>
                                            <c:otherwise>
                                                Không
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${category.isHot()==true}">
                                                Có
                                            </c:when>
                                            <c:otherwise>
                                                Không
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                            ${product.getDescription()}
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${product.getCreatedAt()==null}">
                                                chưa có
                                            </c:when>
                                            <c:otherwise>
                                                ${product.getCreatedAt()}
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${product.getUpdatedAt()==null}">
                                                chưa có
                                            </c:when>
                                            <c:otherwise>
                                                ${product.getUpdatedAt()}
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${product.getDeletedAt()==null}">
                                                chưa có
                                            </c:when>
                                            <c:otherwise>
                                                ${product.getDeletedAt()}
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                            ${product.getStoneColor()}
                                    </td>
                                    <td>
                                            ${product.getWeight()}
                                    </td>
                                    <td>
                                            ${product.getSize()}
                                    </td>
                                    <td>
                                            ${product.getOpacity()}
                                    </td>
                                    <td>
                                            ${product.getCuttingGrindingShape()}
                                    </td>
                                    <td>
                                            ${product.getMaterial()}
                                    </td>
                                    <td>
                                            ${product.getStatus()}
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/getProducts?id=${product.getId()}">
                                            <i class="fa-solid fa-pen-to-square fa-lg" style="color: #5b85cd;"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <form action="" method="post">
                <div class="slide-show-tab content-tab product-slide-show">
                    <div class="slide-show-label">
                        Slide show sản phẩm
                    </div>
                    <div class="slide-show-current-img-1-label">
                        <p>
                            Hình 1 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-1-input">
                        <img src="../img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-1-label">
                        <p>
                            Hình 1:
                        </p>
                    </div>
                    <div class="slide-show-img-1-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-2-label">
                        <p>
                            Hình 2 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-2-input">
                        <img src="../img/spinel-tim-anh-kim-2.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-2-label">
                        <p>
                            Hình 2:
                        </p>
                    </div>
                    <div class="slide-show-img-2-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-3-label">
                        <p>
                            Hình 3 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-3-input">
                        <img src="../img/spinel-tim-anh-kim-3.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-3-label">
                        <p>
                            Hình 3:
                        </p>
                    </div>
                    <div class="slide-show-img-3-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-4-label">
                        <p>
                            Hình 4 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-4-input">
                        <img src="../img/spinel-tim-anh-kim-4.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-4-label">
                        <p>
                            Hình 4:
                        </p>
                    </div>
                    <div class="slide-show-img-4-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-5-label">
                        <p>
                            Hình 5 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-5-input">
                        <img src="img/spinel-tim-anh-kim-5.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-5-label">
                        <p>
                            Hình 5:
                        </p>
                    </div>
                    <div class="slide-show-img-5-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-6-label">
                        <p>
                            Hình 6 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-6-input">
                        <img src="img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-6-label">
                        <p>
                            Hình 6:
                        </p>
                    </div>
                    <div class="slide-show-img-6-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="save-or-exit-box">
                        <button class="save-button">
                            Lưu
                        </button>
                    </div>
                </div>
            </form>
            <form action="" method="post">
                <div class="slide-show-tab content-tab jewelry-slide-show">
                    <div class="slide-show-label">
                        Slide show trang sức
                    </div>
                    <div class="slide-show-current-img-1-label">
                        <p>
                            Hình 1 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-1-input">
                        <img src="img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-1-label">
                        <p>
                            Hình 1:
                        </p>
                    </div>
                    <div class="slide-show-img-1-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-2-label">
                        <p>
                            Hình 2 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-2-input">
                        <img src="img/spinel-tim-anh-kim-2.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-2-label">
                        <p>
                            Hình 2:
                        </p>
                    </div>
                    <div class="slide-show-img-2-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-3-label">
                        <p>
                            Hình 3 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-3-input">
                        <img src="img/spinel-tim-anh-kim-3.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-3-label">
                        <p>
                            Hình 3:
                        </p>
                    </div>
                    <div class="slide-show-img-3-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-4-label">
                        <p>
                            Hình 4 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-4-input">
                        <img src="img/spinel-tim-anh-kim-4.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-4-label">
                        <p>
                            Hình 4:
                        </p>
                    </div>
                    <div class="slide-show-img-4-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-5-label">
                        <p>
                            Hình 5 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-5-input">
                        <img src="img/spinel-tim-anh-kim-5.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-5-label">
                        <p>
                            Hình 5:
                        </p>
                    </div>
                    <div class="slide-show-img-5-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-6-label">
                        <p>
                            Hình 6 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-6-input">
                        <img src="img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-6-label">
                        <p>
                            Hình 6:
                        </p>
                    </div>
                    <div class="slide-show-img-6-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="save-or-exit-box">
                        <button class="save-button">
                            Lưu
                        </button>
                    </div>
                </div>
            </form>
            <form action="" method="post">
                <div class="slide-show-tab content-tab gem-slide-show">
                    <div class="slide-show-label">
                        Slide show đá quý
                    </div>
                    <div class="slide-show-current-img-1-label">
                        <p>
                            Hình 1 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-1-input">
                        <img src="img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-1-label">
                        <p>
                            Hình 1:
                        </p>
                    </div>
                    <div class="slide-show-img-1-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-2-label">
                        <p>
                            Hình 2 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-2-input">
                        <img src="img/spinel-tim-anh-kim-2.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-2-label">
                        <p>
                            Hình 2:
                        </p>
                    </div>
                    <div class="slide-show-img-2-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-3-label">
                        <p>
                            Hình 3 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-3-input">
                        <img src="img/spinel-tim-anh-kim-3.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-3-label">
                        <p>
                            Hình 3:
                        </p>
                    </div>
                    <div class="slide-show-img-3-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-4-label">
                        <p>
                            Hình 4 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-4-input">
                        <img src="img/spinel-tim-anh-kim-4.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-4-label">
                        <p>
                            Hình 4:
                        </p>
                    </div>
                    <div class="slide-show-img-4-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-5-label">
                        <p>
                            Hình 5 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-5-input">
                        <img src="img/spinel-tim-anh-kim-5.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-5-label">
                        <p>
                            Hình 5:
                        </p>
                    </div>
                    <div class="slide-show-img-5-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-6-label">
                        <p>
                            Hình 6 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-6-input">
                        <img src="img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-6-label">
                        <p>
                            Hình 6:
                        </p>
                    </div>
                    <div class="slide-show-img-6-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="save-or-exit-box">
                        <button class="save-button">
                            Lưu
                        </button>
                    </div>
                </div>
            </form>
            <form action="" method="post">
                <div class="slide-show-tab content-tab homepage-slide-show">
                    <div class="slide-show-label">
                        Slide show trang chủ
                    </div>
                    <div class="slide-show-current-img-1-label">
                        <p>
                            Hình 1 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-1-input">
                        <img src="img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-1-label">
                        <p>
                            Hình 1:
                        </p>
                    </div>
                    <div class="slide-show-img-1-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-2-label">
                        <p>
                            Hình 2 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-2-input">
                        <img src="img/spinel-tim-anh-kim-2.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-2-label">
                        <p>
                            Hình 2:
                        </p>
                    </div>
                    <div class="slide-show-img-2-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-3-label">
                        <p>
                            Hình 3 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-3-input">
                        <img src="img/spinel-tim-anh-kim-3.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-3-label">
                        <p>
                            Hình 3:
                        </p>
                    </div>
                    <div class="slide-show-img-3-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-4-label">
                        <p>
                            Hình 4 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-4-input">
                        <img src="img/spinel-tim-anh-kim-4.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-4-label">
                        <p>
                            Hình 4:
                        </p>
                    </div>
                    <div class="slide-show-img-4-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-5-label">
                        <p>
                            Hình 5 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-5-input">
                        <img src="img/spinel-tim-anh-kim-5.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-5-label">
                        <p>
                            Hình 5:
                        </p>
                    </div>
                    <div class="slide-show-img-5-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="slide-show-current-img-6-label">
                        <p>
                            Hình 6 hiện tại:
                        </p>
                    </div>
                    <div class="slide-show-current-img-6-input">
                        <img src="img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg" alt="">
                    </div>
                    <div class="slide-show-pic-6-label">
                        <p>
                            Hình 6:
                        </p>
                    </div>
                    <div class="slide-show-img-6-input">
                        <form action="">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                    </div>
                    <div class="save-or-exit-box">
                        <button class="save-button">
                            Lưu
                        </button>
                    </div>
                </div>
            </form>
            <div class="online-support-tab content-tab">
                <div class="change-method-contact-tab">
                    <div class="change-method-contact-label">
                        Thay đổi phương thức liên lạc
                    </div>
                    <div class="change-telephone-num-label">
                        Số máy bàn:
                    </div>
                    <div class="change-telephone-num">
                        <input type="text" value="028 3896 6780">
                    </div>
                    <div class="change-counselors-phone-num-label">
                        SĐT tư vấn viên:
                    </div>
                    <div class="change-counselors-phone-num">
                        <input type="text" class="change-counselors-phone-num-input" value="028 3896 6780">
                    </div>
                    <div class="change-zalo-num-label">
                        Zalo:
                    </div>
                    <div class="change-zalo-num">
                        <input type="text" class="change-zalo-num-input" value="028 3896 6780">
                    </div>
                    <div class="save-or-exit-box">
                        <button class="save-button">
                            Lưu
                        </button>
                        <button class="exit-button">
                            Thoát
                        </button>
                    </div>
                </div>
            </div>
            <div class="information-management">
                <div class="order-list content-tab">
                    <div class="order-list-table">
                        <table id="order-list-table">
                            <thead>
                            <tr>
                                <th>Mã đơn hàng</th>
                                <th>Tên khách hàng</th>
                                <th>Địa chỉ</th>
                                <th>Số điện thoại</th>
                                <th>Tổng giá hoá đơn</th>
                                <th>Ngày tạo</th>
                                <th>Ngày sửa</th>
                                <th>Tình trạng</th>
                                <th>Xem chi tiết hoá đơn</th>
                                <th>Chỉnh sữa hoá đơn</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderArrayList}" var="order">
                                <tr>
                                    <td>${order.getId()}</td>
                                    <td>${order.getFullName()}</td>
                                    <td>${order.getAddress()}</td>
                                    <td>${order.getPhone()}</td>
                                    <td>${order.getTotalPrice()}</td>
                                    <td>${order.getCreatedAt()}</td>
                                    <td>${order.getUpdatedAt()}</td>
                                    <td>${order.getStatus()}</td>
                                    <td>
                                        <a href="getOderDetails?id=${order.getId()}">
                                            Xem chi tiết
                                        </a>
                                    </td>
                                    <td>
                                        <a href="getInforOrderDetails?id=${order.getId()}">
                                            <i class="fa-solid fa-pen-to-square fa-lg" style="color: #5b85cd;"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="customer-contact content-tab">
                    <div class="customer-contact-table">
                        <table id="customer-contact-table">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tên khách hàng</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Title</th>
                                <th>Ngày tạo feedback</th>
                                <th>Nội dung</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${feedbackArrayList}" var="feedback">
                                <tr>
                                    <td>${feedback.getId()}</td>
                                    <td>${feedback.getFullName()}</td>
                                    <td>${feedback.getEmail()}</td>
                                    <td>${feedback.getPhone()}</td>
                                    <td>${feedback.getTitle()}</td>
                                    <td>${feedback.getCreatedAt()}</td>
                                    <td>${feedback.getContent()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="user-management-tab content-tab">
                <div class="user-management-table">
                    <table id="user-management-table" style="width: 100%">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tài khoản</th>
                            <th>Họ tên</th>
                            <th style="width: 100%">Email</th>
                            <th>SĐT</th>
                            <th>Ngày sinh</th>
                            <th>Ngày tạo</th>
                            <th>Ngày sửa</th>
                            <th>Avatar</th>
                            <th>Chức vụ</th>
                            <th>Tác vụ</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userArrayList}" var="user">
                            <tr>
                                <td>${user.getId()}</td>
                                <td>${user.getUserName()}</td>
                                <td>${user.getName()==null?"chưa có":user.getName()}</td>
                                <td>${user.getEmail()}</td>
                                <td>${user.getPhone()==null?"chưa có":user.getPhone()}</td>
                                <td>${user.getBirthday()==null?"chưa có":user.getBirthday()}</td>
                                <td>${user.getCreatedAt()==null?"chưa có":user.getCreatedAt()}</td>
                                <td>${user.getUpdatedAt()==null?"chưa có":user.getUpdatedAt()}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${user.getAvatar()==null}">
                                            Chưa có hình
                                        </c:when>
                                        <c:otherwise>
                                            <img src="<%=request.getContextPath()%>${category.getImgURL()}" alt="">
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${user.getRoleName()}</td>
                                <td>
                                    <a href="getUserInfo?id=${user.getId()}">
                                        <i class="fa-solid fa-pen-to-square fa-lg" style="color: #5b85cd;"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="inventories-management content-tab">
                <div class="inventories-management-table">
                    <table id="inventories-management-table" style="width: 100%">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên sản phẩm</th>
                            <th>Ngày tạo</th>
                            <th>Tồn kho</th>
                            <th>Tác vụ</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productWithInventories}" var="inventories">
                            <tr>
                                <td>${inventories.getId()}</td>
                                <td>${inventories.getProductName()}</td>
                                <td>${inventories.getCreatedAt()}</td>
                                <td>${inventories.getQuantity()}</td>
                                <td>
                                    <a href="getInvenInfo?id=${inventories.getId()}">
                                        <i class="fa-solid fa-pen-to-square fa-lg" style="color: #5b85cd;"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>