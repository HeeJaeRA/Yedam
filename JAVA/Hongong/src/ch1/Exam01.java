package ch1;

public class Exam01 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		char c1 = 'a';
		int c2 = c1 + 1;
		System.out.println(c2);
		
		int x = 5;
		int y = 2;
		long result = x / y;
		System.out.println(result);
		
		double result1 = (double) x / y;
		System.out.println(result1);
		
		double var1 = 3.5;
		double var2 = 2.7;
		int result2 = (int) (var1 + var2);
		System.out.println(result2);
		
		long v1 = 2l;
		float v2 = 1.8f;
		double v3 = 2.5;
		String v4 = "3.9";		
		int result3 = (int) (v1 + v2 + v3 + (int) Float.parseFloat(v4));
		System.out.println(result3);
		
		byte value1 = Byte.parseByte("10");
		int value2 = Integer.parseInt("1000");
		float value3 = Float.parseFloat("20.5");
		double value4 = Double.parseDouble("3.14159");
		
		System.out.printf("v1 : %d\nv2 : %d\nv3 : %2.1f\nv4 : %1.5f\n", value1, value2, value3, value4);
	}

}
