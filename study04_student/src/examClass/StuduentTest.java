package examClass;

public class StuduentTest {

	public static void main(String[] args) {
		Student student = new Student("홍길동");
		
		student.addSubject("자바", 50);
		student.addSubject("스크립트", 80);
		student.addSubject("파이썬", 60);
		
//		student.getAverage();
		student.printSubjects();
		

//		System.out.println("최고과목과 점수는" + student.getHighScoreSubject());
		
		
		
		
		
		
	}

}
