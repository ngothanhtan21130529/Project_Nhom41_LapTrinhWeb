function open_tab(evt, tab_name) {
    var i, tab_content, tab_links;

    tab_content = document.getElementsByClassName('tab-content');
    for (let i = 0; i < tab_content.length; i++) {
        tab_content[i].style.display = 'none';
    }

    tab_links = document.getElementsByClassName('tablinks');
    for (let i = 0; i < tab_links.length; i++) {
        tab_links[i].className = tab_links[i].className.replace(' active', '');
    }

    document.getElementById(tab_name).style.display = 'block';
    evt.currentTarget.className += ' active';
}
function scroll_down() {
    var screen = document.querySelector('.table-contents');
    if (screen.style.display == 'block' || screen.style.display == '') {
        screen.style.display = 'none';
    }
    else if (screen.style.display = 'none') {
        screen.style.display = 'block';
    }
}
document.getElementById('default-open').click();

function blur_img() {
    let current = document.querySelectorAll('.img');
    let non_light_box = document.querySelectorAll('.non-light-box');
    non_light_box.forEach(element => {
        if (element.style.filter == 'blur(20px) brightness(50%)') {
            element.style.filter = 'blur(0px) brightness()';
            element.style.userSelect = 'auto';
        } else {
            element.style.filter = 'blur(20px) brightness(50%)';
            element.style.userSelect = 'none';
        }
    });

    if (document.body.style.overflow != 'hidden') {
        document.body.style.overflow = 'hidden';
    } else {
        document.body.style.overflow = 'auto';
    }
    let light_box = document.querySelector('.light-box');
    let queue=document.querySelector('.queue');
    if (light_box.style.visibility != 'visible') {
        document.querySelector('.default').style.visibility = 'visible';
        light_box.style.visibility = 'visible' ;
    } else {
        let slide_img = document.querySelectorAll('.slide');
        slide_img.forEach(element => {
            element.style.visibility = 'hidden';
        });
        light_box.style.visibility = 'hidden';
    }
    let row=document.querySelectorAll('.row');
    row.forEach(e=>{
        e.classList.remove('active');
    })
    document.querySelector('.col-1').className+=' active';
}
function change_to(event, img, selector) {
    let current = document.querySelectorAll(".slide");
    let queue = document.querySelectorAll('.row');
    current.forEach(current => {
        current.style.visibility = 'hidden';
    });
    queue.forEach(element => {
        element.classList.remove('active');
    });
    document.querySelector(img).style.visibility = 'visible';
    event.currentTarget.className += ' active';
}
var slide_index = 0;
function next_slide(n) {
    show_slide(slide_index += n);
}
function show_slide(n) {
    let slides = document.querySelectorAll('.slide');
    let dots = document.querySelectorAll('.row');
    if (n == slides.length) slide_index = 0;
    else if (n < 0 || isNaN(n)) slide_index = slides.length-1;
    slides.forEach(element => {
        element.style.visibility = 'hidden';
    });
    for (let i=0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(' active', '');
    }
    slides[slide_index].style.visibility = 'visible';
    dots[slide_index].className += ' active';
}
function setHiddenFieldValues(){
	var name=document.querySelector('.product-name');
	var price=document.querySelector('.price');
	var img=document.querySelector('.first-img').src;
	var nameHidden=document.querySelector('.nameHidden');
}