package study03;

public class PizzaTest {
	public static void main(String[] args) {
		Pizza obj; 
		
		
		
		
		
		obj = new Pizza();
		
		obj.size = 10;
		obj.type = "슈퍼슈프림";
		
		System.out.println(obj.type);
		
		
		Pizza obj1 = new Pizza(10,"슈퍼슈프림");
		Pizza obj2 = new Pizza(10,"치즈");
		Pizza obj3 = new Pizza(10,"유러피언피자");
		
		
		//System.out.println("피자의 크기는 : " + obj1.size + "이고, 피자의 이름은 " + obj1.type + "입니다.");
		
		System.out.println(obj3);
	}
}
