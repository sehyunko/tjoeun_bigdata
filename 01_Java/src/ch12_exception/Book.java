package gitupload;

/*checkIn �޼ҵ�:�ݳ��� å�� �̸��� �Է¹ް� �̻��� ���Ǹ� å�� ���� ���¸� �������� ���·� �ٲ۴�. 
 *���� �ݳ����� �����ϰ�, checkOutDate�� ���Ͽ� 14�� ���� �� �������� �ϴ� 1000���� ��ü�Ḧ �ΰ��Ѵ�
 *
 *checkOut �޼ҵ�: �������� �̸��� �Է¹ް� ����� �����Ϳ� ��ġ�ϸ� å�� ���¸� ���� �������� �ٲٰ�, �������� �����Ѵ�
 *
 *toString �޼ҵ带 �������̵� �Ͽ� ��ü�� �ٷ� sysout�� �־� å�� ������ �ܼ�â�� ����� �� �ֵ��� �Ѵ�
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
			throw new Exception("�ݳ����� 14�� �̻� �Ǿ� ��ü�� �ΰ� �ؾߵ˴ϴ�.\n��ü��� "+period*1000+"�� �Դϴ�");
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
		String result = String.format("%s,%s�� ",bookName,writer); 
		if(state == STATE_NORMAL) {
			result += " ���Ⱑ��"; 
		} else if (state == STATE_BORROWED) {
			result += " ������"; 
		} else {
			result += " ��������(�̻� ����)";
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
