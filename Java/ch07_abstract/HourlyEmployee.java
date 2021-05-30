package ch07_abstract;
/*������ 3��, ����� 2���� ������ ����ؼ� ���� ������ �ܼ�â�� ����ϱ�
 * �������� �̸��� ������ �Է� �޾� ������ ����ϰ�, ������ 10%�� �󿩱����� �����Ѵ�
 * ������� �̸��� �Ϻ� �ٹ��ð�, �ñ��� �Է¹޾� ������ ����ϰ�, ������ 8%�� �󿩱����� �����Ѵ�*/
public class HourlyEmployee extends Employee {
	private String name;
	private int monthlyPay; 
	private int incentive; 
	private int hoursWorked; 
	private int moneyPerHour;
	
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		this.name = setName(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	@Override
	public String computePay() {
		monthlyPay = hoursWorked*moneyPerHour*30; 
		return monthlyPay+"";
	}
	@Override
	public String computIncentive() {
		incentive = (int)(monthlyPay*0.80);
		return incentive+"";
		
	}
	public String getName() {
		return name;
	} 
	
	
	
}
