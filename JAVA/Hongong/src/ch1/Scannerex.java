package ch1;

import java.util.Scanner;

public class Scannerex {
	
	Scanner sc = new Scanner(System.in);
	String inputdata;
		
	public void scinput() {		
		while(true) {
			System.out.print("문자열 입력 (종료하려면 q) : ");
			
			inputdata = sc.nextLine();
			
			System.out.println(inputdata);
			
			if (inputdata.equals("q")) {
				break;
			}
		}
		System.out.println("종료");
	}
	

}
