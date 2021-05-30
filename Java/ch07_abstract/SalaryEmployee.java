package ch07_abstract;
/*������ 3��, ����� 2���� ������ ����ؼ� ���� ������ �ܼ�â�� ����ϱ�
 * �������� �̸��� ������ �Է� �޾� ������ ����ϰ�, ������ 10%�� �󿩱����� �����Ѵ�
 * ������� �̸��� �Ϻ� �ٹ��ð�, �ñ��� �Է¹޾� ������ ����ϰ�, ������ 8%�� �󿩱����� �����Ѵ�*/
public class SalaryEmployee extends Employee {
	private String name; 
	private int monthlyPay;
	private int incentive; 
	private int annualSalary;
	
	
	public SalaryEmployee(String name, int annualSalary) {
		this.name = setName(name);
		this.annualSalary = annualSalary;
	}
	@Override
	public String computePay() {
		monthlyPay = annualSalary/12; 
		return monthlyPay+"";
	}
	@Override
	public String computIncentive() {
		incentive = (int)(monthlyPay*0.10); 
		return incentive+"";
	}
	public String getName() {
		return name;
	} 
	
	
}
