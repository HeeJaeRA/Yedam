package ch6;

import java.util.Scanner;

public class CarExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Car car = new Car("red");
		
//		System.out.printf("car color = %s, speed = %d, gear = %d\n", car.color, car.getSpeed(), car.getGear());
//		
//		car.speedUp();
//		
//		car.changeGear(1);
//		
//		System.out.printf("car color = %s, speed = %d, gear = %d\n", car.color, car.getSpeed(), car.getGear());
		
		Scanner uNum = new Scanner(System.in);

		int cnt = 0;
		
		System.out.print("드라이브 횟수: ");
		int maxNum = uNum.nextInt();
		
		Drive: while (true) {
			
			cnt++;
						
			car.speedUp();
			
			if (car.getSpeed() >= 100) {
				car.changeGear(5);
			} else {
				car.changeGear(0);
			}
			if (car.getSpeed() == 100) System.out.println("변속합니다.");
			
			System.out.printf("car color = %s, speed = %d, gear = %d, %d\n", car.color, car.getSpeed(), car.getGear(), cnt);
			
			
			if (car.getSpeed() > 110) {
//				System.out.println("감속합니다.");
				
				while (true) {
					
					cnt++;
										
					car.speedDown();
					
					if (car.getSpeed() >= 100) {
						car.changeGear(5);
					} else {
						car.changeGear(0);
					}
										
					System.out.printf("car color = %s, speed = %d, gear = %d, %d\n", car.color, car.getSpeed(), car.getGear(), cnt);
					
					if (car.getSpeed() == 100) System.out.println("변속합니다.");
					
					
					if (car.getSpeed() < 40) break;

					if (cnt == maxNum) break Drive;
					
				}
//				System.out.println("가속합니다.");
				
			}

			if (cnt == maxNum) break;
			
		}
		
		
	}

}
