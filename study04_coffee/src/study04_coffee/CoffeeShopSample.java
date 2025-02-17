package study04_coffee;

import java.util.Scanner;

public class CoffeeShopSample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("커피메뉴");
		System.out.println("1. 아메리카노 - 4000원");
		System.out.println("2. 아이스아메리카노 - 4,500원");
		System.out.println("3. 라떼 - 5,000원");
		System.out.println("4. 종료");
		
		
		//고객잔액
		int balance = 10000;
		boolean run = true;
		
		while(run) {
			System.out.print("구매할 커피번호를 선택하세요:");
			int select = sc.nextInt();
			
			int price = 0;
			String coffeeName = "";
			
			switch(select) {
				case 1:
					coffeeName="아메리카노";
					price=4000;
					break;
				case 2:
					coffeeName = "아이스아메리카노";
					price=4500;
					break;
				case 3:
					coffeeName = "라떼";
					price = 5000;
					break;
				case 4:
					System.out.println("주문을 종료합니다.");
					run = false;
					continue;
				default:
					System.out.println("올바른 번호를 입력하세요");
					continue;
			}
			
			if(balance >= price ) {
				balance -= price;
				System.out.println(coffeeName + "주문완료! 잔액 : " + balance + "원 입니다.");
			}else {
				System.out.println("잔액부족!!! 현재잔액 : " + balance + "원 입니다.");
			}
//			System.out.println("주문내용 : " + coffeeName + ", 금액 : " + price + "원 주문하셨습니다.");
		}
	}

}
