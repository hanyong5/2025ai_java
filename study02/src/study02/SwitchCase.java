package study02;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {

		int month; //10월
		int day;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월 입력하세요...");
		month = sc.nextInt();
		
//		if(month == 1) {
//			day = 31;
//		}
//		if(month == 2) {
//			day = 28;
//		}
//		
//		
//		if(month == 12) {
//			day = 31;
//
//		} else {
//			day = 0;
//		}
		
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				day = 31;
				break;
			case 2: 
				day = 28;
				break;
			case 4: case 6: case 9: case 11:
				day = 30;
				break;
			default:
				day = 0;
				System.out.println("존재하지 않는 달입니다.");
		}
		
		System.out.println(day);

		
	}

}
