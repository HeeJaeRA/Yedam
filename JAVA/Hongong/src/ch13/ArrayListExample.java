package ch13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		List<String> list = new ArrayList<>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		System.out.println("총 객체 수: " + list.size());
		
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}
		
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove(2);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}

	}

}
