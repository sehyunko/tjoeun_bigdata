package gitupload;

/*Customer�� ������ ���� �̸�,��ȭ��ȣ, ���ּҸ� customer��� ��ü�� �Է��ϰ�
������ ��ü�� HashMap�� ������ �� ���� N�� ������ �ý����� �����ϰ� HashMap�� ����� ������ 
Iterator�� ���� �ݺ����� ���� ����Ѵ�.  
���� �����: 
	ȫ�浿 010-9999-9999 ����� ��걸 ��굿
	�踶�� 010-8888-8888 ����� ������ ���굿
		....*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String,Customer> customerList = new HashMap<String,Customer>();	
		Scanner scanner = new Scanner(System.in); 
		String name; 
		String phone; 
		String address; 
		String input=null;
		
		do {
			System.out.println("�̸��� �Է��ϼ���");
			name = scanner.next(); 
			System.out.println("��ȭ��ȣ�� �Է��ϼ���");
			scanner.nextLine();
			phone = scanner.nextLine();
			System.out.println("���ּҸ� �Է��ϼ���");
			address = scanner.nextLine(); 
			Customer customer = new Customer(name,phone,address);
			customerList.put(customer.getName(),customer); 
			System.out.println("���Ḧ ���Ͻø� N�� ��������");
			input = scanner.next(); 
			if(input.equalsIgnoreCase("N")) {
				break;
			}
			
		} while(true); 
		Iterator<String> iterator  = customerList.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(customerList.get(iterator.next()));
		}
		System.out.println("����Ǿ����ϴ�");
		scanner.close(); 
	}
}
