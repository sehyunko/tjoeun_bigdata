package com.lect.Interface;

/*14일 이상되면 실제로 연체료가 부과 되는지 시험해보기 위한 파일. 
책 대출 후 30일이 지난후 반납을 해보았음*/

import java.util.Date;
import java.util.GregorianCalendar;

public class BookTest {

	public static void main(String[] args) {
		Book[] books = {new Book("890ㄱ-105나", "자바", " 홍길동"), new Book("891ㄴ-106나", "오라클", " 김길동"),
				new Book("899ㄱ-131나", "하둡", " 김하하"), new Book("892ㄱ-121나", "스파크", " 고세현"),
				new Book("895ㄱ-133나", "파이썬", " 이기효"), };
		
		try {
			books[1].checkOut("고세현");
			books[1].setCheckOutDate(new Date(new GregorianCalendar(2021,7,2).getTimeInMillis()));
			books[1].checkIn("오라클");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
