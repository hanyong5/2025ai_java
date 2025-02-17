package study04_coffee;

public class CoffeTest {

	public static void main(String[] args) {

		CoffeeShop shop = new CoffeeShop(); // instance 생성
		
		shop.showMenu(); // coffeeShop class
		
		Customer customer = new Customer("홍길동",10000); // instance 생성
		
		customer.buyCoffee(shop, "아메리카노"); //customer class
	}

}
