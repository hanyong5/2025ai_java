package study05_interface;

public class Cat implements Animal {
	private String name;
	private int age;
	private String color;
	

	public Cat(String name, int age, String color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public void makeSound() {
		System.out.println(name + "가 야옹...");
	}

	@Override
	public void eat() {
		System.out.println(name + "가 생선를 먹습니다...");
	}

	@Override
	public void showInfo() {
		System.out.println("고양이정보 - 이름 : " + name + ", 나이 : " + age);
		System.out.println("다리 : " + LEGS + "개, 꼬리 : " + TAILS +"개");
	}
	
	public void scratch() {
		System.out.println(name + "가 할퀴기 공격");
	}

}
