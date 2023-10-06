package ch7;

public class Child extends Parent{
	
	private String name;
	
	public Child() {
		this("홍길동");
		System.out.println("Child() call");
	}

	public Child(String name) {
		// TODO 자동 생성된 생성자 스텁
		this.name = name;
		System.out.println("Child(String name) call");
	}
	
}
