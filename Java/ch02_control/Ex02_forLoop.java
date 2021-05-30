package ch02_control;

import java.util.Scanner;

/*사용자로 부터 원하는 수를 입력 받아 구구단을 작성하는 예제*/

public class Ex02_forLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 1~9사이의 정수를 입력하세요");
			int input = scanner.nextInt(); 
			for(int i =1; i<10; i++) {
				System.out.println(input+"x"+i+"="+input*i);
			}
			scanner.close(); 
	}

}
