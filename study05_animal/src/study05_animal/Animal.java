package study05_animal;

public abstract class Animal {
	String name;
	int age;
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 공통메소드
	public void eat() {
		System.out.println(name + "가 먹이를 먹습니다.");
	}
	public void sleep() {
		System.out.println(name + "가 잠을 잡니다.");
	}
	
	// 추상메소드
	public abstract void makeSound();

	@Override
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age;
	}
	
	
	
}
