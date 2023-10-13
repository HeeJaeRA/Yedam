package ch13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BookExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		BookDao dao = new BookDao();
		
		Set<Book> set = dao.list_view();
		
		Iterator<Book> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Book book = iterator.next();
			System.out.printf("%s\t\t%s\t\t%d\n", book.getName(), book.getAuthor(), book.getPage());
		}

	}

}
