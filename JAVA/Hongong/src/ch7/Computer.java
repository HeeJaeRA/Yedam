package ch7;

public class Computer extends Calculator {
	
	@Override
	double areaCircle(double r) {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("Com");
		return Math.PI * r * r;
	}
	
	double circleR(double r) {
		return super.circleR(r);
	}
	
}
