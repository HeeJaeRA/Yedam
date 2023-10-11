package ch7;

public class KumhoTire extends Tire {
	
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.printf("%s KumhoTire 수명: %d회\n",location, (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.printf("### %s KumhoTire 펑크 ###\n", location);
			return false;
		}
	
	}
	
	@Override
	public void roll_tire() {
		// TODO 자동 생성된 메소드 스텁
//		super.roll_tire();
		System.out.println("금호타이어가 굴러갑니다.");
	}

}
