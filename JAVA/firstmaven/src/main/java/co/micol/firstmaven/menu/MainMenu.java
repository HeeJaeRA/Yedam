package co.micol.firstmaven.menu;

import java.util.Scanner;

import co.micol.firstmaven.service.StudentService;
import co.micol.firstmaven.service.StudentVO;
import co.micol.firstmaven.serviceImpl.StudentServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private StudentManager studentmanager = new StudentManager();
	private StudentService st = new StudentServiceImpl();
	
	private void menuTitle() {
		System.out.println("=============================");
		System.out.println("======== 0. 로 그 인 =========");
		System.out.println("======== 1. 학생 관리 =========");
		System.out.println("======== 2. 성적 관리 =========");
		System.out.println("======== 3. 교원 관리 =========");
		System.out.println("======== 4. 수강 관리 =========");
		System.out.println("======== 5. 종    료 ==========");
		System.out.println("==== 원하는 작업 번호 선택 ======");
	}
	
	private void menu() {
		boolean r = false;		
		do {
			menuTitle();
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
				case 0:
					memberLogin();
					break;
				case 1:
					studentmanager.run();
					break;
				case 2:
					System.out.println("성적 관리");
					break;
				case 3:
					System.out.println("교원 관리");
					break;
				case 4:
					System.out.println("수강 관리");
					break;
				case 5:
					System.out.println("시스템 종료");
					sc.close();
					r = true;
					break;
				default:
					System.out.println("다시 선택");
					break;
			}
		} while(!r);	
	}
	
	private void memberLogin() {
		StudentVO vo = new StudentVO();
		
		System.out.println("학생 아이디> ");
		String id = sc.nextLine();
		vo.setStudentId(id);
		
		System.out.println("학생 비밀번호> ");
		String pw = sc.nextLine();
		vo.setStudentPassword(pw);
		
		vo = st.loginStudent(vo);
		if (vo.getStudentName() != null) {
			System.out.println(vo.getStudentName() + "님 환영");
		} else {
			System.out.println("로그인 실패");
		}
	}

	public void run() {
		menu();
	}
}
