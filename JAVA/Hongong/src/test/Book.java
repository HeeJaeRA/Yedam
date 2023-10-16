package test;

public class Book {
	
	private int b_num;
	private String b_name;
	private int b_price;
	
	Book(int b_num, String b_name, int b_price) {
		this.b_num = b_num;
		this.b_name = b_name;
		this.b_price = b_price;
	}
	
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

}
