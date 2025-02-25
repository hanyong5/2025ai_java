package animalTest;

public class AnimalTest {

	public static void main(String[] args) {
		Dog dog = new Dog("코코",5,"말티즈");
		
		
		dog.showInfo();
		dog.makeSound();
		dog.waveTail();
		System.out.println();
		
		Cat cat = new Cat("나비",3,"블루");
		
		cat.showInfo();
		cat.makeSound();
		cat.scratch();
		
	}

}
