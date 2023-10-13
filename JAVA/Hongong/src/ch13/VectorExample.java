package ch13;

import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%s %s %s\n", list.get(i).getTitle(), list.get(i).getContent(), list.get(i).writer);
		}
		
		System.out.println();
		
		list.remove(2);
		list.remove(3);
		
		for (Board board : list) {
			System.out.printf("%s %s %s\n", board.getTitle(), board.getContent(), board.writer);			
		}
		
	}

}
