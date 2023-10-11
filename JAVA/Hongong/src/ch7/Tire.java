package ch7;

public class Tire implements CarTire{
	
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.printf("%s Tire 수명: %d회\n", location, (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.printf("### %s Tire 펑크 ###\n", location);
			return false;
		}
	}
	
	@Override
	public void roll_tire() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("타이어가 굴러갑니다");
		
	}

}
