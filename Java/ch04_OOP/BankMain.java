package ch04_OOP;
/*은행계좌 클래스를 설계하는 예제 
 * 계좌번호, 예금주,잔액을 입력받아 계좌를 생성한다 
 * 이후 예금,인출,잔액조회를 하는 기능 메소드를 정의한다*/

public class BankMain {

	public static void main(String[] args) {
		Ex01_OOP[] bank = {new Ex01_OOP("111-222-333","홍길동",100000),
						 new Ex01_OOP("223-562-123","김길자",100000),
						 new Ex01_OOP("671-212-124","이순재",100000),
						 new Ex01_OOP("019-122-567","정준하",100000)};
		
		bank[3].viewBalance(); //정준하의 잔액 조회 
		bank[3].deposit(100000); //정준하의 계좌에 10,000원 입금 
		bank[3].withdraw(200000); // 정준하의 계좌에서 20,000원 출금
		bank[3].withdraw(100000); //정준하의 계좌에서 10,000원 출금(잔액 부족으로 출금 불가) 
		}
	}


