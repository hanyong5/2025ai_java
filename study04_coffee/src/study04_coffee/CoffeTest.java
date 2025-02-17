package study04_coffee;

import java.util.Scanner;

public class CoffeTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CoffeeShop shop = new CoffeeShop(); // instance 생성 커피숍생성
		Customer customer = new Customer("홍길동",10000); // instance 생성 고객생성
		
//		customer.buyCoffee(shop, "아샷츄"); //customer class
//		customer.buyCoffee(shop, "아메리카노"); //customer class
//		customer.buyCoffee(shop, "라떼"); //customer class
		
		shop.showMenu(); // coffeeShop class
		
		//customer.buyCoffee(shop, "라떼"); //customer class
		
		while(true) {
			System.out.print("구매할 커피 이름을 입력 : ");
			String coffeeName = sc.nextLine();
			
			if(coffeeName.equalsIgnoreCase("exit")) {
				System.out.println("주문종료");
				break;
			}
			System.out.println("주문내역 ["+coffeeName+"]");
			
			customer.buyCoffee(shop, coffeeName);
		}
	}

}
