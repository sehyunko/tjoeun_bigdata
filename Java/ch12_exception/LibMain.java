package com.lect.Interface;

/*대출시: 일단 대출할 도서를 입력받고 도서관 내의 해당 도서가 있는지, 대출 가능한 상태인지 파악한다. 이상이 없으면 대출을 실시한다
 *반납시: 도서관 내의 책 정보를 반복문으로 돌며 대출한 책이 맞는지 확인 하고 일치하는 책이 잇으면 반납을 실시 한다 
 *Book 클래스에서 오버라이드한 toString 메소드를 호출해 sysout을 통해 도서관 내 책의 정보를 출력한다*/
import java.util.Scanner;

public class LibMain {

	public static void main(String[] args) {
		Book[] books = {new Book("890ㄱ-105나", "자바", " 홍길동"), new Book("891ㄴ-106나", "오라클", " 김길동"),
				new Book("899ㄱ-131나", "하둡", " 김하하"), new Book("892ㄱ-121나", "스파크", " 고세현"),
				new Book("895ㄱ-133나", "파이썬", " 이기효"), };
		
		Scanner scanner = new Scanner(System.in);
		int fn; 
		String bookName; 
		String borrower; 
		boolean ok = false; 
		
		do {
			System.out.println("1: 대출 | 2:반납 | 3:도서현황 | 0: 종료");
			fn = scanner.nextInt();
			int idx; 
			switch(fn) {
			case 1: 
				System.out.println("대출하실 도서명을 입력하세요");
				bookName = scanner.next();
				for(idx=0;idx<books.length;idx++) {
					if(books[idx].getBookName().equals(bookName)) {
							ok = true; 
							break; 
						} 
						
					}
					if(!ok) {
						System.out.println("검색한 도서를 찾을 수 없습니다");
					}
					if(books[idx].getState()==IBook.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다");
				}	
					System.out.println("대출인의 이름을 입력하세요");
					borrower = scanner.next(); 
					books[idx].checkOut(borrower);
					ok=false; 
				break; 
			case 2: 
				System.out.println("반납할 책이름을 입력하세요");
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
				System.out.println("연체료를 지불 했으면 O, 아직 지불 안했으면 X를 누르세요");
				String pay = scanner.next(); 
				if(pay.equalsIgnoreCase("o")) {
					System.out.println("반납이 완료되었습니다");
				}else {
					return; 
				}
				break; 
			case 3:
				System.out.println("도서현황 입니다");
				for(Book b: books) {
					System.out.println(b);
				}
			break; 
			default: 
				System.out.println("0,1,2,3중 하나의 수를 입력하세요");
			
			
			}
		
		} while(fn!=0); 

		System.out.println("종료되었습니다");
		scanner.close(); 
	}

}
