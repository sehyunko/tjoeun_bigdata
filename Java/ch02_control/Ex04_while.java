package ch02_control;

/*1���� 100���̿� �ִ� 3�� ��� �������� ���ϴ� ����*/

public class Ex04_while {

	public static void main(String[] args) {
		int num=0; 
		int sum=0; 
		while(num<=100) {
			num++;
			if(num%3!=0) {
				continue; 
			} else {
				sum +=num; 
			}
			
		} 
		System.out.println("1~100������ 3����� �������� "+sum);

	}

}
