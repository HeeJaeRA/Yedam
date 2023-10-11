package ch9;

public class A {
	
	A() {
		System.out.println("A 객체 생성");
	}
	
	static class B {
		B() {
			System.out.println("B 객체 생성");
		}
		static int field1;
		static void method1() { 
			System.out.println("B 메소드 실행");
		}
	}
	
	class C {
		C() {
			System.out.println("C 객체 생성");
		}
		int field1;
		void method1() { 
			System.out.println("C 메소드 실행");
		}
	}
	
	void method() {
		System.out.println("A 메소드 실행");
		class D {
			D() {
				System.out.println("D 객체 생성");
			}
			int field1;
			void method1() {
				System.out.println("D 메소드 실행");
			}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}

}
