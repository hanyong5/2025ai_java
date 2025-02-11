package study02;

public class BreakTest {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i=1;i<11;i++) {
			sum += i;
			if(i==5) break;
		}
		
		System.out.println(sum);
		
		
		for(int i=1;i<=100;i++) {
			if((i%3)!=0) continue;
			
			System.out.println(i);
		}
		
		
	}

}
