package ch11;

public class Smartphone {
	
	private String company;
	private String os;
	
	public Smartphone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() {
		// TODO 자동 생성된 메소드 스텁
		return company + ", " + os;
	}

}
