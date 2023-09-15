//input 상자 접근
let inputId = document.querySelector('#user-id');
let inputPw = document.querySelector('#user-pw1');
let inputPwc = document.querySelector('#user-pw2');

//입력상자에 값이 바뀌는 이벤트 발생하면 이벤트 핸들러 연결
inputId.onchange = checkId;
inputPw.onchange = checkPw;
inputPwc.onchange = checkPwc;

// id 길이 체크
function checkId() {
    let id_len = inputId.value.length;    
    if(id_len < 3 || id_len > 10) {
        alert('3자리 이상 10자리 이하로 입력하세요.');
        inputId.select();
    }
}

//비밀번호 길이 체크
function checkPw() {
    let pw_len = inputPw.value.length;
    if (pw_len < 4) {
        alert('비밀번호는 4자리 이상입니다.');
        inputPw.value = '';
        inputPw.focus();
    }
}

// 비밀번호가 맞는지 확인
function checkPwc() {
    if (inputPw.value != inputPwc.value) {
        alert('비밀번호가 일치하지 않습니다.');
        inputPwc.value = '';
        inputPwc.focus();
    }
}
