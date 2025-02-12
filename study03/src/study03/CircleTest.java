package study03;

public class CircleTest {
	
	
	public static void main(String[] args) {
		Circle circle1 = new Circle(); //객체생성
		Circle circle2 = new Circle();

		
		circle1.radius = 100;
		circle1.color = "red";
		
		
		circle2.radius = 10;
		circle2.color = "pink";
		
		
		double area= circle1.getArea();
		double area2 = circle2.getArea();
		System.out.println(area);
		System.out.println(area2);
		System.out.println(circle1.toString());
		System.out.println(circle2.toString());
	}

}
