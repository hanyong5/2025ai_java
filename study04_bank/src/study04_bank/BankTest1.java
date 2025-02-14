package study04_bank;

public class BankTest1 {

	public static void main(String[] args) {
		BankAccount1 account = new BankAccount1("123-456-789","홍길동",100000);
//		BankAccount1 account1 = new BankAccount1("123-456-780","한성용",10000);
		
		account.deposit(50000);
		
		
		account.printTransactions(); // 내역서 확인

	}

}
