package gitupload;

/*N�� ����ڰ� �Է��� �� ���� ȸ������ ���� (�̸�,��ȭ��ȣ,����,�ּ�)�� ArrayList�� �Է¹޴´� 
N�� ������, �׵��� �޾Ҵ� ȸ������ ���� ����Ʈ�� ���� ����� ����Ǿ������� customer.txt ���ϰ� �ܼ�â�� ����Ѵ�
customer.txt ���� 
ȫ�浿 010-9999-9999 08-22�� ����� ��걸
�踶�� 010-8888-8888 12-18�� ����� ���α�
                      . . . . . ���� 2�� ����*/

public class Customer {
	private String name; 
	private String phone; 
	private String birthday; 
	private String address;
	
	public Customer(String name, String phone, String birthday, String address) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.address = address;
	} 
	
	@Override
		public String toString() {
			return name+" "+phone+" "+birthday+" "+address; 
		}
	
	
}
