package com.lect.Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();	
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
			customerList.add(customer); 
			System.out.println("종료를 원하시면 N을 누르세요");
			input = scanner.next(); 
			if(input.equalsIgnoreCase("N")) {
				break;
			}
			
		} while(true); 
		for(Customer c: customerList) {
			System.out.println(c);
		}
		System.out.println("종료되었습니다");
		scanner.close(); 
	}
	
}
