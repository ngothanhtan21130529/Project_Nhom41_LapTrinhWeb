<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Category" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/admin.css" type="text/css">
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
                    <a href="index.html">
                        <i class="fa-solid fa-tent-arrow-turn-left fa-sm" style="color: #B4B4B4 ;"></i>
                        Vào trang web
                    </a>
                </li>
                <li style="border-right: 1px solid #939393;" class="top-bar-element">
                    <a href="contact.html">
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
                    <li class="element ui-tab-element" onclick="changeToInformationTab()">
                        <div>Thông tin</div>
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
                        <div>Thông tin người dùng</div>
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
                        <form action="" method="get">
                            <div class="searching-box box">
                                <input type="text" placeholder="Tìm kiếm">
                            </div>
                            <div class="search-by-box box">
                                <select name="search-by">
                                    <option value="">Tìm theo</option>
                                    <option value="find-by-id">Số thứ tự</option>
                                    <option value="find-by-categories">Tên danh mục</option>
                                </select>
                            </div>
                        </form>
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
                        <table>
                            <tr>
                                <th>STT</th>
                                <th>Danh mục</th>
                                <th style="width: 20%;">Hình ảnh</th>
                                <th>Ngày tạo</th>
                                <th>Ngày sữa</th>
                                <th>Ngày xoá</th>
                                <th>Hiển thị</th>
                                <th>Tác vụ</th>
                            </tr>
                            <%
                                ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categoriesList");
                                for (int i = 0; i < categories.size(); i++) {
                            %>
                            <tr>
                                <td><%=categories.get(i).getId()%>
                                </td>
                                <td><%=categories.get(i).getCategoryName()%>
                                </td>
                                <td>
                                    <img src="<%=categories.get(i).getImgURL()%>" alt="">
                                </td>
                                <td><%=categories.get(i).getCreatedAt()%>
                                </td>
                                <td><%=categories.get(i).getUpdatedAt()%>
                                </td>
                                <td><%=categories.get(i).getDeletedAt()%>
                                </td>
                                <td>
                                    <%=categories.get(i).getStatus()%>
                                </td>
                                <td>
                                    <i class="fa-solid fa-pen-to-square fa-lg" style="color: #5b85cd;"></i>
                                    <i class="fa-solid fa-x fa-lg" style="color: #5b85cd;"></i>
                                </td>
                            </tr>
                            <%}%>
                        </table>
                        <div class="pagination">
                            <%
                                int end = (int) request.getAttribute("endPage");
                                for (int i = 1; i <= end; i++) {
                            %>
                            <a href="ListCategory?index=<%=i%>"><%=i%>
                            </a>
                            <%}%>
                        </div>
                    </div>
                </div>
                <div class="categories-adding-tab content-tab">
                    <div class="categories-adding-tab-general-infomation">
                        <div class="general-infomation-label">
                            THÔNG TIN CHUNG
                        </div>
                        <div class="img-label">
                            <p>
                                Hình ảnh:
                            </p>
                        </div>
                        <div class="img-input input-box">
                            <form action="">
                                <input class="choosing-button" type="file" name="img" accept="image/*">
                            </form>
                        </div>
                        <div class="categories-detail-title">
                            <p>
                                Tiêu đề:
                            </p>
                        </div>
                        <div class="categories-detail-title-input-box">
                            <select class="input-box">
                                <option value="">Chọn danh mục</option>
                                <option value="gem">Đá quý</option>
                                <option value="jewelry">Trang sức</option>
                            </select>
                        </div>
                        <div class="numerial-order-label">
                            <p>
                                Số thứ tự:
                            </p>
                        </div>
                        <div class="numerial-order-input input-box">
                            <input type="text">
                        </div>
                        <div class="categories-action-label">
                            <p>
                                Tác vụ:
                            </p>
                        </div>
                        <div class="categories-action-choose">
                            <div>
                                <input type="checkbox" name="">
                            </div>
                            <div class="categories-action-choose-label">
                                Hiển thị
                            </div>
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
            </div>
            <div class="product-tab">
                <div class="product-main-tab content-tab">
                    <div class="product-tab-function-box function-box">
                        <div class="searching-box box">
                            <input type="text" placeholder="Tìm kiếm">
                        </div>
                        <div class="search-by-box box">
                            <select name="search-by">
                                <option value="">Tìm theo</option>
                                <option value="find-by-id">Số thứ tự</option>
                                <option value="find-by-categories">Tên sản phẩm</option>
                            </select>
                        </div>
                        <div class="see-all-box box">
                            <button class="see-all-box-content">
                                Xem tất cả sản phẩm
                            </button>
                        </div>
                        <div class="adding-box box" onclick="changeToProductAddingTab()">
                            <button>
                                <i class="fa-solid fa-plus fa-sm" style="color: white;"></i>
                                Thêm mới
                            </button>
                        </div>
                    </div>
                    <div class="product-table" style="overflow-x: auto;">
                        <table>
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
                                <th>Tồn kho</th>
                                <th>Tình trạng</th>
                                <th>Tác vụ</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Đá quý</td>
                                <td>Đá quý loại A</td>
                                <td>
                                    <img src="../img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="">
                                </td>
                                <td>12000000</td>
                                <td><input type="checkbox" name=""></td>
                                <td><input type="checkbox" name=""></td>
                                <td>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis, dignissimos?
                                </td>
                                <td>16/12/2023</td>
                                <td>16/12/2023</td>
                                <td>16/12/2023</td>
                                <td>Tím</td>
                                <td>1.2 carat</td>
                                <td>15mmx20mm</td>
                                <td>0.5</td>
                                <td>15</td>
                                <td>
                                    <select>
                                        <option value="stocking">Còn hàng</option>
                                        <option value="out-of-stock">Hết hàng</option>
                                        <option value="not-sold">Không bán nữa</option>
                                    </select>
                                </td>
                                <td>
                                    <i class="fa-solid fa-pen-to-square fa-lg" style="color: #5b85cd;"></i>
                                    <i class="fa-solid fa-x fa-lg" style="color: #5b85cd;"></i>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="product-adding-tab content-tab">
                    <div class="product-adding-tab-general-infomation">
                        <div class="general-infomation-label">
                            THÔNG TIN CHUNG
                        </div>
                        <div class="img-current-label">
                            <p>
                                Hình ảnh:
                            </p>
                        </div>
                        <div class="img-current-url">
                            <img src="../img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="">
                        </div>
                        <div class="img-adding-label">
                            Hình ảnh:
                        </div>
                        <form action="" class="img-adding-url">
                            <input class="choosing-button" type="file" name="img" accept="image/*">
                        </form>
                        <div class="categories-product-label">
                            Danh mục
                        </div>
                        <div class="categories-product-input">
                            <select>
                                <option value=""></option>
                                <option value="gem">Đá quý</option>
                                <option value="jewelry">Trang sức</option>
                            </select>
                        </div>
                        <div class="product-code-label">
                            Mã sản phẩm
                        </div>
                        <div class="product-code-input">
                            <input type="text">
                        </div>
                        <div class="product-price-label">
                            <p>
                                Giá
                            </p>
                        </div>
                        <div class="product-price-input-output">
                            <div class="product-price-input">
                                <input type="text">
                            </div>
                            <div class="product-price-output">
                                50.000 đ
                            </div>
                        </div>
                    </div>
                    <div class="product-tab-detail-information">
                        <div class="details-infomation-label">
                            THÔNG TIN CHI TIẾT
                        </div>
                        <div class="title-product">
                            Tiêu đề:
                        </div>
                        <div class="title-input-box">
                            <input type="text">
                        </div>
                        <div class="product-description-label">
                            Mô tả:
                        </div>
                        <div class="product-description-input">
                            <input type="text" placeholder="Nhập dòng mô tả ngắn sản phẩm, bài viết tại khung này">
                        </div>
                        <div class="product-content-information-label">
                            Thông tin nội dung:
                        </div>
                        <div class="product-description-input">
                                <textarea name="" cols="30" rows="10"
                                          placeholder="Nhập thông tin sản phẩm chi tiết tại đây"></textarea>
                        </div>
                        <div class="product-action-label">
                            Tác vụ:
                        </div>
                        <div class="product-action-choose">
                            <input type="checkbox" name="">
                            <div class="product-action-choose-label">
                                Hiển thị
                            </div>
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
                    <div class="order-list-function-box function-box">
                        <div class="searching-box box">
                            <input type="text" placeholder="Tìm kiếm">
                        </div>
                        <div class="search-by-box box">
                            <select name="search-by">
                                <option value="">Tìm theo</option>
                                <option value="find-by-id">Số thứ tự</option>
                                <option value="find-by-categories">Tên danh mục</option>
                                <option value="find-by-categories">Tên sản phẩm</option>
                            </select>
                        </div>
                        <div class="adding-box box">
                            <button>
                                <i class="fa-solid fa-plus fa-sm" style="color: white;"></i>
                                Thêm mới
                            </button>
                        </div>
                    </div>
                    <div class="order-list-table">
                        <table>
                            <tr>
                                <th>Mã đơn hàng</th>
                                <th>Tên sản phẩm</th>
                                <th>Tên khách hàng</th>
                                <th>Số lượng</th>
                                <th>Tổng giá sản phẩm</th>
                                <th>Tổng giá hoá đơn</th>
                                <th>Ngày tạo</th>
                                <th>Ngày sửa</th>
                                <th>Tình trạng</th>
                                <th>Tác vụ</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Spinel tím</td>
                                <td>Nhựt Tân</td>
                                <td>21-3-2021</td>
                                <td>5</td>
                                <td>1,000,000 đ</td>
                                <td>16-12-2023</td>
                                <td>16-12-2023</td>
                                <td>
                                    <select>
                                        <option value="Confirm-Waiting">Đang chờ xác nhận</option>
                                        <option value="Confirmed">Đã xác nhận</option>
                                        <option value="Receive-Waiting">Đang chờ nhận hàng</option>
                                        <option value="Received">Đã nhận hàng</option>
                                    </select>
                                </td>
                                <td><i class="fa-solid fa-x fa-sm" style="color: #5b78a9;"></i></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="customer-contact content-tab">
                    <div class="customer-contact-function-box function-box">
                        <div class="searching-box box">
                            <input type="text" placeholder="Tìm kiếm">
                        </div>
                        <div class="search-by-box box">
                            <select name="search-by">
                                <option value="">Tìm theo</option>
                                <option value="find-by-id">Số thứ tự</option>
                                <option value="find-by-name">Tên khách hàng</option>
                                <option value="find-by-keywords">Từ khóa</option>
                            </select>
                        </div>
                        <div class="adding-box box">
                            <button>
                                <i class="fa-solid fa-plus fa-sm" style="color: white;"></i>
                                Thêm mới
                            </button>
                        </div>
                    </div>
                    <div class="customer-contact-table">
                        <table>
                            <tr>
                                <th><input type="checkbox" name=""></th>
                                <th>Mã liên hệ</th>
                                <th>Tên khách hàng</th>
                                <th>Ngày liên hệ</th>
                                <th>Nội dung</th>
                                <th>Tác vụ</th>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name=""></td>
                                <td>1</td>
                                <td>Nhựt Tân</td>
                                <td>21-3-2021</td>
                                <td>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Fugit, nostrum.</td>
                                <td><i class="fa-solid fa-x fa-sm" style="color: #5b78a9;"></i></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="user-management-tab content-tab">
                <div class="user-management-function-box function-box">
                    <div class="searching-box box">
                        <input type="text" placeholder="Tìm kiếm">
                    </div>
                    <div class="search-by-box box">
                        <select name="search-by">
                            <option value="">Tìm theo</option>
                            <option value="find-by-id">Số thứ tự</option>
                            <option value="find-by-categories">Tên danh mục</option>
                        </select>
                    </div>
                    <div class="adding-box box">
                        <button>
                            <i class="fa-solid fa-plus fa-sm" style="color: white;"></i>
                            Thêm mới
                        </button>
                    </div>
                </div>
                <div class="user-management-table">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Họ tên</th>
                            <th>Chức vụ</th>
                            <th>Hiển thị</th>
                            <th>Tác vụ</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Administrator</td>
                            <td>Administrator</td>
                            <td>Hiện</td>
                            <td>
                                <i class="fa-solid fa-pen-to-square fa-sm" style="color: #5b85cd;"></i>
                                <i class="fa-solid fa-x fa-lg" style="color: #394760;"></i>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="user-information content-tab">
                <div class="user-information-label">
                    Thông tin người dùng
                </div>
                <div class="account-role-label">
                    <p>
                        Chức vụ:
                    </p>
                </div>
                <div class="account-role-select">
                    <select name="">
                        <option value=""></option>
                        <option value="admin">Quản trị viên</option>
                        <option value="user">Người dùng</option>
                    </select>
                </div>
                <div class="account-username-label">
                    <p>
                        Tên tài khoản:
                    </p>
                </div>
                <div class="account-username">
                    <input type="text" value="">
                </div>
                <div class="account-fullname-label">
                    <p>
                        Họ tên:
                    </p>
                </div>
                <div class="account-fullname-input">
                    <input type="text" name="" value="">
                </div>
                <div class="account-password-label">
                    <p>
                        Mật khẩu:
                    </p>
                </div>
                <div class="account-password-input">
                    <input type="text" value="">
                </div>
                <div class="retype-account-password-label">
                    <p>
                        Nhập lại mật khẩu:
                    </p>
                </div>
                <div class="retype-account-password-input">
                    <input type="text" value="">
                </div>
                <div class="visible-label">
                    <p>
                        Hiển thị
                    </p>
                </div>
                <div class="visible-checkbox">
                    <input type="checkbox" name="" id="">
                </div>
                <div class="save-or-exit-box">
                    <button class="save-button">
                        Lưu
                    </button>
                    <button class="exit-button" onclick="changeToHomepage()">
                        Thoát
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/admin.js" type="text/javascript"></script>
</body>

</html>