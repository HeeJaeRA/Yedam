package ch13;

import java.util.*;

public class BookDao {
	
	public Set<Book> list_view(){
		Set<Book> set = new HashSet<>();
		
		set.add(new Book("홍길동전", "홍길동", 300));
		set.add(new Book("홍길동전", "홍길동1", 300));
		set.add(new Book("홍길동전1", "홍길동", 300));
		set.add(new Book("홍길동전2", "홍길동", 300));
		set.add(new Book("홍길동전3", "홍길동", 300));		
		
		return set;
	}
}
