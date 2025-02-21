package examClass01;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Subject> subjects;
	
	public Student(String name) {
		this.name = name;
		this.subjects = new ArrayList<>();
	}
	
	public void addSubject(String subjectName) {
		subjects.add(new Subject(subjectName));
	}

	public Subject getSubject(String subjectName) {
		
		for(Subject subject:subjects) {
//			if(subject.getName() == subjectName) {
//				return subject;
//			}
			if(subject.getName().equals(subjectName)) {
				return subject;
			}
		}
		
		return null;
	}

	public void printAllSubjects() {
		System.out.println("학생이름 : " + name);
		for(Subject subject:subjects) {
			subject.printExams();
			System.out.println();
		}
		
	}


	
	
}
