package study04_bank;

public class BankAccount {
	int accountNum;
	String name;
	int balance;
	
	void deposit(int count) {
//		balance = balance + count;
		balance += count;
	}
	
	void withDraw(int count) {
		balance -= count;
	}

	@Override
	public String toString() {
		return "성용은행 고객님 " + name + ", 잔고는 " + balance + "원 입니다.";
	}
	
	
}
