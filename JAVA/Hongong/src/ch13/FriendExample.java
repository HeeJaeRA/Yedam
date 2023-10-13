package ch13;

import java.util.*;

public class FriendExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		FriendDao dao = new FriendDao();
		List<Friend> list = dao.getFriendList();
		for (Friend friend : list) {
			System.out.printf("\n%s %s %s\n",friend.getName(), friend.getNumber(), friend.getAddress());
		}

	}

}
