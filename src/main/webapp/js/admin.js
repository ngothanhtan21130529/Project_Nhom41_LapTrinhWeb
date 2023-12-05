function changeToHomepage(){
    let contentTab=document.querySelectorAll('.content-tab');
    contentTab.forEach(e=>{
        e.style.display='none';
    });
    document.querySelector('.hompage-admin-tab').style.display='block';
    document.querySelector('.homepage-website-text').innerHTML='Trang chủ website';
}
function changeToCategoriesTab(){
    let contentTab=document.querySelectorAll('.content-tab');
    contentTab.forEach(e=>{
        e.style.display='none';
    });
    document.querySelector('.categories-main-tab').style.display='block';
    document.querySelector('.homepage-website-text').innerHTML='Trang chủ > Danh mục > Loại danh mục';
}
function changeToCategoriesAddingTab(){
    let contentTab=document.querySelectorAll('.content-tab');
    contentTab.forEach(e=>{
        e.style.display='none';
    });
    document.querySelector('.categories-adding-tab').style.display='block';
    document.querySelector('.categories-adding-tab-general-infomation').style.display='grid';

    document.querySelector('.homepage-website-text').innerHTML='Trang chủ > Danh mục > Loại danh mục > Sửa';
}
function changeToProductTab(){
    let contentTab=document.querySelectorAll('.content-tab');
    contentTab.forEach(e=>{
        e.style.display='none';
    });
    document.querySelector('.product-main-tab').style.display='block';
    document.querySelector('.homepage-website-text').innerHTML='Trang chủ > Danh mục > Sản phẩm';
}
function changeToProductAddingTab(){
    let contentTab=document.querySelectorAll('.content-tab');
    contentTab.forEach(e=>{
        e.style.display='none';
    });
    document.querySelector('.product-adding-tab').style.display='block';
    document.querySelector('.homepage-website-text').innerHTML='Trang chủ > Danh mục > Sản phẩm > Sửa';
}
function changeToOnlineSupportTab(){
    let contentTab=document.querySelectorAll('.content-tab');
    contentTab.forEach(e=>{
        e.style.display='none';
    });
    document.querySelector('.online-support-tab').style.display='block';
    document.querySelector('.homepage-website-text').innerHTML='Trang chủ > Danh mục > Sản phẩm > Sửa';
}