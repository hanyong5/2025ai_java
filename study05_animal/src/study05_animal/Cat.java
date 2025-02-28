package study05_animal;

public class Cat extends Animal {
	String color;

	public Cat(String name, int age, String color) {
		super(name, age);
		this.color = color;
	}

	@Override
	public void makeSound() {
		System.out.println(name + "가 야옹~ 소리를 냅니다.");
	}
	
	public void scratch() {
		System.out.println(name + "가 할퀴기 공격");
	}

	@Override
	public String toString() {
		return "Cat - 색깔 : " + color + ", " + super.toString();
	}
	
	
	
	




	
	
}
