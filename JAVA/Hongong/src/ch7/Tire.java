package ch7;

public class Tire {
	
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	
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

}
