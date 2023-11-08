
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
    }
}