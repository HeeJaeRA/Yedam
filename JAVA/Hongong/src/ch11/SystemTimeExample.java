package ch11;

import java.io.IOException;
import java.util.Scanner;

public class SystemTimeExample {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		long start_time = System.nanoTime();
		
		int sum = 0;
		for (int i = 1; i <= 1000000; i++) {
			sum += i;
		}
		
		long end_time = System.nanoTime();
		
		double sec = ((double) end_time - (double) start_time) / 100000000;
		
		System.out.println("1부터 1000000까지의 합: " + sum);
		System.out.println("걸린 시간: " + (end_time - start_time) + "나노초");
		System.out.println("걸린 시간: " + sec + "초");
		
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		byte[] bytes2 = { 73, 32, 108, 111, 118, 101, 32, 121, 111, 117 };
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes2);
		System.out.println(str2);
		
		byte[] bytes3 = new byte[100];
		
		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes3);
		
		for (int i = 0; i < readByteNo-2; i++) {
			System.out.printf("%d ", bytes3[i]);
		}
		System.out.println();
		
		String str3 = new String(bytes3, 0, readByteNo-2);
		System.out.println(str3);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("주민번호 입력(- 포함): ");
		String ssn = scanner.next();
		
		char sex = ssn.charAt(7);
		
		switch (sex) {
		
		case 1:
		case 3:
			System.out.println("남자");
			break;
			
		case 2:
		case 4:
			System.out.println("여자");
			break;
			
		default:
			System.out.println("사람 아님");
		}
		
		scanner.close();

	}

}
