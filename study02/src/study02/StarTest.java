package study02;

import java.util.Iterator;

public class StarTest {

	public static void main(String[] args) {
		
		
		
		for(int i=1;i<=5;i++) {
			
			for(int j=1;j<=i;j++) {
				
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		for(int i=2;i<=9;i++) {
			System.out.println(i + "단");
			for(int j=1;j<10;j++) {
				System.out.println(i + " x " + j +" = " + i*j);
			}
			System.out.println();
		}
		
		String[] fruits = {"사과","바나나","오렌지","포도","멜론","딸기"};
		
//		System.out.println(fruits[0]);
//		System.out.println(fruits[1]);
//		System.out.println(fruits[2]);
//		System.out.println(fruits[3]);
//		System.out.println(fruits[4]);
//		System.out.println(fruits[5]);

		System.out.println(fruits.length);
		
		for(int i=0;i<fruits.length;i++) {
			System.out.println(fruits[i]);
		}
		
		for (int i = 0; i < fruits.length; i++) {
			
		}
		

		
		for(int i=1;i<10;i++) {
			
			System.out.println("2 x "+ i + " = " + 2*i);

		}
		
		for(int i=1;i<=5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		
		

	}

}
