package animalTest;

public class Dog extends Animal{
	String breed;
	
	

	public Dog(String name, int age, String breed) {
		super(name, age);
		this.breed = breed;
	}


	public void waveTail() {
		System.out.println(name + "가 꼬리를 흔듬!!!");
	}

	@Override
	public void makeSound() {
		System.out.println(name + "가 멍멍!! 멍멍!!");
	}

	

	
}
