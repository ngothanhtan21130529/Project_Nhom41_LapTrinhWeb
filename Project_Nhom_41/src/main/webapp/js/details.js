function open_tab(evt, tab_name){
    var i, tab_content, tab_links;
    
    tab_content=document.getElementsByClassName('tab-content');
    for (let i = 0; i < tab_content.length; i++) {
        tab_content[i].style.display='none';
    }

    tab_links=document.getElementsByClassName('tablinks');
    for (let i = 0; i < tab_links.length; i++) {
        tab_links[i].className=tab_links[i].className.replace(' active', '');
    }

    document.getElementById(tab_name).style.display='block';
    evt.currentTarget.className+=' active';
}
function scroll_down(){
    var screen=document.querySelector('.table-contents');
    if(screen.style.display=='block'||screen.style.display==''){
        screen.style.display='none';
    }
    else if(screen.style.display='none'){
        screen.style.display='block';
    }
}
document.getElementById('default-open').click();