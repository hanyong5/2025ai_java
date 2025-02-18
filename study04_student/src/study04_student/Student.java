package study04_student;

public class Student {
	private String name;
	private int age;
	
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		
		if(age > 0) {
			this.age = age;
		}else {
			System.out.println("나이가 0보다 커야 합니다.");
			this.age = 1;
		}
		
	}
	
	


	
	
	
	
	
	
	
	
	
	
}
