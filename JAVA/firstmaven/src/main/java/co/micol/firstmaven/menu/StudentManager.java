package co.micol.firstmaven.menu;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.firstmaven.service.StudentService;
import co.micol.firstmaven.service.StudentVO;
import co.micol.firstmaven.serviceImpl.StudentServiceImpl;

public class StudentManager {
	private Scanner sc = new Scanner(System.in);
	private StudentService st = new StudentServiceImpl();
	
	private void title() {		
//		C생성 R조회 U수정 D삭제 
		System.out.println("========== 학생 관리 ===========");
		System.out.println("======= 1. 학생   조회 ========");
		System.out.println("======= 2. 학생   등록 ========");
		System.out.println("======= 3. 학생   수정 ========");
		System.out.println("======= 4. 학생   삭제 ========");
		System.out.println("======= 5. 학생전체조회 ========");
		System.out.println("======= 6. Main  menu ========");
		System.out.println("==== 원하는 작업 번호 선택 ======");		
	}
	
	private void selectMenu() {
		boolean r = false;
		do {
			title();
			int key = Integer.parseInt(sc.nextLine());
			
			switch (key) {
			case 1:
				selectStudent();
				break;
			case 2:
				insertStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				selectListStudent();
				break;
			case 6:
				r = true;
				break;
			}
			
		} while(!r);		
	}

	public void run() {
		selectMenu();		
	}
	
	private void selectStudent() {
		StudentVO vo = new StudentVO();
		System.out.print("학생 아이디> ");
		String id = sc.nextLine(); sc.nextLine();
		vo.setStudentId(id);
		
		vo = st.selectStudent(vo);
		if (vo.getStudentName() != null) {
			vo.toString();
		} else {
			System.out.println("존재하지 않는 학생입니다.");
		}
	}
	
	private void insertStudent() {
		StudentVO vo = new StudentVO();
		
		System.out.print("학생 아이디> ");
		String id = sc.nextLine(); 
		vo.setStudentId(id);
		
		System.out.print("학생 이름> ");
		String name = sc.nextLine(); 
		vo.setStudentName(name);
		
		System.out.print("학생 비밀번호> ");
		String pw = sc.nextLine(); 
		vo.setStudentPassword(pw);
		
		System.out.print("학생 학과> ");
		String dept = sc.nextLine(); 
		vo.setStudentDept(dept);
		
		System.out.print("학생 생년월일> ");
		String day = sc.nextLine();
		java.sql.Date d = java.sql.Date.valueOf(day);
		vo.setStudentBirthday(d);
		
		int n = st.insertStudent(vo);
		if (n != 0) {
			System.out.println("정상적으로 등록되었습니다.");
		} else {
			System.out.println("등록 실패");
		}
		
	}
	
	private void updateStudent() {
		StudentVO vo = new StudentVO();
		
		System.out.print("학생 아이디> ");
		String id = sc.nextLine(); 
		vo.setStudentId(id);
		
		System.out.print("학생 이름> ");
		String name = sc.nextLine(); 
		vo.setStudentName(name);
		
		System.out.print("학생 비밀번호> ");
		String pw = sc.nextLine(); 
		vo.setStudentPassword(pw);
		
		System.out.print("학생 학과> ");
		String dept = sc.nextLine(); 
		vo.setStudentDept(dept);
		
		System.out.print("학생 생년월일> ");
		String day = sc.nextLine();
		java.sql.Date d = java.sql.Date.valueOf(day);
		vo.setStudentBirthday(d);
		
		st.updateStudent(vo);
	}
	
	
	private void deleteStudent() {
		StudentVO vo = new StudentVO();
		
		System.out.print("학생 아이디> ");
		String id = sc.nextLine(); 
		vo.setStudentId(id);
		
		st.deleteStudent(vo);
	}
	
	private void selectListStudent() {
    	List<StudentVO> students = new ArrayList<>();
    	
    	students = st.selectListStudent();
    	for (StudentVO student : students) {
    		student.toString();
    	}
	}
	

}
