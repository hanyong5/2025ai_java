package study03;

public class ArrayTest {

	public static void main(String[] args) {
		int[] number = new int[3];
		
		number[0] = 10;
		number[1] = 11;
		number[2] = 21;
		
		System.out.println(number.length);
		
		for(int i=0;i<number.length;i++) {
			System.out.println("number[" + i + "] - " + number[i]);
		}
		
		int[] num = new int[]{10,20,30,40};
		
		for(int i=0;i<num.length;i++) {
			System.out.println("num[" + i + "] - " + num[i]);
		}
		
		
		String[] city = new String[3];
		city[0] = "서울";
		city[1] = "부산";
		city[2] = "대구";
		city[0] = "인천";
		//city[3] = "충북";
		
		for(int i=0;i<city.length;i++) {
			System.out.println(city[i]);
		}
		
		
		
	}

}
