package ch7;

public class HankookTire extends Tire {
	
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.printf("%s HankookTire 수명: %d회\n",location, (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.printf("### %s HankookTire 펑크 ###\n", location);
			return false;
		}
		
	}
	
	@Override
	public void roll_tire() {
		// TODO 자동 생성된 메소드 스텁
//		super.roll_tire();
		System.out.println("한국타이어가 굴러갑니다.");
	}
}
