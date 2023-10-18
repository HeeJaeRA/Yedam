package com.example.kiosk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.kiosk.service.UserServ;
import com.example.kiosk.service.UserVO;
import com.example.kiosk.serviceImpl.UserservImpl;

public class UserMenu {
	private Scanner sc = new Scanner(System.in);
	private UserServ us = new UserservImpl();
	
	public void run() {
		menu();
	}
	
	private void menuTitle() {
		System.out.println("------------------------------");
		System.out.println("1. 메뉴판  |  2. 주문  | 3. 종료");
		System.out.println("------------------------------");
	}
	
	private void menu() {
		boolean d = false;
		
		do {
			menuTitle();
			int selNum = Integer.parseInt(sc.nextLine());
			
			switch (selNum) {			
			case 1:
				selectAllProduct();
				break;
			case 2:
				System.out.println("주문하기");
				break;
			case 3:
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
		List<UserVO> products = new ArrayList<>();
		products = us.selectListUser();
		
		for (UserVO product : products) {
			product.toString();
		}
	}
}
