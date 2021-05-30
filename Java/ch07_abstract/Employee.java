package ch07_abstract;
/*정규직 3명, 계약직 2명의 월급을 계산해서 월급 명세서를 콘솔창에 출력하기
 * 정규직은 이름과 연봉을 입력 받아 월급을 계산하고, 월급의 10%를 상여금으로 지급한다
 * 계약직은 이름과 일별 근무시간, 시급을 입력받아 월급을 계산하고, 월급의 8%를 상여금으로 지급한다*/
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
