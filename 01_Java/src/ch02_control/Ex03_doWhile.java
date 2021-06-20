package gitupload;

import java.util.Scanner;

/*컴퓨터가 발생한 로또번호(1~45) 한 개를 맞출 까지 진행되는 프로그램 만드는 예제*/

public class Ex03_doWhile {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("원하는 로또 번호를 입력 (1~45사이의 수)");
		
		do {
			int num = (int)(Math.random()*45+1);
			int input = scanner.nextInt();
			if(num==input) {
				System.out.println("로또에 당첨되셨습니다");
				break; 
			} else {
				System.out.println("아쉽네요");
				continue; 
			}
			
		} while(true); 
		scanner.close();
	}

}
