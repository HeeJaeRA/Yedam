package com.example.kiosk.service;

public class MemberVO {
	//DTO
	private String memberId;
	private String memberPw;
	private int memberOnumber;
	private int memberOprice;
	private String memberGrade;
	
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
	
	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	@Override
	public String toString() {
		System.out.printf("아이디: %8s\t비밀번호: %8s  주문 횟수: %3d회\t주문 금액: %8d원\t회원등급: %5s\n", memberId, memberPw, memberOnumber, memberOprice, memberGrade);
		return null;
	}

	public void print() {
		System.out.printf("회원 등급: %4s  주문횟수: %3d회  주문금액: %8d원\n", memberGrade, memberOnumber, memberOprice);			
	}
	
}
