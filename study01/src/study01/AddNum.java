package study01;

import java.util.Scanner;

public class AddNum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a,b,sum;
		
		System.out.print("첫번째 숫자를 넣으세요");

		a = sc.nextInt();
		
		System.out.print("두번째 숫자를 넣으세요");
		b = sc.nextInt();
//		String b = sc.nextLine()
		
		sum = a + b;
		
		System.out.println(a + " 더하기 " + b + " 는 " + sum + "입니다");

	}

}
