package ch02_operator;

import java.util.Scanner;

public class Ex03_operator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���");
		int age = scanner.nextInt(); 
		if(age >= 65) {
			System.out.println("��� ���");
		} else {
			System.out.println("�Ϲ�");
		}
		scanner.close();
	}

}
