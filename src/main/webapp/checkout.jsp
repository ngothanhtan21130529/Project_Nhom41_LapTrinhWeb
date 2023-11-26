
<%@ page import="DAO.ImageDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="javax.swing.plaf.nimbus.State" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Thanh Toán</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
  <link rel="stylesheet" href="css/checkout.css" />
  <link rel="stylesheet" href="css/style.css" />
  <link rel="icon" href="img/favicon.png" type="image/x-icon" />
  <link
    href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
    rel="stylesheet" />
  <link
    href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
    rel="stylesheet" />
  <link rel="stylesheet" href="font/fontawesome-free-6.4.2/css/all.css" />
</head>

<body>
  <div class="container">
    <header class="header">
      <div class="container">
        <div class="box">
          <div class="logo">
            <img src="./img/logo.png" alt="Logo" class="logo-img" />
          </div>
          <nav class="navigation">
            <ul class="navigation-list">
              <li class="navigation-item active">
                <a href="index.html">Trang chủ</a>
              </li>
              <li class="navigation-item">
                <a href="products.html">Sản phẩm</a>
              </li>
              <li class="navigation-item">
                <a href="products.html">Trang sức</a>
              </li>
              <li class="navigation-item">
                <a href="products.html">Đá quý</a>
                <i class="fa-solid fa-caret-down"></i>
                <ul class="dropdown-gem">
                  <li class="dropdown-item">
                    <a href="products.html">Spinel</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Kim cương</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Ruby</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Hổ phách</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="topaz.html">Topaz</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Aquamarine</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Tourmaline</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Jade</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Emerald</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Garnet</a>
                  </li>
                  <li class="dropdown-item">
                    <a href="products.html">Các loại đá khác</a>
                  </li>
                </ul>
              </li>
              <li class="navigation-item">
                <a href="contact.html">Liên hệ</a>
              </li>
              <li class="navigation-item">
                <a href="policy.html">Chính sách</a>
              </li>
            </ul>
          </nav>
          <div class="header-btn">
            <ul class="header-list">
              <li class="header-item header-search">
                <form role="search" action="" method="get">
                  <input type="search" name="search" class="search-input" placeholder="Tìm sản phẩm"
                    autocomplete="off" />
                  <button type="submit" class="header-search-btn">
                    <i class="fa-sharp fa-solid fa-magnifying-glass" style="color: #000000"></i>
                  </button>
                </form>
              </li>
              <li class="header-item header__drop">
                <a href="./cart.html">
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
                <!-- if card have product -> add class header__drop__empty -->
                <div class="header__drop-list">
                  <div class="header__mt">
                    <img src="./images/cart-empty.png" alt="Giỏ hàng trống" class="header__mt-img" />
                    <h4 class="header__mt-msg">Chưa có sản phẩm</h4>
                  </div>

                  <div class="header__drop-no-mt">
                    <p class="heading__drop__no-mt-msg">Sản phẩm mới thêm</p>

                    <div class="header__product-list">
                      <div class="header__product-item">
                        <img
                          src="./img/gemstone/topaz/Vien-Topaz-tu-nhien-trang-tinh-khiet-283ct-IRTP56-23928300000-1.jpg"
                          alt="Header product card 1" class="header__product-item-img" />
                        <span class="header__product-item-name">
                          Viên Topaz tự nhiên trắng tinh khiết - 283ct-IRTP56
                        </span>
                        <span class="header__product-item-price">
                          129.000.000
                        </span>
                      </div>
                      <div class="header__product-item">
                        <img src="./img/gemstone/ruby/Vien-Ruby-facet-Luc-Yen-063ct-IRRF152-231006300000.jpg"
                          alt="Header product card 1" class="header__product-item-img" />
                        <span class="header__product-item-name">
                          Viên Ruby facet Lục Yên 063ct-IRRF152
                        </span>
                        <span class="header__product-item-price">
                          129.000.000
                        </span>
                      </div>
                      <div class="header__product-item">
                        <img src="./img/gemstone/jewels/Nhan-nam-Kim-Cuong-Vang-trang-Au18k-MA-K-6000000.jpg"
                          alt="Header product card 1" class="header__product-item-img" />
                        <span class="header__product-item-name">
                          Nhẫn nam Kim Cương Vàng trắng Au18k-MA-K
                        </span>
                        <span class="header__product-item-price">
                          129.000
                        </span>
                      </div>
                      <div class="header__product-item">
                        <img src="img/gemstone/spinel/Vien-Spinel-sac-cobalt-sieu-VIP-175ct-IRSI65-231117500000.jpg"
                          alt="Header product card 1" class="header__product-item-img" />
                        <span class="header__product-item-name">
                          Viên Spinel sắc cobalt siêu VIP 175ct-IRSI65
                        </span>
                        <span class="header__product-item-price">
                          129.000.000
                        </span>
                      </div>
                      <div class="header__product-item">
                        <img src="./img/gemstone/diamond/Anh-dai-dien-Kim-Cuong-tu-nhien.jpg"
                          alt="Header product card 1" class="header__product-item-img" />
                        <span class="header__product-item-name">
                          Kim cương tự nhiên
                        </span>
                        <span class="header__product-item-price">
                          129.000.000
                        </span>
                      </div>
                    </div>
                    <div class="header__drop__bottom">
                      <p class="heading__drop__bottom-msg">
                        5 sản phẩm mới thêm vào giỏ hàng
                      </p>
                      <a href="./cart.html" class="header__drop__btn">
                        Xem giỏ hàng
                      </a>
                    </div>
                  </div>
                </div>
              </li>
              <li class="header-item sign-in"><a href="">Đăng nhập</a></li>
            </ul>
          </div>
        </div>
      </div>
    </header>
    <div class="container-main">
      <!-- order -->
      <div class="order">
        <table class="order-table">
          <tr>
            <th>
              Tên người mua:
            </th>
            <td>
              Cô bé nhút nhát
            </td>
          </tr>
          <tr>
            <th>
              Tên
            </th>
            <th>
              Số lượng
            </th>
            <th>
              Giá
            </th>
            <th>
              Tổng
            </th>
            <th>
              Ngày tạo
            </th>
            <th>
              Mã hóa đơn
            </th>
          </tr>
          <tr>
            <td>
              Kim cương
            </td>
            <td>
              2
            </td>
            <td>
              12.990.000
            </td>
            <td>
              25.980.000
            </td>
            <td>
              15/2/2023
            </td>
            <td>
              1258231595
            </td>
          </tr>
          <tr>
            <td>
              Kim cương
            </td>
            <td>
              1
            </td>
            <td>
              10.000.000
            </td>
            <td>
              45.000.000
            </td>
            <td>
              5/10/2022
            </td>
            <td>
              6511853661
            </td>
          </tr>
        </table>
      </div>
      <!-- end order -->

      <div id="inform">
        <i class="fa-solid fa-wallet fa-8x"></i>
      </div>
      <div id="banking">
        <h2>Ngân hàng thương mại cổ phần Á Châu-ACB</h2>
        <img src="./img/qr.png" alt="" />
      </div>
      <div id="inform_banking">
        <ul id="banking_content">
          <li>
            Quý khách vui lòng đọc thông tin
            <a href="policy.html">quy định thanh toán và giao hàng</a> trước
            khi chuyển khoản.
          </li>
          <li>Tên ngân hàng: <span>ACB</span></li>
          <li>Chi nhánh: <span>ACB – PGD KIM DONG</span></li>
          <li>Số tài khoản: <span>683886666</span></li>
          <li>Tên tài khoản: <span>NGUYEN NGOC TU</span></li>
          <li>Mã ngân hàng: <span>ASCBVNVX</span></li>
          <li>
            Nội dung chuyển: <span>Số điện thoại của bạn Mã sản phẩm</span>
          </li>
          <li>Ví dụ: <span>0969248666 IRRB 237496</span></li>
        </ul>
        <span>Mã sản phẩm được lấy ở đây</span>
        <div id="checkout_img">
          <img src="img/sanpham.jpg" alt="" />
        </div>
        <span id="sentence">TTN - THỜI THƯỢNG & THANH LỊCH</span>
      </div>
    </div>
    <section class="footer">
      <div class="social-media">
        <div class="label">LIÊN LẠC THÔNG QUA MẠNG XÃ HỘI</div>
        <div class="way">
          <div class="phone">
            <i class="fa-solid fa-phone fa-sm" style="color: #495569"></i>
            <div class="phone-num">Hotline: 0856174581</div>
          </div>
          <div class="social-meida-way">
            <div class="facebook-icon">
              <a href="#">
                <i class="fa-brands fa-facebook-f fa-xs" style="color: black"></i>
              </a>
            </div>
            <div class="instagram-icon">
              <a href="#">
                <i class="fa-brands fa-instagram fa-xs" style="color: black"></i>
              </a>
            </div>
            <div class="tiktok-icon">
              <a href="#">
                <i class="fa-brands fa-tiktok fa-xs" style="color: black"></i>
              </a>
            </div>
            <div class="youtube-icon">
              <a href="#">
                <i class="fa-brands fa-youtube fa-xs" style="color: black"></i>
              </a>
            </div>
          </div>
          <div class="zalo">
            <img src="img/zalo-icon.png" alt="" />
            <div class="zalo-phone-num">Zalo: 0856174581</div>
          </div>
        </div>
      </div>
      <div class="end-footer">
        <div class="customer-about">
          <div class="customer-care">
            <div class="customer-care-label">CHĂM SÓC KHÁCH HÀNG</div>
            <ul>
              <li>
                <a href="#">Câu hỏi thường gặp</a>
              </li>
              <li>
                <a href="#">Hướng dẫn mua hàng</a>
              </li>
              <li>
                <a href="#">Quy định thanh toán</a>
              </li>
              <li>
                <a href="#">Chính sách bảo hành</a>
              </li>
            </ul>
          </div>
          <div class="about-us">
            <div class="about-us">
              <div class="about-us-label">VỀ CHÚNG TÔI</div>
              <div class="about-us-box">
                <ul>
                  <li>
                    <a href="#" class="home-page">Trang chủ</a>
                  </li>
                  <li>
                    <a href="#" class="security">Bảo mật</a>
                  </li>
                  <li>
                    <a href="#" class="blog">Blog</a>
                  </li>
                  <li>
                    <a href="#" class="knowledge">Kiến thức</a>
                  </li>
                </ul>
                <ul>
                  <li>
                    <a href="#" class="introduce">Giới thiệu</a>
                  </li>
                  <li>
                    <a href="#" class="promotion">Khuyến mãi</a>
                  </li>
                  <li>
                    <a href="#" class="contact">Liên hệ</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

        <% ImageDAO img=new ImageDAO();
          String image="avatar.png";
          Connection connection=img.connect();
          Statement statement=connection.createStatement();
          String sql="Select img_url from imgs where img_url= '" + image +   "'";
          ResultSet resultSet= statement.executeQuery(sql);
          while(resultSet.next()){
            String imgUrl = resultSet.getString("img_url");
            if(imgUrl.equals(image)){


            %>
          <img src="img/<%=imgUrl%>" alt="Img" width="30px;" style="position: absolute;z-index: 1000">


        <%
            }
            break;
          }

          resultSet.close();
          statement.close();
          connection.close();

        %>

      <!-- line -->
      <div class="line"></div>
      <div class="disigner">
        Được thiết kế bởi Thanh Tân, Tú Nguyệt, Nhựt Tân
      </div>
    </section>
  </div>
  <script>
    function test(){
      <%%>
    }
  </script>
</body>

</html>