package ch9;

public class Anonymous {
		
	Worker field = new Worker() {
		public void start() {
			System.out.println("디자인을 합니다.");
		}
	};
	
	void method1() {
		Worker localVar = new Worker() {		
			public void start() {
				System.out.println("개발을 합니다.");
			}
		};
		localVar.start();
	}
	
	
	void method2(Worker worker) {
		worker.start();
	}
	
	Vehicle field1 = new Vehicle() {
		@Override
		public void run() {
			// TODO 자동 생성된 메소드 스텁
			System.out.println("자전거가 달립니다.");
			
		}
	};
	
	void method_1() {
		Vehicle localVar = new Vehicle() {
			@Override
			public void run() {
				// TODO 자동 생성된 메소드 스텁
				System.out.println("승용차가 달립니다.");	
			}
		};
		localVar.run();
	}
	
	void method_2(Vehicle vehicle) {
		vehicle.run();
	}

}
