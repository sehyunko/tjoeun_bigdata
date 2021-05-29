package ch02_operator;
/*두 수를 입력 받아 같다면 여부에 따라 O출력
 * 두 수가 같지 않다면 어느 수가 더 큰지 출력*/

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
