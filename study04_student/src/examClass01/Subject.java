package examClass01;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private String name;
	private List<Exam> exams;
	
	public Subject(String name) {
		this.name = name;
		this.exams = new ArrayList<>();
	}
	
	
}
