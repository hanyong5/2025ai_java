package study03;

public class Circle {
	int radius; //필드(멤버변수)
	String color;
	
	public double getArea() {
		return 3.14 * radius * radius;
	}
	
	
	public String toString() {
		return "안녕하세요 " + radius + ", " + color;
		
	}
	
}
