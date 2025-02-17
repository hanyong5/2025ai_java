package study04_coffee;

public class CoffeeShop {
	Coffee[] menu;

	public CoffeeShop() {
		menu = new Coffee[] {
				new Coffee("아메리카노",4000),
				new Coffee("아이스아메리카노",4500),
				new Coffee("라떼",5000),
				new Coffee("아샷츄", 5000)
		};
	}
	
	public void showMenu() {
		System.out.println("메뉴입니다.");
		for(Coffee coffee:menu) {
			System.out.println("- "+ coffee.name + " : " + coffee.price);
		}
	}

	public Coffee getCoffee(String coffeeName) {
		coffeeName = coffeeName.intern();
		
		for(Coffee coffee:menu ) {
			if(coffee.name == coffeeName ) {
				return coffee;  // 아메리카노,4000
			}
			
//			if(coffee.name.equals(coffeeName)) {
//				return coffee;
//			}
		}
		return null;

	}
	
	
}
