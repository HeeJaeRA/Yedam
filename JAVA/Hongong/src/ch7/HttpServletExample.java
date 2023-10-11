package ch7;

public class HttpServletExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		method(new LoginServlet());
		method(new FileDownloadServlet());
		
//		LoginServlet a = new LoginServlet();
//		FileDownloadServlet b = new FileDownloadServlet();
//		
//		a.print();
//		a.service();
//		
//		b.print();
//		b.service();
		
	}

	public static void method(HttpServlet servlet) {
		servlet.service();
	}

}
