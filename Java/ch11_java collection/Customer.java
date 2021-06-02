package com.lect.Collection;

/*고객의 이름, 전화번호, 집 주소를 차례로 Customer라는 객체에 저장하기 위해 
일단 클래스를 만든다*/

public class Customer {
	private String name; 
	private String phone; 
	private String address;
	
	public Customer(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	} 
	
	@Override
	public String toString() {
		return name+" "+phone+" "+address; 
	}

	public String getName() {
		return name;
	}

}
