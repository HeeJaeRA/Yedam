package com.example.kiosk.common.login;

import java.util.Scanner;

import com.example.kiosk.menu.AdminMenu;
import com.example.kiosk.menu.UserMenu;

public class Login {
	
	private Scanner sc = new Scanner(System.in);
	private static final String ID = "ADMIN";
	private static final String PW = "0000";

	public void login() {
		
		System.out.print("아이디> ");
		String inputID = sc.nextLine();
		inputID = inputID.toUpperCase();
				
		System.out.print("비밀번호> ");
		String inputPW = sc.nextLine();
		
		if (ID.equals(inputID) && PW.equals(inputPW)) {
			System.out.println("관리자님 환영합니다");
			AdminMenu adminMenu = new AdminMenu();
			adminMenu.run();
		} else {
			System.out.printf("%s님 환영합니다.\n", inputID);
			UserMenu userMenu = new UserMenu();
			userMenu.run();
		}

	}

}
