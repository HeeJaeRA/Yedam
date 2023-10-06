package ch6;

public class Bank {
	
	String owner;
	int accountNumber;
	private int balance;
	
	public int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		this.balance = balance;
	}

	Bank(String owner) {
		this.owner = owner;
		this.accountNumber = (int) (Math.random() * 5000) + 10000;
	}
	
	void deposit(int money) {
		this.balance = getBalance();
		this.balance += money;
		setBalance(this.balance);
		System.out.printf("%d원이 입금되었습니다.\n", money);
	}
	
	void withdraw(int money) {
		this.balance = getBalance();
		if (this.balance >= money) {
			this.balance -= money;
			setBalance(this.balance);
			System.out.printf("%d원이 출금되었습니다.\n", money);			
		} else {
			System.out.println("잔액이 부족합니다.");
		}
		
	}
	
	public String toString() {
		return "현재 잔액은 " + getBalance() + "원입니다.\n";
	}
	
	
}
