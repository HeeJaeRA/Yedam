let item = document.querySelector('#item');
let addBtn = document.querySelector('#add');

let items = [];

addBtn.onclick = addItem;

//enter키 submit reload 방지
let div = document.querySelector('#wrapper');
div.addEventListener('submit', function(e) {
    e.preventDefault();
});
//인풋박스에서 엔터키 눌렀을때 addItem() 실행
item.addEventListener('keypress', function(e) {
    if (e.keyCode === 13) {
        addItem();
    }
});

function addItem() {
    let inputItem = item.value;
    if (inputItem == '') {
        alert('여행 준비물을 입력하세요.');
    } else {
        if (items.indexOf(inputItem) == -1) {
            items.unshift(inputItem);
            item.value = '';
            item.focus();
        }
        else {
            alert('이미 추가된 준비물입니다.');
            item.value = '';
            item.focus();
        }
    }
    showItem();
}

function showItem() {
    let ilist = `<ul>`;
    for (let i in items) {
        ilist += `<li>${items[i]} <span class="close" id="${i}">X</span></li>`
    }
    ilist += '</ul>'
    document.querySelector('#itemList').innerHTML = ilist;

    let dList = document.querySelectorAll('.close');
    for (let element of dList){
        element.addEventListener('click', delItem)
    }
}

function delItem() {
    let delnum = this.getAttribute('id');
    items.splice(delnum, 1);
    showItem();
}