package ch07_abstract;

/*정규직 3명, 계약직 2명의 월급을 계산해서 월급 명세서를 콘솔창에 출력하기
 * 정규직은 이름과 연봉을 입력 받아 월급을 계산하고, 월급의 10%를 상여금으로 지급한다
 * 계약직은 이름과 일별 근무시간, 시급을 입력받아 월급을 계산하고, 월급의 8%를 상여금으로 지급한다*/
public class SalaryMain {

	public static void main(String[] args) {
		Employee[] salary = {new SalaryEmployee("김과장",30000000),
							 new SalaryEmployee("이부장",40000000),
							 new HourlyEmployee("김세현",9,10000), 
							 new HourlyEmployee("이기효",8,10000),
							 new HourlyEmployee("이호창",10,10000)}; 
							 
		System.out.println("\t\t월급 명세서");
		System.out.println("----------------------------");
		System.out.println("이름 \t고용형태\t월급\t상여금");
		System.out.println("----------------------------");
		for(Employee e:salary) {
			if(e instanceof SalaryEmployee) {
				System.out.print(e.getName()+"\t정규직"+"\t"+e.computePay()+"\t"+e.computIncentive()+"\n");
			} else if(e instanceof HourlyEmployee) {
				System.out.print(e.getName()+"\t계약직"+"\t"+e.computePay()+"\t"+e.computIncentive()+"\n");
			}
		
		}
		System.out.println("----------------------------");
	}

}
