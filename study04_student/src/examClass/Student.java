package examClass;

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
		
		Subject topScore = getHighScoreSubject();
		
		System.out.println("최고과목은 " + topScore.getName()+ ", 점수 : " + topScore.getScore() + "점 입니다.");
		
	}
	
	public int getAverage(){
		int sum = 0;
		for(Subject subject:subjects) {
			sum += subject.getScore();
		}
		
		return (int) Math.floor( (double) sum / subjects.size());
	  }
	
	//과목의 최고과목점수1
	public Subject getHighScoreSubject() {
		
		Subject highScore = subjects.get(0);
//		Subject name = new Subject("자바",50);
//		System.out.println("초기점수"+highScore);
		
		for(Subject subject:subjects) {
//			System.out.println(subject.getScore());
			if(subject.getScore() > highScore.getScore()) {
				highScore = subject;
			}
		}
		return highScore;
	}
	
	
	public Subject getHigh() {
//		Subject name = new Subject("국어",10);
		Subject name = subjects.get(0); // List<Subject> subjects
										// 과목명 = 자바, 점수 = 50
										// name.getScore() <- 50
		for(Subject kim:subjects) { // 50,80,60 kim.getScore()
			
			if(kim.getScore() > name.getScore()) { // 1. 50 > 50(f) 2.80 > 50(t) 3. 60 > 80(f)
				name = kim;
			}
			
			
		}
		
		return name; // 스크립트,80
	}
	
	
}
