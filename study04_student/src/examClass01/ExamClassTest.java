package examClass01;


public class ExamClassTest {

	public static void main(String[] args) {
		Student student = new Student("홍길동");
		student.addSubject("수학");
		
		Subject math = student.getSubject("수학");
		if(math != null) { // math 있으면

			math.addExam(92,"2025-02-20");
			math.addExam(80,"2025-02-21");
		}
		
		
		//student.printAllSubjects();
		
	}

}
