package test;

import java.util.*;

public class BookData {
	
	private List<Book> list = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private boolean run = true;
	
	private int b_number = 0;
	private String b_name = null;
	private int b_price = 0;
	
	int sel_num = 0;
	
	int b_num = 0;
	
	int max_price = 0;
	int min_price = 0;
	int sum = 0;
	
	public List<Book> book_list() {
		
		list = new ArrayList<>();
		Book book = new Book(b_number, b_name, b_price);
		
		for (int i = 1; i <= b_num; i++) {
			System.out.printf("%d 번째 도서 정보 입력\n", i);
			
			System.out.print("도서번호 > ");
			b_number = Integer.parseInt(sc.nextLine());
			book.setB_num(b_number);
			
			System.out.print("도서제목 > ");
			b_name = sc.nextLine();
			book.setB_name(b_name);	
			
			System.out.print("도서가격 > ");
			b_price = Integer.parseInt(sc.nextLine());
			book.setB_price(b_price);
			
			list.add(new Book(b_number, b_name, b_price));
		}
		return list;
		
	}
	
	public void book_data() {
		
		while(run) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("1.도서수 입력 2.도서정보 등록 3.도서정보 전체조회 4.도서정보 분석 5.종료");
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택 > ");
			sel_num = Integer.parseInt(sc.nextLine());
			
			switch (sel_num) {
			case 1:
				System.out.print("도서 수> ");
				b_num = Integer.parseInt(sc.nextLine());
				break;
				
			case 2:
				book_list();
				break;
				
			case 3:
//				for (Book b : list) {
//					System.out.printf("도서번호 : %d 가격 : %d\n", b.getB_num(), b.getB_price());
//				}
				
				for (int i = 0; i < list.size(); i++) {
					Book blist = list.get(i);
					System.out.printf("도서번호 : %d 가격 : %d\n", blist.getB_num(), blist.getB_price());
					
				}
				
				break;
				
			case 4:
				for (int i = 0; i < list.size(); i++) {
					Book booklist = list.get(i);
					
					max_price = list.get(0).getB_price();
					min_price = list.get(0).getB_price();
					
					if (booklist.getB_price() > max_price) {
						max_price = booklist.getB_price();
					} 
					if (booklist.getB_price() < min_price) {
						min_price = booklist.getB_price();
					}
					sum += booklist.getB_price();
				}
				System.out.printf("최고 가격 : %d원 ", max_price);
				System.out.printf("최저 가격 : %d원 ", min_price);
				System.out.printf("평균 가격 : %.2f원 입니다.\n", (double) sum / list.size());
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
	
	}
	

}
