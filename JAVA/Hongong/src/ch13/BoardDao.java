package ch13;

import java.util.*;

public class BoardDao {

	public List<Board> getBoardList() {
		// TODO 자동 생성된 메소드 스텁
		List<Board> list = new ArrayList<>();
		
		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));
		
		return list;
	}

}