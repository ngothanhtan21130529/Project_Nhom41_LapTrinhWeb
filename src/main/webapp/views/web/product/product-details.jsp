<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">
    <title>Trang chủ</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="../font/fontawesome-free-6.4.2/css/all.css">
    <link href="<%=request.getContextPath()%>/css/footer.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
<%--    header--%>
    <jsp:include page="/views/header.jsp"></jsp:include>
<%--    main--%>
    <div class="container" style="margin-top: 150px">
    <div class="light-box">
        <div class="slide-img">
            <c:forEach var="imageURL" items="${productDetail.images}">
                <div class="slide">
                    <img src="${imageURL}" alt="">
                        ${imageURL}
                </div>
            </c:forEach>
        </div>
    </div>
    </div>
<%--    footer--%>
    <jsp:include page="/views/footer.jsp"></jsp:include>
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
</div>
</body>
</html>