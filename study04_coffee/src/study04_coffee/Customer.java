package study04_coffee;

public class Customer {
	String name;
	int balance;
	
	
	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	


	public void buyCoffee(CoffeeShop shop, String coffeeName) {
		Coffee coffee = shop.getCoffee(coffeeName); //메뉴확인
		
		if(coffee != null) { // coffee data 있으면
			if(balance >= coffee.price) {
				balance -= coffee.price;
				System.out.println(name + "님이 " + coffee.name + " 를 구매하였습니다. 잔액은 " + balance + "원 입니다.");
			}else {
				System.out.println("잔액부족! 현재잔액 : " + balance + "원");
			}
		}else {
			System.out.println("해당 메뉴는 없습니다.");
		}
		
		
		
//		if(coffee == null) {
//			System.out.println("해당 메뉴는 없습니다.");
//		}else {
//			if(balance >= coffee.price) {
//				balance -= coffee.price;
//				System.out.println(name + "님이 " + coffee.name + " 를 구매하였습니다. 잔액은 " + balance + "원 입니다.");
//			}else {
//				System.out.println("잔액부족! 현재잔액 : " + balance + "원");
//			}
//		}
		
		
		
	}
	
	
	
}
