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
	}
	
	
}
