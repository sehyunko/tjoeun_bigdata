package ch02_control;

import java.util.Scanner;

/*��ǻ�Ͱ� �߻��� �ζǹ�ȣ(1~45) �� ���� ���� ������ ����Ǵ� ���α׷� ����� ����*/

public class Ex03_doWhile {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("���ϴ� �ζ� ��ȣ�� �Է� (1~45������ ��)");
		
		do {
			int num = (int)(Math.random()*45+1);
			int input = scanner.nextInt();
			if(num==input) {
				System.out.println("�ζǿ� ��÷�Ǽ̽��ϴ�");
				break; 
			} else {
				System.out.println("�ƽ��׿�");
				continue; 
			}
			
		} while(true); 
		scanner.close();
	}

}
