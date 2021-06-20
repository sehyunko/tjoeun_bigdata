package gitupload;

/*checkIn 메소드:반납시 책의 이름을 입력받고 이상이 없므면 책의 도서 상태를 도서가능 상태로 바꾼다. 
 *또한 반납일을 생성하고, checkOutDate와 비교하여 14일 보다 더 지났으면 일당 1000원의 연체료를 부과한다
 *
 *checkOut 메소드: 대출인의 이름을 입력받고 저장된 데이터와 일치하면 책의 상태를 대출 가능으로 바꾸고, 대출일을 저장한다
 *
 *toString 메소드를 오버라이드 하여 객체를 바로 sysout에 넣어 책의 정보를 콘솔창에 출력할 수 있도록 한다
*/
import java.util.Date;
import java.util.GregorianCalendar;

public class Book implements IBook {
	private String bookName;
	private String borrower; 
	private Date checkOutDate;
	private String bookNum; 
	private String writer; 
	private byte state; 
	
	public Book(String bookNum, String bookName, String writer) {
		this.bookName = bookName;
		this.bookNum = bookNum;
		this.writer = writer;
	}
	
	@Override
	public void checkIn(String bookName) throws Exception {
		state = STATE_NORMAL; 
		Date today = new Date();
		long period = (checkOutDate.getTime()-today.getTime())/(1000*60*60*24);
		
		if(period>14) {
			throw new Exception("반납일이 14일 이상 되어 연체료 부과 해야됩니다.\n연체료는 "+period*1000+"원 입니다");
		}
		
	}

	@Override
	public void checkOut(String borrower) {
		state = STATE_BORROWED; 
		this.borrower = borrower; 
		checkOutDate = new Date(); 
	}
	@Override
	public String toString() {
		String result = String.format("%s,%s저 ",bookName,writer); 
		if(state == STATE_NORMAL) {
			result += " 대출가능"; 
		} else if (state == STATE_BORROWED) {
			result += " 대출중"; 
		} else {
			result += " 직원문의(이상 상태)";
		}
		return result;
	}

	public String getBookName() {
		return bookName;
	}

	public byte getState() {
		return state;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	

}
