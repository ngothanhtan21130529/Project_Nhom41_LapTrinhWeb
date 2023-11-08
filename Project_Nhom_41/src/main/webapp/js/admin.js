let content_quanli=document.getElementById("quan_li");
let status_quanli=content_quanli.style.visibility='hidden';
let content_sanpham=document.getElementById("san_pham");
let status_sanpham=content_sanpham.style.visibility='hidden';
let content_donhang=document.getElementById("don_hang");
let status_donhang=content_donhang.style.visibility='hidden';
function click_quanli(){
    if(status_quanli==="hidden"){
        content_quanli.style.transition='opacity 2s';
        content_quanli.style.visibility='visible';
        content_sanpham.style.visibility='hidden';
        content_donhang.style.visibility='hidden';
    }else{
        status_quanli=content_quanli.style.visibility='hidden';

    }
}
function click_sanpham(){
    if(status_sanpham==="hidden"){
        content_sanpham.style.transition='opacity 2s';
        content_sanpham.style.visibility='visible';
        content_quanli.style.visibility='hidden';
        content_donhang.style.visibility='hidden';
    }else{
        status_sanpham=content_sanpham.style.visibility='hidden';
    }
}
function click_donhang(){
    if(status_donhang==="hidden"){
        content_donhang.style.transition='opacity 2s';
        content_donhang.style.visibility='visible';
        content_quanli.style.visibility='hidden';
        content_sanpham.style.visibility='hidden';
    }else{
        status_donhang=content_donhang.style.visibility='hidden';
    }
}