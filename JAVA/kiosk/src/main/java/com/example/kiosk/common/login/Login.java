package com.example.kiosk.common.login;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.example.kiosk.menu.AdminMenu;
import com.example.kiosk.menu.UserMenu;
import com.example.kiosk.service.MemberServ;
import com.example.kiosk.service.MemberVO;
import com.example.kiosk.serviceImpl.MemberImpl;

public class Login {
	private Scanner sc = new Scanner(System.in);
	private MemberServ mb = new MemberImpl();
	
	public void login() {
		
		System.out.println("----------------------------------------------------------");
		System.out.println("예담 햄버거에 오신 것을 환영합니다.");
		System.out.println("----------------------------------------------------------");
		System.out.println("1. 관리자 로그인 | 2. 사용자 로그인 | 3. 회원가입 | 4. 종료");
		System.out.println("----------------------------------------------------------");
		System.out.print("> ");
		String selNum = sc.nextLine();
		
		switch (selNum) {
		case "1":
			loginAdmin();
			break;
		case "2":
			loginUser();
			break;
		case "3":
			join();
			System.out.println("로그인 페이지로 이동합니다.");
			loginUser();
			break;
		case "4":
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("다시 입력하세요.");
			login();
		}
	}

	private void loginAdmin() {
		System.out.print("아이디> ");
		String inputID = sc.nextLine();
				
		System.out.print("비밀번호> ");
		String inputPW = sc.nextLine();
		
		List<MemberVO> members = new ArrayList<>();
		members = mb.loginMemeber();
		
		String aID = null;
		String aPW = null;
		
		for (MemberVO member : members) {
			if (member.getMemberId().equals("ADMIN")) {
				aID = member.getMemberId();
				aPW = member.getMemberPw();
			} 
		}
		
		if (aID.equals(inputID.toUpperCase())) {
			if (aPW.equals(inputPW)) {
				System.out.println("관리자님 환영합니다");
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.run();				
			} else {
				System.out.println("관리자 계정 비밀번호 오류");
				login();
			}
		} else {
			System.out.println("로그인 실패");
			login();
		}
	}
	
	private void loginUser() {
		System.out.print("아이디> ");
		String inputID = sc.nextLine().toUpperCase();
				
		System.out.print("비밀번호> ");
		String inputPW = sc.nextLine();
		
		List<MemberVO> members = new ArrayList<>();
		members = mb.loginMemeber();
		
		String uID = null;
		String uPW = null;
		
		try {
			if (!inputID.toUpperCase().equals("ADMIN")) {
				for (MemberVO member : members) {
					if (member.getMemberId().equals(inputID)) {
						uID = member.getMemberId();
						uPW = member.getMemberPw();
					}
				}
				if (uID.equals(inputID)) {
					if (uPW.equals(inputPW)) {
						System.out.printf("%s님 환영합니다\n", uID);
						UserMenu userMenu = new UserMenu();
						userMenu.run(uID);				
					} else {
						System.out.println("비밀번호 오류");
						login();
					}
				}			
			} else {
				System.out.println("관리자 로그인 메뉴를 사용하세요.");
				login();
			}
		} catch (NullPointerException e) {
			System.out.println("아이디가 존재하지 않습니다.");
			login();
		}
	}
	
	private void join() {
		MemberVO vo = new MemberVO();
		
		System.out.println("회원가입 메뉴입니다.");
		System.out.print("아이디> ");
		String inputID = sc.nextLine().toUpperCase();
		vo.setMemberId(inputID);
		
		System.out.print("비밀번호> ");
		String inputPW = sc.nextLine();
		vo.setMemberPw(inputPW);
		
		List<MemberVO> members = new ArrayList<>();
		members = mb.loginMemeber();
		
		for (MemberVO member : members) {
			if (member.getMemberId().equals(inputID)) {
				System.out.println("이미 존재하는 ID입니다.\n");
				join();
			} else {
				mb.joinMember(vo);
			}
		}
	}

}
