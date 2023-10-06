package ch6;

public class BankExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Bank h1 = new Bank("홍길동");
		
		System.out.printf("예금주: %s, 계좌번호: %d\n", h1.owner, h1.accountNumber);
		h1.deposit(10000);
		h1.deposit(20000);
		h1.withdraw(7000);
		System.out.println(h1.toString());		
	}

}
