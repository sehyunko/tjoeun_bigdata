package gitupload;

/*���� ���� �������� Ȯ�� ���� STATE_NORMAL, STATE_BORROWED �������� 
 *����� ȣ���� CheckIn �޼ҵ�
 *�ݳ��� ȣ���� CheckOut �޼ҵ� 
*/
public interface IBook {
	public byte STATE_NORMAL = 0; 
	public byte STATE_BORROWED =1; 
	public void checkIn (String bookName) throws Exception;
	public void checkOut(String borrower); 
}
