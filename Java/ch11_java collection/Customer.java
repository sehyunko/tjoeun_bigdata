package com.lect.Collection;

/*���� �̸�, ��ȭ��ȣ, �� �ּҸ� ���ʷ� Customer��� ��ü�� �����ϱ� ���� 
�ϴ� Ŭ������ �����*/

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
