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
			System.out.println("�̸��� �Է��ϼ���");
			name = scanner.next(); 
			System.out.println("��ȭ��ȣ�� �Է��ϼ���");
			scanner.nextLine();
			phone = scanner.nextLine();
			System.out.println("���ּҸ� �Է��ϼ���");
			address = scanner.nextLine(); 
			Customer customer = new Customer(name,phone,address);
			customerList.add(customer); 
			System.out.println("���Ḧ ���Ͻø� N�� ��������");
			input = scanner.next(); 
			if(input.equalsIgnoreCase("N")) {
				break;
			}
			
		} while(true); 
		for(Customer c: customerList) {
			System.out.println(c);
		}
		System.out.println("����Ǿ����ϴ�");
		scanner.close(); 
	}
	
}
