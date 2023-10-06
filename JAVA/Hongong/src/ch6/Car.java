package ch6;

public class Car {
	
	String color;
	private int gear;
	private int speed;
	
	Car(String color) {
		this.color = color;
	}
	
	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

	void changeGear(int gear) {
		this.gear = gear;
		setGear(gear);
	}
	
	void speedUp() {
		this.speed += 10;
//		setSpeed(this.speed);
	}
	
	void speedDown() {
		if (this.speed > 10) {
			this.speed -= 10;			
		} else {
			this.speed = 0;
		}
//		setSpeed(this.speed);
	}
	
}
