package ch3;

import java.util.Scanner;

public class Exam160p {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("시작 단: ");
//		int start = Integer.parseInt(scanner.next());
		int start = scanner.nextInt();
		
		System.out.print("종료 단: ");
//		int stop = Integer.parseInt(scanner.next());
		int stop = scanner.nextInt();
		
		for (int i = start; i <= stop; i++) {
			System.out.printf("\n====%d단====\n", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %d\n", i, j, i*j);
				System.out.print("" + i + " X " + j + " = " + (i*j) + "\n");
			}
			System.out.println();
		}
		
		int sum = 0;
		
		for (int i = 1; i <= 30; i++) {
			if (i % 3 == 0) {
				System.out.printf("%d ", i);
				sum += i;
			}
		}
		System.out.printf("\n3의 배수 합: %d", sum);
		
		System.out.println("\n");
		
		int result = 0;
		int num = 1;
		
		while(true) {
			result += num;
			if (result >= 100) break;
			num++;
		}
		System.out.printf("1에서 %d까지의 합은 %d입니다.", num, result);
		
		int cnt = 1;
		
		while(true) {			
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;
			System.out.printf("(%d,%d)\n", dice1, dice2);
			cnt++;
			if(dice1 + dice2 == 5) break;
			
		}
		System.out.printf("%d번 실행", cnt);
		
		System.out.println("\n");
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d,%d)\t", x, y);
				}
			}
		}
		
		System.out.println("\n");
		
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
		
		for (int i = 1; i < 5; i++) {
			for (int j = 4; j > 0; j--) {
				if (i < j) {
					System.out.print(" ");					
				} else {
					System.out.print("x");
				}
			}
			System.out.println();
		}
		
		int balance = 0;
		
		Money: while (true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");
			int sel = scanner.nextInt();
			
			switch (sel) {
			
			case 1 :
				System.out.print("예금액>");
				balance += scanner.nextInt();
				break;
				
			case 2 :
				System.out.print("출금액>");
				int cul = scanner.nextInt();
				if (cul < balance) {
					balance -= cul;
				} else {
					System.out.printf("잔액이 부족합니다.\n현재 잔액 : %d\n", balance);
				}
				break;
				
			case 3 :
				System.out.print("잔고>");
				System.out.printf("%d\n", balance);
				break;
			
			case 4 :
				break Money;
				
			default :
				System.out.println("없는 번호 입니다.");
				break;
			}
		}
		System.out.println("\n프로그램 종료");
		
		scanner.close();
	}	
	
}
