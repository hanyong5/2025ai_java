package examClass01;


public class ExamClassTest {

	public static void main(String[] args) {
		Student student = new Student("홍길동");
		student.addSubject("수학");
		student.addSubject("영어");
		
		Subject math = student.getSubject("수학");
		if(math != null) { // math 있으면

			math.addExam(92,"2025-02-19");
			math.addExam(80,"2025-02-20");
			math.addExam(100,"2025-02-21");
		}
		
		Subject eng = student.getSubject("영어");
		if(eng != null) {
			
			eng.addExam(50, "2025-01-19");
			eng.addExam(60, "2025-01-20");
			eng.addExam(70, "2025-01-21");
		}
		
		
		student.printAllSubjects();
		
	}

}
