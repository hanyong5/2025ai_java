package study03;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] num = new int[5];
		num[0] = 10;
		num[4] =100;
		
		System.out.println(num[4]);
		
		String[] name = new String[] {"서울","부산","대구"};
		
		System.out.println(name[1]);
		
		int[] num1 = {10,20,30};
		String[] name1 = {"홍길동"};
		System.out.println(num1[2]);
		
//		for(초기값;조건;연산자) {}
		for(int i=0;i<num1.length;i++) {
			System.out.println(num1[i]);
		}
		//for~each
		for(int num2 : num1) {
			System.out.println(num2);
		}
		
		for(String city:name) {
			System.out.println(city);
		}
	}
}
