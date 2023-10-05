package ch6;

public class Tvexam {
	
	public static void main (String[] args) {
		
		Tv tv1 = new Tv(7, 10, true);
		Tv tv2 = new Tv(3, 12, true);
		Tv tv3 = new Tv(1, 1, false);
		
		tv1.print();
		tv2.print();
		tv3.print();
	}

}
