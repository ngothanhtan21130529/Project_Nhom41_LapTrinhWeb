// let home_page=document.getElementById("home-page");
// let status_1=home_page.style.visibility='hidden';

// function change(){
//     if(status_1==="hidden"){
//         home_page.style.transition='opacity 2s';
//         home_page.style.visibility='visible';
//     }else{
//         status_1=home_page.style.visibility='hidden';
//     }
// }

function change(event, menu_name){
    var menu_content, menu_link;

    menu_content=document.getElementsByClassName('menu-page');
    for (let i = 0; i < menu_content.length; i++) {
        menu_content[i].style.display='none';
    }
    menu_link=document.getElementsByClassName('menu-links');
    for (let i = 0; i < menu_link.length; i++) {
        menu_link[i].className=menu_link[i].className.replace(' active', '');
    }
    document.getElementById(menu_name).style.display='block';
    event.currentTarget.className+=' active';
}
