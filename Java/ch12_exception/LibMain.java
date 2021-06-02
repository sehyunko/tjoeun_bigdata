package com.lect.Interface;

/*�����: �ϴ� ������ ������ �Է¹ް� ������ ���� �ش� ������ �ִ���, ���� ������ �������� �ľ��Ѵ�. �̻��� ������ ������ �ǽ��Ѵ�
 *�ݳ���: ������ ���� å ������ �ݺ������� ���� ������ å�� �´��� Ȯ�� �ϰ� ��ġ�ϴ� å�� ������ �ݳ��� �ǽ� �Ѵ� 
 *Book Ŭ�������� �������̵��� toString �޼ҵ带 ȣ���� sysout�� ���� ������ �� å�� ������ ����Ѵ�*/
import java.util.Scanner;

public class LibMain {

	public static void main(String[] args) {
		Book[] books = {new Book("890��-105��", "�ڹ�", " ȫ�浿"), new Book("891��-106��", "����Ŭ", " ��浿"),
				new Book("899��-131��", "�ϵ�", " ������"), new Book("892��-121��", "����ũ", " ����"),
				new Book("895��-133��", "���̽�", " �̱�ȿ"), };
		
		Scanner scanner = new Scanner(System.in);
		int fn; 
		String bookName; 
		String borrower; 
		boolean ok = false; 
		
		do {
			System.out.println("1: ���� | 2:�ݳ� | 3:������Ȳ | 0: ����");
			fn = scanner.nextInt();
			int idx; 
			switch(fn) {
			case 1: 
				System.out.println("�����Ͻ� �������� �Է��ϼ���");
				bookName = scanner.next();
				for(idx=0;idx<books.length;idx++) {
					if(books[idx].getBookName().equals(bookName)) {
							ok = true; 
							break; 
						} 
						
					}
					if(!ok) {
						System.out.println("�˻��� ������ ã�� �� �����ϴ�");
					}
					if(books[idx].getState()==IBook.STATE_BORROWED) {
						System.out.println("���� �������� �����Դϴ�");
				}	
					System.out.println("�������� �̸��� �Է��ϼ���");
					borrower = scanner.next(); 
					books[idx].checkOut(borrower);
					ok=false; 
				break; 
			case 2: 
				System.out.println("�ݳ��� å�̸��� �Է��ϼ���");
				bookName = scanner.next(); 
				for(idx=0; idx<books.length;idx++) {
					if(bookName.equals(books[idx].getBookName())) {
						ok =true; 
						break; 
					}
				}
				try {
					books[idx].checkIn(bookName);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("��ü�Ḧ ���� ������ O, ���� ���� �������� X�� ��������");
				String pay = scanner.next(); 
				if(pay.equalsIgnoreCase("o")) {
					System.out.println("�ݳ��� �Ϸ�Ǿ����ϴ�");
				}else {
					return; 
				}
				break; 
			case 3:
				System.out.println("������Ȳ �Դϴ�");
				for(Book b: books) {
					System.out.println(b);
				}
			break; 
			default: 
				System.out.println("0,1,2,3�� �ϳ��� ���� �Է��ϼ���");
			
			
			}
		
		} while(fn!=0); 

		System.out.println("����Ǿ����ϴ�");
		scanner.close(); 
	}

}
