package com.example.kiosk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.kiosk.common.login.Login;
import com.example.kiosk.service.AdminServ;
import com.example.kiosk.service.AdminVO;
import com.example.kiosk.service.MemberServ;
import com.example.kiosk.service.MemberVO;
import com.example.kiosk.serviceImpl.AdminservImpl;
import com.example.kiosk.serviceImpl.MemberImpl;

public class AdminMenu {
	private Scanner sc = new Scanner(System.in);
	private AdminServ ad = new AdminservImpl();
	private MemberServ mb = new MemberImpl();
	Login login = new Login();
	
	
	public void run() {
		menu();
	}
	
	private void menuTitle() {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("1. 제품 조회 | 2. 제품 추가 | 3. 제품 수정 | 4. 제품 삭제 | 5. 회원 관리 | 6. 로그아웃 | 0. 종료");
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	
	private void menu() {
		boolean d = false;
		do {
			menuTitle();
			String selNum = sc.nextLine();
			
			switch (selNum) {			
			case "1":
				// 전체 조회
				selectAllProduct();
				break;				
			case "2":
				// 추가
				insertProduct();
				break;				
			case "3":
				// 수정
				updateProduct();
				break;				
			case "4":
				// 삭제
				deleteProduct();
				break;				
			case "5":
				// 사용자 관리
				manageMemeber();
				break;			
			case "6":
				// 로그아웃
				login.login();
				d = true;
				break;
			case "0":
				// 프로그램 종료
				System.out.println("프로그램 종료");
				d = true;
				break;
			default:
				System.out.println("다시 입력하세요.");
			}			
		} while(!d);
	}
	
	private void selectAllProduct() {
		List<AdminVO> products = new ArrayList<>();
		products = ad.selectListAdmin();
		
		for (AdminVO product : products) {
			product.toString();
		}
	}

	private void insertProduct() {
		// 컬럼 전부 추가
		AdminVO vo = new AdminVO();
		
		System.out.println("햄버거 상품번호: 1~20 | 음료 상품번호: 21~40 | 사이드 상품번호: 41~60");
		
		System.out.println("상품번호> ");
		int key = Integer.parseInt(sc.nextLine());
		vo.setProductKey(key);
		
		System.out.println("종류> ");
		String type = sc.nextLine();
		vo.setProductType(type);
		
		System.out.println("이름> ");
		String name = sc.nextLine();
		vo.setProductName(name);
		
		System.out.println("가격> ");
		int price = Integer.parseInt(sc.nextLine());
		vo.setProductPrice(price);
		
		System.out.println("칼로리> ");
		int kcal = Integer.parseInt(sc.nextLine());
		vo.setProductKcal(kcal);
		
		ad.insertProduct(vo);
	}
	
	private void updateProduct() {
		// 제품명, 가격, 칼로리만 수정 가능
		AdminVO vo = new AdminVO();
		
		System.out.println("햄버거 상품번호: 1~20 | 음료 상품번호: 21~40 | 사이드 상품번호: 41~60");
		
		System.out.println("수정할 제품번호> ");
		int key = Integer.parseInt(sc.nextLine());
		vo.setProductKey(key);
		
		System.out.println("이름> ");
		String name = sc.nextLine();
		vo.setProductName(name);
		
		System.out.println("가격> ");
		int price = Integer.parseInt(sc.nextLine());
		vo.setProductPrice(price);
		
		System.out.println("칼로리> ");
		int kcal = Integer.parseInt(sc.nextLine());
		vo.setProductKcal(kcal);
		
		ad.updateProduct(vo);
	}
	
	private void deleteProduct() {
		// 제품명으로 삭제
		AdminVO vo = new AdminVO();
		
		System.out.println("삭제할 제품명> ");
		String name = sc.nextLine();
		vo.setProductName(name);
		
		ad.deleteProduct(vo);		
	}
	
	private void manageMemeber() {
		boolean d = false;
		do {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1. 전체 조회 | 2. 비밀번호 초기화 | 3. 회원 삭제 | 4. 메인 메뉴");
			System.out.println("-----------------------------------------------------------");
			System.out.print("> ");
			String selNum = sc.nextLine();
			
			switch (selNum) {
			case "1":
				selectAllMember();
				break;
			case "2":
				updateMember();
				break;
			case "3":
				deleteMember();
				break;
			case "4":
				d = true;
				break;
			default:
				System.out.println("다시 입력하세요.");
			}
		} while(!d);
	}
	
	private void selectAllMember() {
		List<MemberVO> members = new ArrayList<>();
		members = mb.loginMemeber();
		for (MemberVO member : members) {
			member.toString();
		}
	}
	
	private void updateMember() {
		//비밀번호 0000으로 초기화
		MemberVO vo = new MemberVO();
		System.out.print("비밀번호 초기화 할 회원 아이디> ");
		String id = sc.nextLine().toUpperCase();
		vo.setMemberId(id);
		
		mb.updateMember(vo);
	}
	
	private void deleteMember() {
		// ID로 삭제
		MemberVO vo = new MemberVO();
		
		System.out.print("삭제할 회원 ID> ");
		String id = sc.nextLine().toUpperCase();
		vo.setMemberId(id);
		
		mb.deleteMember(vo);
	}

}
