package ch9;

public class AExmaple {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		A a = new A();
		
		System.out.println();
						
		A.B b = new A.B();	
		A.B.field1 = 3;		
		A.B.method1();

		System.out.println();
		
		A.C c = a.new C();
//		A.C c = new A().new C();
		c.field1 = 3;
		c.method1();

		System.out.println();

		a.method();
	}

}
