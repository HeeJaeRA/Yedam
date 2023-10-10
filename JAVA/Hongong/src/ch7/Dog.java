package ch7;

public class Dog extends Animal {
	
	public Dog() {
		this.kind = "포유류";
	}
	
	@Override
	public void sound() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("멍멍");
	}

}
