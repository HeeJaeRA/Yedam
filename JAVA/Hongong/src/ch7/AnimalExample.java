package ch7;

public class AnimalExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Animal animal = null;
		
		animal = new Dog();
		animal.sound();
		
		animal = new Cat();
		animal.sound();
		
		
		animalSound(new Dog());
		animalSound(new Cat());
		
	}
	
	public static void animalSound(Animal animal) {
		animal.sound();
	}

}
