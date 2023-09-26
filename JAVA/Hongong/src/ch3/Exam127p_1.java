package ch3;

import java.util.Scanner;

public class Exam127p_1 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Scanner scanner = new Scanner(System.in);		
			
//		while(true) {
//			System.out.println("가위바위보 (over 입력 시 종료)");
//			String gababo = scanner.next();
//			
//			if (gababo.equals("over")) {
//				System.out.println("게임 종료");
//				break;
//			} else {
//				if(gababo.equals("가위")) {
//					System.out.println("바위를 내면 이길 수 있음");
//				}
//				else if(gababo.equals("바위")) {
//					System.out.println("보를 내면 이길 수 있음");
//				}
//				else if(gababo.equals("보")) {
//					System.out.println("가위를 내면 이길 수 있음");
//				}				
//			}
//		}
		
		Lable: while(true) {
			System.out.println("가위바위보 (over 입력 시 종료)");
			String gababo = scanner.next();
			
			switch (gababo) {
			case "over" :
				System.out.println("게임 종료");
				break Lable;
			
			case "가위" :
				System.out.println("바위를 내면 이길 수 있음");
				break;
			
			case "바위" :
				System.out.println("보를 내면 이길 수 있음");
				break;
				
			case "보" :
				System.out.println("가위를 내면 이길 수 있음");
				break;
			
			default :
				System.out.println("가위, 바위, 보 만 입력하세요");
				break;
			}
		}
		scanner.close();
	}

}
