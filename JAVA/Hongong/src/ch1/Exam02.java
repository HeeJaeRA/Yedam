package ch1;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %s-%s-%s", tel1, tel2, tel3);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n첫번째 수:");
		String strNum1 = scanner.next();

		System.out.print("두번째 수:");
		String strNum2 = scanner.next();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		
		System.out.println("덧셈 결과:" + result);
		
	
		System.out.print("\n[필수 정보 입력]\n1. 이름: ");
		String strname = scanner.next();
		
		System.out.print("2. 주민번호 앞 6자리: ");
		String strnum = scanner.next();
		
		System.out.print("3. 전화번호(- 포함 입력): ");
		String strphone = scanner.next();
		
		System.out.printf("\n[입력한 내용]\n%s\n%s\n%s", strname, strnum, strphone);
		
		scanner.close();
	
	}

}
