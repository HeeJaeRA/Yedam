package ch10;

public class TryCatchExample {

	public static void main(String[] args) {
		
		try {
//			Class clazz = Class.forName("java.lang.String2");
			method1();
		} catch (ClassNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			System.out.println("클래스가 존재하지 않음");
		}
		
	}
	
	public static void method1() throws ClassNotFoundException{
		Class clazz2 = Class.forName("java.lang.String3");		
	}

}
