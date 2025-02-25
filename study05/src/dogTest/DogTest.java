package dogTest;

public class DogTest {

	public static void main(String[] args) {
		Dog myDog = new Dog("바둑이", 3);
		myDog.showInfo();
		myDog.makeSound();

		Dog dog = new Dog("코코", 5);

		System.out.println(dog.toString());
		dog.makeSound();

		Dog dog1 = new Dog("보리", 6);

		System.out.println(dog1.toString());
		dog1.makeSound();
	}

}
