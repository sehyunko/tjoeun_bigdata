package ch07_abstract;
/*정규직 3명, 계약직 2명의 월급을 계산해서 월급 명세서를 콘솔창에 출력하기
 * 정규직은 이름과 연봉을 입력 받아 월급을 계산하고, 월급의 10%를 상여금으로 지급한다
 * 계약직은 이름과 일별 근무시간, 시급을 입력받아 월급을 계산하고, 월급의 8%를 상여금으로 지급한다*/
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
