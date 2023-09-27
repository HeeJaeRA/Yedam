package ch4;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Scanner scanner = new Scanner(System.in);
		
//		System.out.print("##년도 입력: ");
//		int year = scanner.nextInt();
//		
//		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
//			System.out.printf("%d년은 윤년입니다.\n", year);
//		} else {
//			System.out.printf("%d년은 평년입니다.\n", year);
//		}
//		
//		System.out.print("\n##교환할 금액: ");
//		int money = scanner.nextInt();
//		
//		int mo500 = money / 500;
//		int mo100 = (money - (mo500 * 500)) / 100;
//		int mo50 = (money - (mo500 * 500) - (mo100 * 100)) / 50;
//		int mo10 = (money - (mo500 * 500) - (mo100 * 100) - (mo50 * 50)) / 10;
//		int mo = money % 10;
//		
//		System.out.printf("500원 짜리 : %d개\n", mo500);
//		System.out.printf("100원 짜리 : %d개\n", mo100);
//		System.out.printf("50원 짜리 : %d개\n", mo50);
//		System.out.printf("10원 짜리 : %d개\n", mo10);
//		System.out.printf("교환 금액 : %d원\n", money - mo);
//		System.out.printf("남은 금액 : %d원\n", mo);
		

//		int result = money;
//		int mo500 = money / 500;
//		money %= 500;
//		System.out.printf("500원 짜리 : %d개\n", mo500);
//		int mo100 = money / 100;
//		money %= 100;
//		System.out.printf("100원 짜리 : %d개\n", mo100);
//		int mo50 = money / 50;
//		money %= 50;
//		System.out.printf("50원 짜리 : %d개\n", mo50);
//		int mo10 = money / 10;
//		System.out.printf("10원 짜리 : %d개\n", mo10);
//		money %= 10;
//		
//		System.out.printf("교환 금액 : %d원\n", result - money);
//		
//		System.out.printf("남은 금액 : %d원\n", money);
		
//		int rnum = (int) (Math.random() * 100) + 1;
//		int cnt = 0;
//		
//		while(true) {
//			System.out.print("숫자 입력 : ");
//			int inum = scanner.nextInt();
//			cnt++;
//			
//			if (rnum == inum) {
//				System.out.println("축하합니다!!");
//				break;
//			} else if (rnum > inum) {
//				System.out.println("up하세요!!");
//			} else {
//				System.out.println("down하세요!!");
//			}			
//		}
//		System.out.printf("%d번 시도했습니다.\n", cnt);
		
//		for(int i = 2; i<= 9; i++) {
//			System.out.printf("  %d단\t", i);			
//		}
//		System.out.println();
//		
//		for(int i = 1; i <=9; i++) {			
//			for(int j = 2; j <= 9; j++) {				
//				System.out.printf("%dX%d=%2d\t", j, i, i*j);
//			}
//			System.out.println();
//		}
//		ondo: while(true) {
//			System.out.println("=====================");
//			System.out.println("1.화씨 => 섭씨");
//			System.out.println("2.섭씨 => 화씨");
//			System.out.println("3.종료");
//			System.out.println("=====================");
//			
//			System.out.print("▶ 번호 선택: ");
//			int selnum = scanner.nextInt();
//			
//			switch (selnum) {
//			
//			case 1:
//				System.out.print("▶ 화씨 온도 입력: ");
//				double hwa = scanner.nextDouble();
//				System.out.printf("\n섭씨 온도 = %.6f\n", (double) 5 / 9 * (hwa - 32));
//				break;
//			
//			case 2:
//				System.out.print("▶ 섭씨 온도 입력: ");
//				double sup = scanner.nextDouble();
//				System.out.printf("\n화씨 온도 = %.6f\n", (double) 9 / 5 * sup + 32);
//				break;
//				
//			case 3:
//				break ondo;
//				
//			default:
//				System.out.println("숫자만 입력하세요.");
//			}
//		}
//		System.out.println("program end");
		
//		int uwin = 0, cwin = 0, draw = 0, count = 0;
//		
//		while(true) {
//			System.out.print("## 가위(0) 바위(1) 보(2) : ");
//			int usern = scanner.nextInt();
//			int comn = (int) (Math.random() * 3);
//			
//			if (usern >= 3) {
//				System.out.println("game over");
//				break;
//			} else if ((usern + 1) % 3 == comn) {
//				cwin++;
//				System.out.printf("사람 %d, 컴 %d 컴퓨터 승리\n", usern, comn);
//			} else if (usern == comn) {
//				draw++;
//				System.out.printf("사람 %d, 컴 %d 비겼음\n", usern, comn);
//			} else {
//				uwin++;
//				System.out.printf("사람 %d, 컴 %d 사람 승리\n", usern, comn);
//			}
//			count++;
//		}
//		System.out.printf("총 게임 횟수: %d\n컴퓨터 승리: %d\n유저 승리: %d\n비긴 횟수: %d\n", count, cwin, uwin, draw);
		
//		for (int i = 4; i > 0; i--) {
//			for (int j = 1; j < 7-i; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 0; k < (i*2)-1; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for (int i = 2; i <= 4; i++) {
//			for (int j = 1; j < 7-i; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 0; k < (i*2)-1; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		String s = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 10; j++) {
				if (j % 3 == 0) {
					s += "짝";
				}
				else if (i != 0 && (i * 10) % 3 == 0) {
					s += "뽕  ";
				}
				else {
					System.out.printf("%2d  ", i*10 + j);					
				}
				System.out.print(s + " ");
				s = "";
			}
			System.out.println();
		}
		
		
		scanner.close();
	}

}
