package ch7;

public class Parent {
	
	public String nation;
	
	public Parent() {
		this("대한민국");
		System.out.println("Parent() call");
	}

	public Parent(String nation) {
		// TODO 자동 생성된 생성자 스텁
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}

}
