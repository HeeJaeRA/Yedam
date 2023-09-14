function form_check() {
    let n = document.querySelector('#u_name');
    let p = document.querySelector('#u_pw');
    let p_c = document.querySelector('#u_pwc');

    //이름 체크
    if (n.length < 3){
        alert("3자 이상 입력하세요.");
        n.focus();
        return false;
    }
    
    //비밀번호 체크
    if (p != p_c) {
        alert("비밀번호가 다릅니다.");
        p_c.focus();
        return false;
    }

    else {
        return true;
    }
}
