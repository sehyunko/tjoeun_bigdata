package gitupload;

import java.util.Scanner;

public class Ex02_operator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1; 
		double num2; 
		System.out.println("두 수를 입력하세요");
		num1 = scanner.nextDouble();
		num2 = scanner.nextDouble();
		if(num1==num2) {
			System.out.println("두 수는 같다");
		} else if(num1>num2) {
			System.out.printf("%.2f이 더 크다",num1);
		} else {
			System.out.printf("%.2f이 더 크다",num2);
		}
		scanner.close(); 
		

	}

}
