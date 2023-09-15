// 입력상자와 버튼에 접근
let book = document.querySelector('#book');
let addBtn = document.querySelector('#add');

// 도서 목록 저장 배열 생성
let books = [];

// 추가 버튼에 클릭 이벤트 연결
addBtn.onclick = addBook;

// 배열에 도서 목록 추가
function addBook() {
    let inputB = book.value;
    if (inputB == ''){
        alert('책 제목을 입력하세요.');
        book.focus();
    } else {
        if (books.indexOf(inputB) == -1) {
            books.unshift(inputB);
            book.value = '';
            book.focus();
        }
        else {
            alert('중복입니다.');
            book.value = '';
            book.focus();
        }
    }
    showBook();
}

// 문서에 도서목록 출력(<ul><li>)
function showBook() {
    let blist = `<ul>`;
    for (let i in books) {
        blist += `<li>${books[i]}
        <span class="del" id="${i}">삭제</span></li>`
    }
    blist += `</ul>`
    document.querySelector('#bookList').innerHTML = blist;

    let delList = document.querySelectorAll('.del');
    for(let ele of delList){
        ele.addEventListener('click', delBook)
    }
}

// 문서에 도서 목록 삭제
function delBook() {
    let delnum = this.getAttribute('id');
    books.splice(delnum,1);
    showBook();
}
