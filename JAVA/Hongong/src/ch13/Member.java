package ch13;

public class Member {
	
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO 자동 생성된 메소드 스텁
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age) ;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// TODO 자동 생성된 메소드 스텁
		return name.hashCode() + age;
	}
	

}
