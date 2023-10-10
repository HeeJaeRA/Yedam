package ch7;

public class DriverExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
		

	}

}
