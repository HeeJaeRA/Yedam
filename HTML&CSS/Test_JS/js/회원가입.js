let inputId = document.querySelector('#user-id');
let inputPw = document.querySelector('#user-pw1');
let inputPwc = document.querySelector('#user-pw2');

inputId.onchange = checkId;
inputPw.onchange = checkPw;
inputPwc.onchange = checkPwc;

function checkId() {
    let id_len = inputId.value.length;
    if (id_len < 4 || id_len > 15){
        alert('4자리 이상 15자리 이하로 입력하세요');
        inputId.select();
    }
}

function checkPw() {
    let pw_len = inputPw.value.length;
    if (pw_len < 8) {
        alert('비밀번호는 8자리 이상입니다.');
        inputPw.value = '';
        inputPw.focus();
    }
}

function checkPwc() {
    if(inputPw.value != inputPwc.value){
        alert('비밀번호가 일치하지 않습니다.');
        inputPwc.value = '';
        inputPwc.focus();
    }
}