package com.example.kiosk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.kiosk.service.AdminServ;
import com.example.kiosk.service.AdminVO;
import com.example.kiosk.serviceImpl.AdminservImpl;

public class AdminMenu {
	private Scanner sc = new Scanner(System.in);
	private AdminServ ad = new AdminservImpl();
	
	public void run() {
		menu();
	}
	
	private void menuTitle() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("1. 제품 조회 | 2. 제품 추가 | 3. 제품 수정 | 4. 제품 삭제 | 5. 종료");
		System.out.println("-------------------------------------------------------------");
	}
	
	private void menu() {
		boolean d = false;
		
		do {
			menuTitle();
			int selNum = Integer.parseInt(sc.nextLine());
			
			switch (selNum) {			
			case 1:
//				System.out.println("제품번호 제품종류\t\t제품이름\t\t제품가격\t\t칼로리");
				selectAllProduct();
				break;				
			case 2:
				insert();
				break;				
			case 3:
				update();
				break;				
			case 4:
				delete();
				break;				
			case 5:
				System.out.println("프로그램 종료");
				d = true;
				break;			
			default:
				System.out.println("다시 입력하세요.");
				break;
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
	
	private void insert() {
		// 컬럼 전부 추가
		AdminVO vo = new AdminVO();
		
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
	
	private void update() {
		// 제품명, 가격, 칼로리만 수정 가능
		AdminVO vo = new AdminVO();
		
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
	
	private void delete() {
		// 제품명으로 삭제
		AdminVO vo = new AdminVO();
		
		System.out.println("삭제할 제품명> ");
		String name = sc.nextLine();
		vo.setProductName(name);
		
		ad.deleteProduct(vo);		
	}

}
