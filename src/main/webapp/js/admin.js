document.querySelector('.categories-management-button').addEventListener('click', scrollDownCategoriesManagement);

function changeToHomepage() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.hompage-admin-tab').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ website';
}

function changeToCategoriesTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.categories-main-tab').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị danh mục > Loại danh mục';
}

function changeToCategoriesAddingTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.categories-adding-tab').style.display = 'block';
    document.querySelector('.categories-adding-tab-general-infomation').style.display = 'grid';

    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị danh mục > Loại danh mục > Thêm mới';
}

function changeToProductTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.product-main-tab').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị danh mục > Sản phẩm';
}

function changeToProductAddingTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.product-adding-tab').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị danh mục > Sản phẩm > Sửa';
}

function changeToProductSlideShow() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.product-slide-show').style.display = 'grid';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị giao diện > Slide Show';
}

function changeToJewelrySlideShow() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.jewelry-slide-show').style.display = 'grid';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị giao diện > Slide Show';
}

function changeToGemSlideShow() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.gem-slide-show').style.display = 'grid';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị giao diện > Slide Show';
}

function changeToHomePageSlideShow() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.homepage-slide-show').style.display = 'grid';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị giao diện > Slide Show';
}

function changeToOnlineSupportTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.online-support-tab').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị giao diện > Hỗ trợ trực tuyến';
}

function changeToInformationTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.information-tab').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị giao diện > Thông tin';
}

function changeToOrderListTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.order-list').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị thông tin > Danh sách đơn hàng';
}

function changeToCustomerContactTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.customer-contact').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Quản trị thông tin > Khách hàng liên hệ';
}

function changeToUserManagement() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.user-management-tab').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Cấu hình người dùng > Quản lý người dùng';
}

function changeToUserInformationTab() {
    let contentTab = document.querySelectorAll('.content-tab');
    contentTab.forEach(e => {
        e.style.display = 'none';
    });
    document.querySelector('.inventories-management').style.display = 'block';
    document.querySelector('.homepage-website-text').innerHTML = 'Trang chủ > Cấu hình người dùng > Quản lý số lượng tồn kho';
}


function scrollDownCategoriesManagement() {
    let screens = document.querySelectorAll('.categories-tab-element');
    screens.forEach(e => {
        if (e.style.display == 'none') {
            e.style.display = 'block';
        } else {
            e.style.display = 'none';
        }
    });
}

function scrollDownUIMangement() {
    let screens = document.querySelectorAll('.ui-tab-element');
    screens.forEach(e => {
        if (e.style.display == 'none') {
            e.style.display = 'block';
        } else {
            e.style.display = 'none';
        }
    });
}

function scrollDownInformationManagement() {
    let screens = document.querySelectorAll('.infor-tab-element');
    screens.forEach(e => {
        if (e.style.display == 'none') {
            e.style.display = 'block';
        } else {
            e.style.display = 'none';
        }
    });
}

function scrollDownUserConfiguration() {
    let screens = document.querySelectorAll('.user-config-element');
    screens.forEach(e => {
        if (e.style.display == 'none') {
            e.style.display = 'block';
        } else {
            e.style.display = 'none';
        }
    });
}

function showMessCategory(id) {
    let option = confirm("Xác nhận xoá?");
    if (option) {
        window.location.href = 'DeleteCategory?id=' + id;
    }
};


