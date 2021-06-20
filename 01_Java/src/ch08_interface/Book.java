package gitupload;

/*checkIn �޼ҵ�:�ݳ��� å�� �̸��� �Է¹ް� �̻��� ���Ǹ� å�� ���� ���¸� �������� ���·� �ٲ۴�
 *checkOut �޼ҵ�: �������� �̸��� �Է¹ް� ����� �����Ϳ� ��ġ�ϸ� å�� ���¸� ���� �������� �ٲٰ�, �������� �����Ѵ�
 *toString �޼ҵ带 �������̵� �Ͽ� ��ü�� �ٷ� sysout�� �־� å�� ������ �ܼ�â�� ����� �� �ֵ��� �Ѵ�
*/
import java.util.Date;

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
	public void checkIn(String bookName) {
		state = STATE_NORMAL; 
		
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
	
	

}