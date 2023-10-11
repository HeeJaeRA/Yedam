package ch8;

public class SoundableExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		printSound(new Cat());
		printSound(new Dog());		
		
	}
	
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
}
