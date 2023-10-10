package ch7;

public class ComputerExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int r = 10;
		
		Calculator cal = new Calculator();
		System.out.println("원 면적: " + cal.areaCircle(r));
		
		System.out.println();
		
		Computer com = new Computer();
		System.out.println("원 면적: " + com.areaCircle(r));
		System.out.print(com.circleR(r));

	}

}
