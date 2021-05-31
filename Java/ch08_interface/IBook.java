package com.lect.Interface;

/*대출 가능 도서여부 확인 위한 STATE_NORMAL, STATE_BORROWED 변수선언 
 *대출시 호출할 CheckIn 메소드
 *반납시 호출할 CheckOut 메소드 
*/
public interface IBook {
	public byte STATE_NORMAL = 0; 
	public byte STATE_BORROWED =1; 
	public void checkIn(String bookName);
	public void checkOut(String borrower); 
}
