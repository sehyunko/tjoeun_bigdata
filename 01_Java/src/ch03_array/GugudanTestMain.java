package gitupload;

import java.util.Scanner;

public class GugudanTestMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 단수를 입력하세요 (2~9)");
		int input = scanner.nextInt(); 
		Ex02_beforeOOP gugudan = new Ex02_beforeOOP(input);
		gugudan.printGugudan();
		scanner.close(); 
	}

}
