package ch6;

public class BoardExample {

	public static void main(String[] args) {
		
		Board board1 = new Board("title", "content");
		Board board2 = new Board("title", "content", "writer");
		Board board3 = new Board("title", "content", "writer", "date");
		Board board4 = new Board("title", "content", "writer", "date", 1);
		
		System.out.println(board1.writer);
		System.out.println(board2.date);
		System.out.println(board3.hitcount);
		System.out.println(board4.hitcount);
		
	}

}
