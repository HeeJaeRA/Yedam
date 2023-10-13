package ch13;

import java.util.*;

public class HashSetExample {

	public static void main(String[] args) {
		
//		Set<String> set = new HashSet<String>();
//		
//		set.add("Java");
//		set.add("JDBC");
//		set.add("Servlet/JSP");
//		set.add("Java");
//		set.add("iBATIS");
//		
//		int size = set.size();
//		System.out.println("총 객체수: " + size);
//		
//		Iterator<String> iterator = set.iterator();
//		
//		while(iterator.hasNext()) {
//			String element = iterator.next();
//			System.out.println("\t" + element);
//		}
//		
//		set.remove("JDBC");
//		set.remove("iBATIS");
//
//		System.out.println("총 객체수: " + set.size());
//		
//		iterator = set.iterator();
//		for (String element : set) {
//			System.out.println("\t" + element);
//		}
//		
//		set.clear();
//		
//		if(set.isEmpty()) { System.out.println("비어있음"); }
//		
//		Set<Member> set_1 = new HashSet<>();
//		
//		set_1.add(new Member("홍길동", 10));
//		set_1.add(new Member("길동홍", 60));
//		set_1.add(new Member("동홍길", 5));
//		
//		System.out.println("총 객체수: " + set_1.size());
//		
//		Iterator<Member> iterator_1 = set_1.iterator();
//		
//		while(iterator_1.hasNext()) {
//			Member member = iterator_1.next();
//			System.out.println(member.name + " " + member.age);
//		}
		
		Set<Student> set_2 = new HashSet<>();
		
		set_2.add(new Student(1, "홍길동"));
		set_2.add(new Student(2, "신용권"));
		set_2.add(new Student(1, "조민우"));
		
		Iterator<Student> iterator_2 = set_2.iterator();
		
		while(iterator_2.hasNext()) {
			Student student = iterator_2.next();
			System.out.println(student.studentNum + " " + student.name);
		}
	}

}
