package ch04_OOP;
/*������� Ŭ������ �����ϴ� ���� 
 * ���¹�ȣ, ������,�ܾ��� �Է¹޾� ���¸� �����Ѵ� 
 * ���� ����,����,�ܾ���ȸ�� �ϴ� ��� �޼ҵ带 �����Ѵ�*/

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
		System.out.println("�Ա� �� �ܾ�: "+balance);
	}
	public void withdraw(int output) {
		if(balance < output) {
			System.out.println("�ܾ��� �����մϴ�");
		} else {
			balance -=output;
			System.out.println("��� �� �ܾ�: "+balance);
		}
		
		
	}
	public void viewBalance() {
		System.out.println(ownerName+"���� �ܾ��� "+balance+"�� �Դϴ�");
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

