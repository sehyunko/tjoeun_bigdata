package ch02_operator;
/*�� ���� �Է� �޾� ���ٸ� ���ο� ���� O���
 * �� ���� ���� �ʴٸ� ��� ���� �� ū�� ���*/

import java.util.Scanner;

public class Ex02_operator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1; 
		double num2; 
		System.out.println("�� ���� �Է��ϼ���");
		num1 = scanner.nextDouble();
		num2 = scanner.nextDouble();
		if(num1==num2) {
			System.out.println("�� ���� ����");
		} else if(num1>num2) {
			System.out.printf("%.2f�� �� ũ��",num1);
		} else {
			System.out.printf("%.2f�� �� ũ��",num2);
		}
		scanner.close(); 
		

	}

}
