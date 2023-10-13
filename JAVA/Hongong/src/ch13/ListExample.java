package ch13;

import java.util.*;

public class ListExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for (Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}

	}

}
