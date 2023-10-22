package com.example.kiosk.service;

public class MemberVO {
	
	private String memberId;
	private String memberPw;
	private int memberOnumber;
	private int memberOprice;
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	
	public int getMemberOnumber() {
		return memberOnumber;
	}

	public void setMemberOnumber(int memberOnumber) {
		this.memberOnumber = memberOnumber;
	}

	public int getMemberOprice() {
		return memberOprice;
	}

	public void setMemberOprice(int memberOprice) {
		this.memberOprice = memberOprice;
	}

	@Override
	public String toString() {
		System.out.printf("아이디: %8s\t비밀번호: %8s  주문횟수: %3d회\t주문금액: %8d원\n", memberId, memberPw, memberOnumber, memberOprice);
		return null;
	}
	
}
