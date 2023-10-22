package com.example.kiosk.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.kiosk.common.login.Login;
import com.example.kiosk.service.UserServ;
import com.example.kiosk.service.UserVO;
import com.example.kiosk.serviceImpl.UserservImpl;


public class UserMenu {
	private Scanner sc = new Scanner(System.in);
	private UserServ us = new UserservImpl();
	Login login = new Login();
	
	public void run(String uID) {
		menu(uID);
	}
	
	private void menuTitle() {
		System.out.println("-------------------------------------------");
		System.out.println("1. 메뉴판  |  2. 주문  |  3. 로그아웃  |  0. 종료");
		System.out.println("-------------------------------------------");
	}
	
	private void menu(String uID) {
		boolean d = false;
		
		do {
			menuTitle();
			int selNum = Integer.parseInt(sc.nextLine());
			
			switch (selNum) {			
			case 1:
				// 전체 조회
				selectAllProduct();
				break;
			case 2:
				// 주문
				listProduct();
				orderProduct(uID);
				break;
			case 3:
				// 로그아웃
				login.login();
				d = true;
				break;
			case 0:
				// 로그아웃
				System.out.println("프로그램 종료");
				d = true;
				break;
			default :
				System.out.println("다시 입력하세요.");
				break;
			} 	
		}while(!d);
	}

	private void selectAllProduct() {
		// 전체 메뉴판
		List<UserVO> products = new ArrayList<>();
		products = us.selectListUser();
		
		for (UserVO product : products) {
			product.toString();
		}
	}
	
	private void listProduct() {
		// 간이 메뉴판
		List<UserVO> products = new ArrayList<>();
		products = us.productList();		
		int cnt = 0;		
		for (UserVO product : products) {
			cnt++;
			if (cnt % 5 == 0) {
				product.print();
				System.out.println();
			} else {
				product.print();				
			}
		}
		System.out.println("\n");
	}
	
	private void orderProduct(String uID) {
		// 제품명으로 주문
		try {
			us.orderList(uID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("결제 완료");
	}

}
