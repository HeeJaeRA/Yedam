package ch3;

import java.util.Scanner;

public class Exam127p {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
		
		int var1 = 5;
		int var2 = 2;
		double var3 = (double) var1 / var2;
		int var4 = (int) (var3 * var2);
		System.out.println(var4);
		
		int value = 356;
		System.out.println(value / 100 * 100);
		
		float v1 = 10f;
		float v2 = v1 / 100;
		if (v2 == 0.1f) {
			System.out.println("10%입니다.");
		} else {
			System.out.println("10%가 아닙니다.");
		}
		
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) / 2 * height;
		System.out.println(area);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n첫 번째 수: ");
		float num1 = Float.parseFloat(scanner.next());
		System.out.print("두 번째 수: ");
		float num2 = Float.parseFloat(scanner.next());
		
		if (num2 == 0 || num2 == 0.0) {
			System.out.println("결과: 무한대");
		} else {
			System.out.printf("결과: %.3f", num1 / num2);
		}
		
		int va1 = 10;
		int va2 = 3;
		int va3 = 14;
		double va4 = va1 * va1 * Double.parseDouble(va2 + "." + va3);
		System.out.println("\n\n원의 넓이 : " + va4);
		
		System.out.print("\n아이디: ");
		String name = scanner.next();
		
		System.out.print("패스워드: ");
		String strPassword = scanner.next();
		int password = Integer.parseInt(strPassword);
		
		if (name.equals("java")) {
			if (password == 12345) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패: 패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패: 아이디가 존재하지 않음");
		}

		scanner.close();
	}

}
