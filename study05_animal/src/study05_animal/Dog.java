package study05_animal;

public class Dog extends Animal {
	String breed;

	public Dog(String name, int age, String breed) {
		super(name, age);
		this.breed = breed;
	}

	@Override
	public void makeSound() {
		System.out.println(name + "가 멍멍 짓습니다.");
	}
	
	public void tail() {
		System.out.println(name + "가 꼬리를 흔듭니다.");
	}

	@Override
	public String toString() {
		return "Dog - 견종 : " + breed + ", " + super.toString();
	}
	
	
	
	




	
	
}
