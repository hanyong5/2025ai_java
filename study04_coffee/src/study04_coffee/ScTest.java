package study04_coffee;

import java.util.Scanner;

public class ScTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String str1 = "라떼";
		
		System.out.println(input == str1); // true/false
		System.out.println(input.equals(str1)); // true//false
	}

}
