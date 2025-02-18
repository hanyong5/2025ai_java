package classRoom;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Subject> subjects;

	
	public Student(String name) {
		this.name = name;
		this.subjects = new ArrayList<>();
	}
	
	public void addSubject(String subjectName,int score) {
		subjects.add(new Subject(subjectName,score));
	}
	
	public void printSubjects() {
		System.out.println(name + "학생의 수강과목 리스트 : ");
		for(Subject subject:subjects) {
			System.out.println("- " + subject);
		}
		System.out.println(subjects.size() + "과목의 평균점수(소수버림) : " + getAverage() + "점 입니다.");
	}
	
	public int getAverage(){
		int sum = 0;
		for(Subject subject:subjects) {
			sum += subject.getScore();
		}
//		System.out.println("합계"+ sum);
		
		return (int) Math.floor( (double) sum / subjects.size());
	  }
	
}
