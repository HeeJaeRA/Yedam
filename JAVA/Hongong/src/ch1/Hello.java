package ch1;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello JAVA");
		
		int num1 = 50;
		int num2 = 77;
		
		int num = 0;
		
		num = num2;
		num2 = num1;
		num1 = num;
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		
		int v1 = 0;
		if (true) {
			int v2 = 0;
			int v3 = 0;
			if (true) {
				v1 = 1;
				v2 = 1;
				v3 = 1;
			}
			v1 = v2 + v3;
		}
		System.out.println(v1);
		
		Scannerex sc = new Scannerex();
		sc.scinput();
		
	}
	

}
