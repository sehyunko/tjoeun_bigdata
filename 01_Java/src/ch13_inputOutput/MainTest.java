package gitupload;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/*N을 사용자가 입력할 때 까지 회원가입 정보 (이름,전화번호,생일,주소)를 ArrayList에 입력받는다 
N을 누르면, 그동안 받았던 회원가입 정보 리스트와 이하 몇명이 저장되었는지를 customer.txt 파일과 콘솔창에 출력한다
customer.txt 예시 
홍길동 010-9999-9999 08-22생 서울시 용산구
김마동 010-8888-8888 12-18생 서울시 종로구
                      . . . . . 이하 2명 가입*/

public class MainTest {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>(); 
		Scanner scanner = new Scanner(System.in); 
		String input; 
		String name; 
		String phone; 
		String birthday; 
		String address; 
		String regexBirthday = "^\\d{4}-\\d{2}-\\d{2}$"; 
		String regexPhone = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$"; 

		
		do {
			System.out.println("회원가입을 원하면 O, 종료를 원하면 X를 입력");
			input = scanner.next(); 
			if(input.equalsIgnoreCase("O")) {
				System.out.println("이름을 입력하세요");
				name = scanner.next(); 
				while(true) {
					System.out.println("전화번호를 입력하세요 (000-0000-0000 형식으로 입력하세요)");
					phone = scanner.next(); 
					boolean check = Pattern.matches(regexPhone, phone); 
					if(!check) {
						System.out.println("형식에 맞게 전화번호를 다시 입력하세요");
						continue; 
					}
					break; 
				}
				
				while(true) {
					
					System.out.println("생일을 입력하세요 (0000-00-00 형태로 생년,월,일을 입력하세요)");
					birthday = scanner.next(); 
					boolean check = Pattern.matches(regexBirthday, birthday); 
					if(!check) {
						System.out.println("생년월일을 형식에 맞게 입력하세요");
						continue;  
					}
					break;
				}
				System.out.println("주소를 입력하세요");
				scanner.nextLine(); 
				address = scanner.nextLine(); 
				customerList.add(new Customer(name,phone,birthday,address));
				
				PrintWriter printwriter = null; 
				try {
					printwriter = new PrintWriter("D:\\BigData\\src\\01_Java\\ch17_io\\textFile");
					printwriter.println("이름 전화 생일 주소"); 
					printwriter.println(customerList); 
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} finally {
					if(printwriter !=null) {
						try {							
							printwriter.close();
						} catch(Exception e) {
							
						}
					}
				}
				
			} else if(input.equalsIgnoreCase("X")) {
				break; 
			} else {
				System.out.println("잘못 입력하셨습니다");
				continue;
			}
			
		}while(true); 
			System.out.println("종료되었습니다");
			scanner.close(); 
	}

}
