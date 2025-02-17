package study04_coffee;

public class Customer {
	String name;
	int balance;
	
	
	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	


	public void buyCoffee(CoffeeShop shop, String coffeeName) {
		shop.getCoffee(coffeeName); //메뉴확인
		
	}
	
	
	
}
