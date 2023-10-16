package ch13;

import java.util.*;

public class ProductStorage {
	
	private List<Product> list = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private int cnt;
	
	public void showMenu() {
		while(true) {
			System.out.println("------------------------------");
			System.out.println("1. 등록  |  2. 목록  |  3. 종료");
			System.out.println("------------------------------");
			
			System.out.print("선택> ");
			int selnum = Integer.parseInt(sc.nextLine());
			
			switch(selnum) {
			case 1: registerProduct(); break;
			case 2: showProducts(); break;
			case 3: System.out.println("종료"); return;
			default : System.out.println("다시 입력"); break;
			}
		}
	}
	
	public void registerProduct() {
		try {
			Product product = new Product();
			product.setPno(++cnt);
			
			System.out.print("상품명> ");
			product.setName(sc.nextLine());
			
			System.out.print("가격> ");
			product.setPrice(Integer.parseInt(sc.nextLine()));
			
			System.out.print("재고> ");
			product.setStock(Integer.parseInt(sc.nextLine()));
			
			list.add(product);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void showProducts() {
		for (Product p : list) {
			System.out.println(p.getPno() + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getStock());
		}
	}


}
