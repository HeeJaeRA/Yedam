package 라희재;

import java.util.*;


public class StudentMain {
	
	public static void main(String[] args) {
	
		List<Student> list = new ArrayList<>();
		
		boolean run = true;
		
		Scanner sc = new Scanner(System.in);
		int max_score = 0;
		int min_score = 0;
		int sum = 0;
		
		int selnum = 0; //switch문 번호
		int s_number = 0; //학생수
		
		StudentData sd = new StudentData();
		
		while(run) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("1.학생 수 입력 2.학생정보 등록 3.학생정보 전체조회 4.학생정보 분석 5.종료");
			System.out.println("----------------------------------------------------------------");
			
			System.out.print("선택 > ");
			selnum = Integer.parseInt(sc.nextLine());
			
			switch (selnum) {
			
			case 1:
				System.out.print("학생수 > ");
				s_number = Integer.parseInt(sc.nextLine());
				break;
				
			case 2:
				
				list = sd.list_add(s_number);
				break;
				
			case 3:				
				for (int i = 0; i < list.size(); i++) {
					Student slist = list.get(i);
					System.out.printf("%d 학번 점수 : %d점\n", slist.getS_num(), slist.getS_score());
				}
				break;
				
			case 4:
				for (int i = 0; i < list.size(); i++) {
					Student slist = list.get(i);
					
					max_score = list.get(0).getS_score();
					min_score = list.get(0).getS_score();
					
					if (slist.getS_score() > max_score) {
						max_score = slist.getS_score();
					} 
					if (slist.getS_score() < min_score) {
						min_score = slist.getS_score();
					}
					sum += slist.getS_score();
				}
				System.out.printf("최고 점수 : %d점\n", max_score);
				System.out.printf("최저 점수 : %d점\n", min_score);
				System.out.printf("평균 점수 : %.2f점 입니다.\n", (double) sum / list.size());
				break;
				
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
				
			default:
				System.out.println("다시 입력");
				break;
			}
			
		}
		sc.close();
		
	}
}
