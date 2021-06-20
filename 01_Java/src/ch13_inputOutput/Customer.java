package gitupload;

/*N을 사용자가 입력할 때 까지 회원가입 정보 (이름,전화번호,생일,주소)를 ArrayList에 입력받는다 
N을 누르면, 그동안 받았던 회원가입 정보 리스트와 이하 몇명이 저장되었는지를 customer.txt 파일과 콘솔창에 출력한다
customer.txt 예시 
홍길동 010-9999-9999 08-22생 서울시 용산구
김마동 010-8888-8888 12-18생 서울시 종로구
                      . . . . . 이하 2명 가입*/

public class Customer {
	private String name; 
	private String phone; 
	private String birthday; 
	private String address;
	
	public Customer(String name, String phone, String birthday, String address) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.address = address;
	} 
	
	@Override
		public String toString() {
			return name+" "+phone+" "+birthday+" "+address; 
		}
	
	
}
