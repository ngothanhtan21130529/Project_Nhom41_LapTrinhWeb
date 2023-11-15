<<<<<<< HEAD
let content_home=document.getElementById("home");
let status_home=content_home.style.visibility='hidden';

let content_product=document.getElementById("product");
let status_product=content_product.style.visibility='hidden';
=======
let content_trangchu=document.getElementById("trang_chu");
let status_trangchu=content_trangchu.style.visibility='hidden';
>>>>>>> 2c487217694f92c99450dd969d52b44a546d8ac1

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
    }
}