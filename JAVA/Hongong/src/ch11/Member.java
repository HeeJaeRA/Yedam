package ch11;

public class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO 자동 생성된 메소드 스텁
//		return super.toString();
		return id + ": " + name;
	}

}
