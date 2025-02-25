package study05;

public class Animal {
	int age;
	public void eat() {
		System.out.println("먹고 있음...");
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + "]";
	};
	
	
}
