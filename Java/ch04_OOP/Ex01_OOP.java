package ch04_OOP;
/*은행계좌 클래스를 설계하는 예제 
 * 계좌번호, 예금주,잔액을 입력받아 계좌를 생성한다 
 * 이후 예금,인출,잔액조회를 하는 기능 메소드를 정의한다*/

public class Ex01_OOP {	
	private String accountNo; 
	private String ownerName; 
	private int balance;
	
	public Ex01_OOP(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	} 
	
	public void deposit(int input) {
		balance +=input; 
		System.out.println("입금 후 잔액: "+balance);
	}
	public void withdraw(int output) {
		if(balance < output) {
			System.out.println("잔액이 부족합니다");
		} else {
			balance -=output;
			System.out.println("출금 후 잔액: "+balance);
		}
		
		
	}
	public void viewBalance() {
		System.out.println(ownerName+"님의 잔액은 "+balance+"원 입니다");
	}
	
	
	// getters and setters 
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}

