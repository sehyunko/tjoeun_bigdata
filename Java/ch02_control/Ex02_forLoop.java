package ch02_control;

import java.util.Scanner;

/*����ڷ� ���� ���ϴ� ���� �Է� �޾� �������� �ۼ��ϴ� ����*/

public class Ex02_forLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ϴ� 1~9������ ������ �Է��ϼ���");
			int input = scanner.nextInt(); 
			for(int i =1; i<10; i++) {
				System.out.println(input+"x"+i+"="+input*i);
			}
			scanner.close(); 
	}

}
