package com.lect.Interface;

/*14�� �̻�Ǹ� ������ ��ü�ᰡ �ΰ� �Ǵ��� �����غ��� ���� ����. 
å ���� �� 30���� ������ �ݳ��� �غ�����*/

import java.util.Date;
import java.util.GregorianCalendar;

public class BookTest {

	public static void main(String[] args) {
		Book[] books = {new Book("890��-105��", "�ڹ�", " ȫ�浿"), new Book("891��-106��", "����Ŭ", " ��浿"),
				new Book("899��-131��", "�ϵ�", " ������"), new Book("892��-121��", "����ũ", " ����"),
				new Book("895��-133��", "���̽�", " �̱�ȿ"), };
		
		try {
			books[1].checkOut("����");
			books[1].setCheckOutDate(new Date(new GregorianCalendar(2021,7,2).getTimeInMillis()));
			books[1].checkIn("����Ŭ");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
