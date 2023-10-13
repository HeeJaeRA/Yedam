package ch13;

public class Board {
	
	private String title;
	private String content;
	String writer;
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}	
	
	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public String getTitle() { return title; }
	public String getContent() { return content; }

}
