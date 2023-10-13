package ch13;

public class Book {
	private String name;
	private String author;
	private int page;
	
	Book (String name, String author, int page) {
		this.name = name;
		this.author = author;
		this.page = page;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book book = (Book) obj;
			return book.name.equals(name);
 		} else {
 			return false;
 		}		
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
