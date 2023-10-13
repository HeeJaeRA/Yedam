package ch13;

import java.util.*;

public class FriendDao {

	public List<Friend> getFriendList() {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		
		List<Friend> list = new ArrayList<>();
		
		System.out.print("이름: ");
		String i_name = sc.nextLine();
		
		System.out.print("전화번호(- 포함): ");
		String i_number = sc.nextLine();
		
		System.out.print("주소: ");
		String i_address = sc.nextLine();
		
		
		list.add(new Friend(i_name, i_number, i_address));
		
		sc.close();
		
		return list;
	}

}
