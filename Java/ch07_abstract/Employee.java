package ch07_abstract;
/*������ 3��, ����� 2���� ������ ����ؼ� ���� ������ �ܼ�â�� ����ϱ�
 * �������� �̸��� ������ �Է� �޾� ������ ����ϰ�, ������ 10%�� �󿩱����� �����Ѵ�
 * ������� �̸��� �Ϻ� �ٹ��ð�, �ñ��� �Է¹޾� ������ ����ϰ�, ������ 8%�� �󿩱����� �����Ѵ�*/
public abstract class Employee {
	private String name; 
	public abstract String computePay(); 
	public abstract String computIncentive();
	
	public String setName(String name) {
		 return name;
	}
	public String getName() {
		return name;
	} 
	
	
	
	
}
