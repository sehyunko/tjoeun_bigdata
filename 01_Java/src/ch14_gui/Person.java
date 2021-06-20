package gitupload;

/*이름, 전화, 나이를 입력할 수 있는 3개의 TextField를 생성,
 *사용자가 이름, 전화, 나이를 입력하고 출력 버튼을 누르면 ArrayList에 정보를 차곡차곡 저장하고 
 *출력 버튼을 누르면 ArrayList에 저장된 회원정보를 person.txt라는 파일로 출력한다*/
public class Person {
	private String name; 
	private String phone; 
	private int age;
	
	public Person(String name, String phone, int age) {
		this.name = name;
		this.phone = phone;
		this.age = age;
	} 
	@Override
	public String toString() {
		return name+"\t"+phone+"\t"+age+"\n";
	}
	
	
}