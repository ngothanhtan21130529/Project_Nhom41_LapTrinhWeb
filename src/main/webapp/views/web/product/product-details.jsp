<%@ page import="vn.edu.hcmuaf.model.Product" %>
<%@ page import="vn.edu.hcmuaf.dao.ProductDAO" %><%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 11/21/2023
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../../css/style.css" rel="stylesheet" type="text/css">

<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liên hệ</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="icon" href="../../../img/favicon.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/details.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/tablist.css">
</head>
<body>
<div class="non-light-box">
    <jsp:include page="../../header.jsp"></jsp:include>
</div>
<div class="container" style="margin-top: 150px">
    <div class="light-box">
        <div class="slide-img">
            <div class="slide-1 slide default">
                <img src="../../../img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="">
            </div>
            <div class="slide-2 slide">
                <img src="../../../img/spinel-tim-anh-kim-2.jpg" alt="">
            </div>
            <div class="slide-3 slide">
                <img src="../../../img/spinel-tim-anh-kim-3.jpg" alt="">
            </div>
            <div class="slide-4 slide">
                <img src="../../../img/spinel-tim-anh-kim-4.jpg" alt="">
            </div>
            <div class="slide-5 slide">
                <img src="../../../img/spinel-tim-anh-kim-5.jpg" alt="">
            </div>
        </div>
        <div class="queue">
            <img class="col-1 row active" src="../../../img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt=""
                 onclick="change_to(event, '.slide-1','col-1')">
            <img class="col-2 row" src="../../../img/spinel-tim-anh-kim-2.jpg" alt=""
                 onclick="change_to(event, '.slide-2','col-2')">
            <img class="col-3 row" src="../../../img/spinel-tim-anh-kim-3.jpg" alt=""
                 onclick="change_to(event, '.slide-3','col-3')">
            <img class="col-4 row" src="../../../img/spinel-tim-anh-kim-4.jpg" alt=""
                 onclick="change_to(event, '.slide-4','col-4')">
            <img class="col-5 row" src="../../../img/spinel-tim-anh-kim-5.jpg" alt=""
                 onclick="change_to(event, '.slide-5','col-5')">
        </div>
        <div class="close" onclick="blur_img()">&times;</div>
        <a class="prev" onclick="next_slide(-1)" style="color: black">&#10094;</a>
        <a class="next" onclick="next_slide(1)" style="color: black">&#10095;</a>
    </div>
    <div class="details non-light-box">
        <div class="detail-box-img" onclick="blur_img()">
            <div class="large-img">
                <img src="../../../img/SPINEL-TIM-ANH-KIM-768x768.jpg" alt="" class="img-1 img">
            </div>
            <div class="small-img">
                <img src="../../../img/spinel-tim-anh-kim-2.jpg" alt="" class="img-2 img">
                <img src="../../../img/spinel-tim-anh-kim-3.jpg" alt="" class="img-3 img">
                <img src="../../../img/spinel-tim-anh-kim-4.jpg" alt="" class="img-4 img">
                <img src="../../../img/spinel-tim-anh-kim-5.jpg" alt="" class="img-5 img">
            </div>
        </div>
        <div class="details-text-box">
            <div class="product-id">
                Mã: KG-SPF-027
            </div>
            <div class="product-name">
                Spinel tím ánh kim
            </div>

            <div class="black-line"></div>

            <div class="rating">
                <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
                <i class="fa-solid fa-star fa-sm" style="color: #f4ab00;"></i>
            </div>
            <div class="price">
                18.000.000<u>đ</u>
            </div>
            <div class="description-product">
                <p>
                    Spinel tím ánh kim thể hiện sự cá tính mạnh mẽ, màu sắc này rất được các cô gái Tây ưa chuộng.
                    Tuy
                    nhiên, bạn có thể dùng nó để bản thân mình trở nên khác biệt hơn. Hãy mix nó cùng với mái tóc
                    móc
                    tím của bạn nhé!
                </p>
            </div>
            <div class="criteria-product">
                <ul>
                    <li>
                        Độ trong, sạch, lỗi: sạch 100%, lỗi rạn
                    </li>
                    <li>
                        Kiểm định và bảo hành trọn đời.
                    </li>
                    <li>
                        Miễn phí vận chuyển toàn quốc
                    </li>
                    <li>
                        Ship đảm bảo Quốc tế
                    </li>
                </ul>
            </div>
            <div class="recommendation">
                <p>
                    Hình ảnh, video trên website có thể chưa thể hiện vẻ đẹp, rõ nét nhất của thiết kế, kính mời quý
                    Anh/Chị liên hệ trực tiếp tham quan, trải nghiệm thực tế theo số ĐT: <a href="#">0856 174
                    581</a> hoặc qua
                    Zalo/Wechat: <a href="#">0856 174 581</a>để biết thêm chi tiết.
                </p>
            </div>
            <div class="advice">
                Tư vấn và thiết kế miễn phí 100%, đặt hàng theo mẫu khi quý khách mua Mẫu 3D của sản phẩm Spinel tím
                ánh kim KG-SPF-027
            </div>
            <div class="payment-cart">
                <a href="#" class="payment-button">
                    THANH TOÁN
                </a>
                <a href="#" class="cart-button">
                    GIỎ HÀNG
                </a>
            </div>
            <div class="contact">
                <div class="phone">
                    <i class="fa-solid fa-phone fa-sm" style="color: #495569;"></i>
                    Hotline:
                    <div class="phone-num">
                        0856 174 581
                    </div>
                </div>
                <div class="zalo">
                    Zalo:
                    <div class="zalo-num">0856 174 581</div>
                </div>
            </div>
            <div class="social-contact">
                <div class="contact-method">
                    <div class="facebook-icon">
                        <a href="#">
                            <i class="fa-brands fa-facebook fa-lg" style="color: #3a589d;"></i>
                        </a>
                    </div>
                    <div class="twitter-icon">
                        <a href="#">
                            <i class="fa-brands fa-square-twitter fa-lg" style="color: #2478ba;"></i>
                        </a>
                    </div>
                    <div class="google-plus-icon">
                        <a href="#">
                            <i class="fa-brands fa-google-plus fa-lg" style="color: #dd4e31;"></i>
                        </a>
                    </div>
                    <div class="mail-icon">
                        <a href="#">
                            <i class="fa-solid fa-envelope fa-lg" style="color: #111;"></i>
                        </a>
                    </div>
                    <div class="linkedin-icon">
                        <a href="#">
                            <i class="fa-brands fa-linkedin fa-lg" style="color: #0072b7;"></i>
                        </a>
                    </div>
                </div>
                <div class="share-on-social-media">
                    SHARE ON SOCIAL MEDIA
                </div>
            </div>
        </div>
    </div>
    <div class="information-products">
        <div class="tab">
            <button class="tablinks" onclick="toggleTab(event, 'Tab1')"> Thông số kỹ thuật <i
                    class="fas fa-chevron-down"></i></button>
            <div id="Tab1" class="tabcontent">
                <div class="column">
                    <ul>
                        <li><span>Loại đá:</span> Ruby</li>
                        <li><span>Màu đá:</span> Đỏ</li>
                        <li><span>Trọng lượng:</span> 1 carat</li>
                    </ul>
                </div>
                <div class="column">
                    <ul>
                        <li><span>Kích thước:</span> 2.5x12-3.5mm</li>
                        <li><span>Độ trong:</span> Chất ngọc làm sạch</li>
                        <li><span> Chất liệu:</span> Chất liệu từ thiên nhiên </li>
                        <li><span>Mô tả:</span> ...</li>
                    </ul>
                </div>
            </div>
            <button class="tablinks" onclick="toggleTab(event, 'Tab2')"> Bình luận <i class="fas fa-chevron-down"></i>
            </button>
            <div id="Tab2" class="tabcontent">
                <div class="comment">
                    <div class="customer-name">tran tu nguyet</div>
                    <div class="media-upload">
                        <img class="image-upload" src="img/twitter_profile_image.png" alt="Image">
                        <video class="video-upload" controls>
                            <source src="video.mp4" type="video/mp4">
                        </video>
                    </div>
                    <p class="comment-text">Đẹp dữ lắm.</p>
                    <button class="btn-comment" onclick="openPopup()">Viết bình luận</button>
                </div>

                <div id="popup" class="popup">
                    <button class="btn-close" onclick="closePopup()"><i class="fas fa-times"></i></i></button>
                    <textarea placeholder="Viết bình luận"></textarea>
                    <div class="input-comment">
                        <input class="input-text" type="text" placeholder="Nhập tên">
                        <input class="input-file" type="file" accept="image/*">
                    </div>
                    <button class="btn-submit">Gửi</button>
                </div>
            </div>
            <button class="tablinks" onclick="toggleTab(event, 'Tab3')"> Câu hỏi thường gặp <i
                    class="fas fa-chevron-down"></i></button>
            <div id="Tab3" class="tabcontent">
                <h3>Mua Online có ưu đãi gì đặc biệt cho tôi?</h3>
                <p>- Ưu đãi độc quyền Online với hình thức thanh toán đa dạng.</p>
                <p>- Đặt giữ hàng Online, nhận tại cửa hàng.</p>
                <h3>Có thu mua lại trang sức không?</h3>
                <p>TTN có thu mua lại trang sức, nếu quý khách hàng muốn bán lại trang sức có thể liên hệ thông
                    qua các phương thức liên hệ bên dưới. Chi tiết: <a href="contact.jsp">tại đây</a></p>
            </div>
        </div>
    </div>
    <div class="contact-number-choosing non-light-box">
        <a href="#" class="landline">
            <div class="landline-label">
                Số máy bàn
            </div>
            <div class="landline-num">
                08856 174 581
            </div>
        </a>
        <a href="#" class="hotline">
            <div class="hotline-label">
                Hotline
            </div>
            <div class="hotline-num">
                0856 174 581
            </div>
            <div class="time-line">
                (8h00 - 21h00)
            </div>
        </a>
        <a href="#" class="counselors">
            <div class="counselors-label">
                Tư vấn viên
            </div>
            <div class="counselors-num">
                0988 458 352
            </div>
        </a>
        <a href="#" class="chat-zalo-whatapp-wechat">
            <div class="chat-zalo-whatapp-wechat-label">
                Chat Zalo/Whatapp/Wechat
            </div>
            <div class="chat-zalo-whatapp-wechat-num">
                0856 174 581
            </div>
        </a>
    </div>
</div>
<jsp:include page="../../footer.jsp"></jsp:include>
<script src="js/details.js">
    // Function to toggle a specific tab
    function toggleTab(evt, tabName) {
        var tabcontent = document.getElementById(tabName);

        if (tabcontent.style.display === "none") {
            // Hide all tab content
            var tabcontents = document.getElementsByClassName("tabcontent");
            for (var i = 0; i < tabcontents.length; i++) {
                tabcontents[i].style.display = "none";
            }

            // Remove the "active" class from all tab buttons
            var tablinks = document.getElementsByClassName("tablinks");
            for (var i = 0; i < tablinks.length; i++) {
                tablinks[i].classList.remove("active");
            }

            // Show the specific tab content and mark the button as active
            tabcontent.style.display = "block";
            evt.currentTarget.classList.add("active");
        } else {
            // Toggle off the specific tab content and remove the "active" class from the button
            tabcontent.style.display = "none";
            evt.currentTarget.classList.remove("active");
        }
    }

    //     popup
    function openPopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "block";
    }

    function closePopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "none";
    }
</script>
<script>
    // Function to toggle a specific tab
    function toggleTab(evt, tabName) {
        var tabcontent = document.getElementById(tabName);

        if (tabcontent.style.display === "none") {
            // Hide all tab content
            var tabcontents = document.getElementsByClassName("tabcontent");
            for (var i = 0; i < tabcontents.length; i++) {
                tabcontents[i].style.display = "none";
            }

            // Remove the "active" class from all tab buttons
            var tablinks = document.getElementsByClassName("tablinks");
            for (var i = 0; i < tablinks.length; i++) {
                tablinks[i].classList.remove("active");
            }

            // Show the specific tab content and mark the button as active
            tabcontent.style.display = "block";
            evt.currentTarget.classList.add("active");
        } else {
            // Toggle off the specific tab content and remove the "active" class from the button
            tabcontent.style.display = "none";
            evt.currentTarget.classList.remove("active");
        }
    }

    //     popup
    function openPopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "block";
    }

    function closePopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "none";
    }
</script>
</body>
</html>
