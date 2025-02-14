package study04_bank;

public class BankTest {

	public static void main(String[] args) {
		BankAccount name = new BankAccount();
		name.name = "홍길동";
		name.deposit(1000);
		System.out.println(name.toString());
		
		name.withDraw(500);
		System.out.println(name);
		
		name.withDraw(600);
		System.out.println(name);
	}

}
