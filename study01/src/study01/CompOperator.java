package study01;

public class CompOperator {

	public static void main(String[] args) {
		int num = 0;
		System.out.println(num);
		
//		num++;
		
		System.out.println(num++);
		System.out.println(num);
		
		
		System.out.println(++num);
		System.out.println(num);
		
		System.out.println(3 > 4);
		System.out.println(3 == 4);
		System.out.println(4 != 4);
		
		int a,b;
		a = 10;
		b = 20;
		
		if(a>b) {
			System.out.println("참입니다."); // true
		}else {
			System.out.println("거짓말!!!"); // false
		}
		
		int number = (3 > 4) ? 10:20;
		
		System.out.println(number);

	}

}
