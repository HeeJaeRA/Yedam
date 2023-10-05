package ch6;

public class MemberExample {

	public static void main(String[] args) {
		
		Member member = new Member();

		member.name = "최하얀";
		member.age = 23;
		
		System.out.println(member.name);
		System.out.println(member.age);
				
		Member user1 = new Member("홍길동", "hong");
		
		System.out.println(user1.name);
		System.out.println(user1.id);
		
	}

}
