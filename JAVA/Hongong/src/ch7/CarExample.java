package ch7;

public class CarExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Car car = new Car();
		
		for (int i = 1; i <= 10; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			
			case 1:
				System.out.println("앞 왼쪽 HankookTire로 교체");
				car.frontLeftTire = new HankookTire("앞 왼쪽 ", 11);
				break;
			case 2:
				System.out.println("앞 오른쪽 KumhoTire로 교체");
				car.frontRightTire = new KumhoTire("앞 오른쪽", 15);
				break;
			case 3:
				System.out.println("뒤 왼쪽 HankookTire로 교체");
				car.backLeftTire = new HankookTire("뒤 왼쪽 ", 17);
				break;
			case 4:
				System.out.println("앞 왼쪽 HankookTire로 교체");
				car.backRightTire = new KumhoTire("뒤 오른쪽", 20);
				break;
			}
			System.out.println("--------------------------");
		}

	}

}
