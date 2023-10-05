package ch6;

public class Lamp {
	
	boolean isOn;

	void turnOn() {
		isOn = true;
	}
	
	void turnOff() {
		isOn = false;
	}
	
	void state() {
		if (isOn) {
			System.out.println("현재 상태 켜짐");
		} else {
			System.out.println("현재 상태 꺼짐");
		}
		
	}
 }
