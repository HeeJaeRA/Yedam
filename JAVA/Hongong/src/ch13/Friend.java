package ch13;

public class Friend {
	private String name;
	private String number;
	private String address;
	
	Friend (String name, String number, String address) {
		this.name = name;
		this.number = number;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public String getAddress() {
		return address;
	}	

}
