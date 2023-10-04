package ch5;

import java.util.Scanner;

public class Exam200p {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
//		boolean run = true;
//		int studentNum = 0;
//		int[] scores = null;
//		int max = 0, scoresSum = 0;
//		Scanner scanner = new Scanner(System.in);
//		
//		while(run) {
//			System.out.println("-------------------------------------------------");
//			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
//			System.out.println("-------------------------------------------------");
//			System.out.print("선택> ");
//			
//			int selectNo = scanner.nextInt();
//			
//			switch (selectNo) {
//			
//			case 1:
//				System.out.print("학생수> ");
//				studentNum = scanner.nextInt();
//				scores = new int[studentNum];
//				break;
//				
//			case 2:
//				for (int i = 0; i < studentNum; i++) {
//					System.out.printf("score[%d]> ", i);
//					scores[i] = scanner.nextInt();
//				}
//				break;
//				
//			case 3:
//				for (int i = 0; i < scores.length; i++) {
//					System.out.printf("scores[%d]> %d\n", i, scores[i]);
//				}
//				break;
//				
//			case 4:
//				String grade = "";
//				for (int i = 0; i < scores.length; i++) {
//					
//					scoresSum += scores[i];
//					
//					if (scores[i] > max) {
//						max = scores[i];
//					}
//					
//					switch ((int) scores[i] / 10) {
//					case 10 :
//					case 9 : grade = "A"; break;
//					case 8 : grade = "B"; break;
//					case 7 : grade = "C"; break;
//					case 6 : grade = "D"; break;
//					default : grade = "F";
//					}
//					System.out.printf("%d번 학생의 등급: %s (%d점)\n", i+1, grade, scores[i]);
//				}
//				
//				double avg = (double) scoresSum / studentNum;		
//				
//				System.out.printf("최고 점수: %d\n", max);
//				System.out.printf("평균 점수: %f\n", avg);
//				break;
//				
//			case 5:
//				run = false;
//			}
//		}
//
//		System.out.println("프로그램 종료");
		
		String[] card1 = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] card2 = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		for (int i = 0; i < 5; i++) {
			int ranNum1 = (int) (Math.random() * card1.length);
			int ranNum2 = (int) (Math.random() * card2.length);
			System.out.printf("%s의 %s\n", card1[ranNum1], card2[ranNum2]);
		}
		
//		scanner.close();
		
	}

}
