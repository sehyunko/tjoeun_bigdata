package gitupload;

/*�̸�, ��ȭ, ���̸� �Է��� �� �ִ� 3���� TextField�� ����,
 *����ڰ� �̸�, ��ȭ, ���̸� �Է��ϰ� ��� ��ư�� ������ ArrayList�� ������ �������� �����ϰ� 
 *��� ��ư�� ������ ArrayList�� ����� ȸ�������� person.txt��� ���Ϸ� ����Ѵ�*/
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