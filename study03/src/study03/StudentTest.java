package study03;

public class StudentTest {
	
	int sum = 0;
	public static void main(String[] args) {
		Student lee = new Student();
		lee.studentName = "이순신";
		lee.address = "서울";
		lee.year = 10;
		
		lee.showStudentInfo();
		
		
		Student kim = new Student();
		String han = "한성용";
		
		
		
		System.out.println(han.length());
	}

}
