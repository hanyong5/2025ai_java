package study05_interface;

public class AnimalTest {

	public static void main(String[] args) {
		Animal myDog = new Dog("코코", 3, "말티즈");
		Animal myCat = new Cat("야옹이",10,"블루");
		
		myDog.showInfo();
		myDog.makeSound();
		myDog.eat();
		
		Dog dog = (Dog)myDog;
		dog.wagTail();
		
		System.out.println("-----------------");
		
		myCat.showInfo();
		myCat.makeSound();
		myCat.eat();
	
		System.out.println("-----------------");
		
		
		Dog youDog = new Dog("해피",4,"불독");
		youDog.showInfo();
		youDog.makeSound();
		youDog.wagTail();
		
	}

}
