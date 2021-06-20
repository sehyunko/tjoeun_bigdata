package gitupload;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/*N�� ����ڰ� �Է��� �� ���� ȸ������ ���� (�̸�,��ȭ��ȣ,����,�ּ�)�� ArrayList�� �Է¹޴´� 
N�� ������, �׵��� �޾Ҵ� ȸ������ ���� ����Ʈ�� ���� ����� ����Ǿ������� customer.txt ���ϰ� �ܼ�â�� ����Ѵ�
customer.txt ���� 
ȫ�浿 010-9999-9999 08-22�� ����� ��걸
�踶�� 010-8888-8888 12-18�� ����� ���α�
                      . . . . . ���� 2�� ����*/

public class MainTest {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>(); 
		Scanner scanner = new Scanner(System.in); 
		String input; 
		String name; 
		String phone; 
		String birthday; 
		String address; 
		String regexBirthday = "^\\d{4}-\\d{2}-\\d{2}$"; 
		String regexPhone = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"; 

		
		do {
			System.out.println("ȸ�������� ���ϸ� O, ���Ḧ ���ϸ� X�� �Է�");
			input = scanner.next(); 
			if(input.equalsIgnoreCase("O")) {
				System.out.println("�̸��� �Է��ϼ���");
				name = scanner.next(); 
				while(true) {
					System.out.println("��ȭ��ȣ�� �Է��ϼ��� (000-0000-0000 �������� �Է��ϼ���)");
					phone = scanner.next(); 
					boolean check = Pattern.matches(regexPhone, phone); 
					if(!check) {
						System.out.println("���Ŀ� �°� ��ȭ��ȣ�� �ٽ� �Է��ϼ���");
						continue; 
					}
					break; 
				}
				
				while(true) {
					
					System.out.println("������ �Է��ϼ��� (0000-00-00 ���·� ����,��,���� �Է��ϼ���)");
					birthday = scanner.next(); 
					boolean check = Pattern.matches(regexBirthday, birthday); 
					if(!check) {
						System.out.println("��������� ���Ŀ� �°� �Է��ϼ���");
						continue;  
					}
					break;
				}
				System.out.println("�ּҸ� �Է��ϼ���");
				scanner.nextLine(); 
				address = scanner.nextLine(); 
				customerList.add(new Customer(name,phone,birthday,address));
				
				PrintWriter printwriter = null; 
				try {
					printwriter = new PrintWriter("D:\\BigData\\src\\01_Java\\ch17_io\\textFile");
					printwriter.println("�̸� ��ȭ ���� �ּ�"); 
					printwriter.println(customerList); 
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} finally {
					if(printwriter !=null) {
						try {							
							printwriter.close();
						} catch(Exception e) {
							
						}
					}
				}
				
			} else if(input.equalsIgnoreCase("X")) {
				break; 
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				continue;
			}
			
		}while(true); 
			System.out.println("����Ǿ����ϴ�");
			scanner.close(); 
	}

}
