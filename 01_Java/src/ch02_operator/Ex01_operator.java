package gitupload;

import java.util.Scanner;

/*����ڷκ��� ���ڸ� �Է� �ް� 
 * �Է¹��� ���� 3�ǹ������ ����ϴ� ����*/
public class Ex01_operator {

	public static void main(String[] args) {
		
		int input; 
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ϴ� ������ �Է��ϼ���");
		input = scanner.nextInt();
		System.out.println(input%3 ==0?"3�� ��� �Դϴ�":"3�� ����� �ƴմϴ�"); 
		scanner.close(); 
	}

}