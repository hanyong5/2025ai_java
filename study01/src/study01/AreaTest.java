package study01;

public class AreaTest {
	//반지름이 5인 원의 면적을 구하세요(java,python,javascript,c)
	//78
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double pi = 3.141592;
		double radius, area;
//		int area;
		radius = 5.0;

		
//		area = (int)(pi * radius * radius);
		area = pi * radius * radius;
		
		
		System.out.println("반지름이 " + radius + "인 원의 면적은 "  + area + "입니다.");
	}

}
