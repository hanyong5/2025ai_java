package examClass01;


import java.util.ArrayList;
import java.util.List;

public class Subject {
	private String name;
	private List<Exam> exams; // 92,"날짜"
	
	public Subject(String name) {
		this.name = name;
		this.exams = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addExam(int score, String date) {
		exams.add(new Exam(score,date));
	}
	
	public int getAverage() {
		
		int total = 0;
		for(Exam exam:exams) {
			total += exam.getScore();
		}
		
		return (int) Math.floor( (double) total / exams.size());
		
	}
	
	public Exam getHighExam() {
		Exam highExam = exams.get(0); // 92,"날짜"
		
		for(Exam exam:exams) {
			if(exam.getScore() > highExam.getScore()) {
				highExam = exam;
			}
		}
		
		return highExam; // 점수, 날짜 가 나간다
	}
	
	public void printExams() {
		System.out.println("과목 : " + name);
		for(Exam exam:exams) {
			System.out.println("- " + exam);
		}
		System.out.println("평균점수 : " + getAverage() + "점");
	}

	
	
	
}
