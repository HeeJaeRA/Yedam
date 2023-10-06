package ch7;

public class HttpServletExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		method(new LoginServlet());
		method(new FileDownloadServlet());
	}

	public static void method(HttpServlet servlet) {
		servlet.service();
	}

}
