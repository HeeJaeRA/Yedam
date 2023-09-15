function form_check() {
    let p = document.querySelector('#u_pw');
    let p_c = document.querySelector('#u_pwc');
    
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
