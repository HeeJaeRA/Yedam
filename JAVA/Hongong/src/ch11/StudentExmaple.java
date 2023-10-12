package ch11;

import java.util.HashMap;

public class StudentExmaple {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		HashMap<Student, String> hashMap = new HashMap<Student, String>();
		
		hashMap.put(new Student("1"), "95");
		
		String score = hashMap.get(new Student("1"));
		System.out.println("1번 학생의 총점: " + score);
	}

}
