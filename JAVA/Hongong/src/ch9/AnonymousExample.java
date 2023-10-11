package ch9;

public class AnonymousExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		Anonymous anony = new Anonymous();
		anony.field1.start();
		anony.method1();
		
		anony.method2(
				new Worker() {
					public void start() {
						System.out.println("테스트를 합니다.");
					}					
				}		
		);
		
		System.out.println();
		
		Anonymous anony_1 = new Anonymous();
		anony_1.field.run();
		anony_1.method_1();
		anony_1.method_2(
				new Vehicle() {
					@Override
					public void run() {
						// TODO 자동 생성된 메소드 스텁
						System.out.println("트럭이 달립니다.");
					}
				}
		);

	}

}
