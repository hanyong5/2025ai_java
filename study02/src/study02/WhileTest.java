package study02;

public class WhileTest {

	//1~10 합 : 55
	public static void main(String[] args) {
		
		int num = 1;
		int sum = 0;
		
		while( num <= 10 ) {
//			sum = sum + num;
//			num = num + 1;
			
			sum += num;
			num++;
		}
		
		System.out.println("합은 " + sum );
		System.out.println("num " + num);
		
		
		int tsum = 0;
		int i = 1;
		
		while(true) {
			tsum += i;
			i++;
			
			if(i>10) {
				break;
			}
		}
		
		System.out.println(tsum);
		
		
		int jsum = 0;
		for(int j=1;j<=100;j++) {
			//jsum = 0;
			jsum += j; 
		}
		
		System.out.println("jsum : " + jsum);

	}

}
