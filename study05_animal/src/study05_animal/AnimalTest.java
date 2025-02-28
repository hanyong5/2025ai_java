package study05_animal;

public class AnimalTest {

	public static void main(String[] args) {
//		String[] name = new String[] {"홍길동"};
//		String[] name = new String[2];
//		String[] name = {};

		Animal[] animals = new Animal[2];
		animals[0] = new Dog("바둑이",3,"진돗개");
		animals[1] = new Cat("나비",4,"검은색");
		
//		Animal dog = new Dog("바둑이",3,"진돗개");
//		Animal cat = new Cat("나비",4,"검은색");
		
		
		
		for(Animal animal:animals) {
			System.out.println(animal);
			animal.eat();
			animal.makeSound();
			animal.sleep();
			System.out.println("-------------");
			
		}
		
		Dog myDog = (Dog)animals[0];
		myDog.tail();
		
		Cat myCat = (Cat)animals[1];
		myCat.scratch();
		
		
		
		
	}

}
