package study04_bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccount1 {
	String accoutNumber;
	String owner;
	double balance;
	List<String> transactions;
	
	
	public BankAccount1(String accoutNumber, String owner, double balance) {
		this.accoutNumber = accoutNumber;
		this.owner = owner;
		this.balance = balance;
		this.transactions = new ArrayList<>();
		transactions.add("계정생성 - 초기잔액 : " + balance + "원");
	}
	
	


	public void printTransactions() {
		System.out.println("입출금 내역 / " + owner + "님");
		
		for(String han : transactions) {
			System.out.println(han);
		}
		
	}



	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			transactions.add("입금 :" + amount + "원, 현재잔액 : " + balance + "원 입니다.");
			System.out.println(amount + "원이 입금되었습니다. 현재잔액 : " + balance + "원 입니다.");
			System.out.println();
		}else {
			System.out.println("입금금액이 0원보다 커야합니다.");
		}
		
	}
	
	
	
	
	

	
}
