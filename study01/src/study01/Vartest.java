package study01;

public class Vartest {

	public static void main(String[] args) {
		int age = 25;
		long population = 780000000L;
		
		final float pi = 3.14f;
		double e = 2.1010102102;
		
		char grade = 'A';
		
		boolean isJavaFun = true;
		
		final String name = "홍길동"; // contant상수- 변화x변수
		String greeting = "안녕하세요";
		
//		name = "이순신";
	
		System.out.println("당신의 등급은 : " + grade + "등급 입니다.");
		System.out.println("자바는 재미 있나요?  " + isJavaFun);
		System.out.println("my name is " + name + ", " + greeting + "!!!." );

	}

}
