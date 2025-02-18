package study04_student;

public class StudentTest {

	public static void main(String[] args) {
		Student han = new Student("홍길동",20);


		han.setAge(0);
		
		System.out.println("이름 : " + han.getName() + ", 나이 : " + han.getAge());
		
	}

}
