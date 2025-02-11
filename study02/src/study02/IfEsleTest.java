package study02;

import java.util.Scanner;

public class IfEsleTest {

	public static void main(String[] args) {

		int age;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이입력를 입력하세요");
		
		age = sc.nextInt();
		
	
//		System.out.println(age);
		
		if(age >= 8) {
			System.out.println("학교에 다닙니다.");
		}else {
			System.out.println("학교에 다니지 않습니다.");
		}
		
		
		

	}

}
