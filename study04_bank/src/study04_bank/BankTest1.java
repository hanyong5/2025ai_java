package study04_bank;

public class BankTest1 {

	public static void main(String[] args) {
		BankAccount1 account = new BankAccount1("123-456-789","스티브 잡스",100000);

		
		account.deposit(50000);
		account.withDraw(10000);
		account.withDraw(30000);
		account.withDraw(200000);
		
		
		account.checkBalace();
		
		
		account.printTransactions(); // 내역서 확인

	}

}
