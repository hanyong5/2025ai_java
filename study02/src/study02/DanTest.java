package study02;

import java.util.Scanner;

public class DanTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단수를 입력하세요.");
		
		int dan = sc.nextInt();
		
		System.out.println(dan + "단을 입력하셨습니다.");
		for(int i=2;i<10;i++) {
			System.out.println(dan + " x " + i + " = " + dan*i);
		}

	}

}
