package gitupload;

import java.util.Scanner;

/*사용자로부터 숫자를 입력 받고 
 * 입력받은 수가 3의배수인지 출력하는 예제*/
public class Ex01_operator {

	public static void main(String[] args) {
		
		int input; 
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 정수를 입력하세요");
		input = scanner.nextInt();
		System.out.println(input%3 ==0?"3의 배수 입니다":"3의 배수가 아닙니다"); 
		scanner.close(); 
	}

}