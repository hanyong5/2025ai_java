package study03;

public class BankAccount {
	double balance; //잔액
	
	public BankAccount(double initBankAccount) {
		this.balance = initBankAccount;
	}


	private void deposit(double amount) {
		//balance = balance + amount; // balance += amount
		if(amount > 0) {
			balance += amount;
			System.out.println(balance + "원 입금 되었습니다.");
		}else {
			System.out.println("입금 금액이 0보다 커야 합니다.");
		}
		
	}

	public static void main(String[] args) {
		BankAccount account = new BankAccount(0);
		
		account.deposit(0);
		account.deposit(1000);
		account.deposit(10000);
		account.deposit(1);
	}
}
