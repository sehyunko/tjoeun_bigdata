package gitupload;

/*Customer에 저장한 고객의 이름,전화번호, 집주소를 customer라는 객체에 입력하고
각각의 객체를 HashMap에 저장한 뒤 고객이 N을 누르면 시스템을 종료하고 HashMap에 저장된 정보를 
Iterator를 통해 반복문을 돌며 출력한다.  
예시 결과물: 
	홍길동 010-9999-9999 서울시 용산구 용산동
	김마동 010-8888-8888 서울시 마포구 노고산동
		....*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String,Customer> customerList = new HashMap<String,Customer>();	
		Scanner scanner = new Scanner(System.in); 
		String name; 
		String phone; 
		String address; 
		String input=null;
		
		do {
			System.out.println("이름을 입력하세요");
			name = scanner.next(); 
			System.out.println("전화번호를 입력하세요");
			scanner.nextLine();
			phone = scanner.nextLine();
			System.out.println("집주소를 입력하세요");
			address = scanner.nextLine(); 
			Customer customer = new Customer(name,phone,address);
			customerList.put(customer.getName(),customer); 
			System.out.println("종료를 원하시면 N을 누르세요");
			input = scanner.next(); 
			if(input.equalsIgnoreCase("N")) {
				break;
			}
			
		} while(true); 
		Iterator<String> iterator  = customerList.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(customerList.get(iterator.next()));
		}
		System.out.println("종료되었습니다");
		scanner.close(); 
	}
}
