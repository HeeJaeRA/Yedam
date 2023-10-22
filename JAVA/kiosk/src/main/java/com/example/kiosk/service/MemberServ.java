package com.example.kiosk.service;

import java.util.List;

public interface MemberServ {
	
	List<MemberVO> loginMemeber();
	
	int joinMember(MemberVO vo);
	
	int updateMember(MemberVO vo);
	
	int deleteMember(MemberVO vo);
}
