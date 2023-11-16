<<<<<<< HEAD

let content_home=document.getElementById("home");
let status_home=content_home.style.visibility='hidden';

let content_product=document.getElementById("product");
let status_product=content_product.style.visibility='hidden';


let content_order=document.getElementById("order");
let status_order=content_order.style.visibility='hidden';

let content_user=document.getElementById("user");
let status_user=content_user.style.visibility='hidden';
function click_home(){
    if(status_home==="hidden"){
        content_home.style.transition='opacity 2s';
        content_home.style.visibility='visible';
        content_product.style.visibility='hidden';
        content_order.style.visibility='hidden';
        content_user.style.visibility='hidden';
    }else{
        status_home=content_home.style.visibility='hidden';
    }
}
function click_product(){
    if(status_product==="hidden"){
        content_product.style.transition='opacity 2s';
        content_product.style.visibility='visible';
        content_order.style.visibility='hidden';
        content_home.style.visibility='hidden';
        content_user.style.visibility='hidden';
    }else{
        status_product=content_product.style.visibility='hidden';
    }
}
function click_order(){
    if(status_order==="hidden"){
        content_order.style.transition='opacity 2s';
        content_order.style.visibility='visible';
        content_product.style.visibility='hidden';
        content_home.style.visibility='hidden';
        content_user.style.visibility='hidden';
    }else{
        status_order=content_order.style.visibility='hidden';
    }
}
function click_user(){
    if(status_user==="hidden"){
        content_user.style.transition='opacity 2s';
        content_user.style.visibility='visible';
        content_product.style.visibility='hidden';
        content_order.style.visibility='hidden';
        content_home.style.visibility='hidden';
    }else{
        status_user=content_user.style.visibility='hidden';
=======
let content_trangchu=document.getElementById("trang_chu");
let status_trangchu=content_trangchu.style.visibility='hidden';

let content_sanpham=document.getElementById("san_pham");
let status_sanpham=content_sanpham.style.visibility='hidden';

let content_donhang=document.getElementById("don_hang");
let status_donhang=content_donhang.style.visibility='hidden';

let content_nguoidung=document.getElementById("nguoi_dung");
let status_nguoidung=content_nguoidung.style.visibility='hidden';
function click_trangchu(){
    if(status_trangchu==="hidden"){
        content_trangchu.style.transition='opacity 2s';
        content_trangchu.style.visibility='visible';
        content_sanpham.style.visibility='hidden';
        content_donhang.style.visibility='hidden';
        content_nguoidung.style.visibility='hidden';
    }else{
        status_trangchu=content_trangchu.style.visibility='hidden';
    }
}
function click_sanpham(){
    if(status_sanpham==="hidden"){
        content_sanpham.style.transition='opacity 2s';
        content_sanpham.style.visibility='visible';
        content_donhang.style.visibility='hidden';
        content_trangchu.style.visibility='hidden';
        content_nguoidung.style.visibility='hidden';
    }else{
        status_sanpham=content_sanpham.style.visibility='hidden';
    }
}
function click_donhang(){
    if(status_donhang==="hidden"){
        content_donhang.style.transition='opacity 2s';
        content_donhang.style.visibility='visible';
        content_sanpham.style.visibility='hidden';
        content_trangchu.style.visibility='hidden';
        content_nguoidung.style.visibility='hidden';
    }else{
        status_donhang=content_donhang.style.visibility='hidden';
    }
}
function click_nguoidung(){
    if(status_nguoidung==="hidden"){
        content_nguoidung.style.transition='opacity 2s';
        content_nguoidung.style.visibility='visible';
        content_sanpham.style.visibility='hidden';
        content_donhang.style.visibility='hidden';
        content_trangchu.style.visibility='hidden';
    }else{
        status_nguoidung=content_nguoidung.style.visibility='hidden';
>>>>>>> ad8e5e4cc36e636a4a4267e350cb9eb110e33085
    }
}