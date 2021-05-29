package ch02_operator;

import java.util.Scanner;

public class Ex03_operator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요");
		int age = scanner.nextInt(); 
		if(age >= 65) {
			System.out.println("경로 우대");
		} else {
			System.out.println("일반");
		}
		scanner.close();
	}

}
