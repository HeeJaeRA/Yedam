package ch7;

public abstract class HttpServlet {
	public abstract void service();
	
	public void print() {
		System.out.println("실행합니다.");
	}
}
