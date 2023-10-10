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
}
