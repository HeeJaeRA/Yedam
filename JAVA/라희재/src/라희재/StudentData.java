package 라희재;

import java.util.*;

public class StudentData {
	
	List<Student> list = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);

	int snum = 0;
	String sname = null;
	int sscore = 0;
	
	public List<Student> list_add(int s_number) {
		List<Student> list = new ArrayList<>();
		
		for (int i = 1; i <= s_number; i++) {
			System.out.printf("%d 번째 학생 정보 입력\n", i);
			
			System.out.print("학번 > ");
			snum = Integer.parseInt(sc.nextLine());
			
			System.out.print("이름 > ");
			sname = sc.nextLine();
			
			System.out.print("점수 > ");
			sscore = Integer.parseInt(sc.nextLine());
			
			list.add(new Student(snum, sname, sscore));
		}

		return list;
	}
	

}
