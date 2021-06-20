package gitupload;

/*사원들의 사원번호, 이름, 부서를 출력받고
 *객체를 생성한 시간을 입사일로 해서 각 사원의 
 *사번,이름,부서,입사일을 출력하는 프로그램을 짜보자*/
public class SawonMain {

	public static void main(String[] args) {
		Sawon[] sawon = {new Sawon("111","김길동",Part.ACCOUNTING), 
			     new Sawon("112","김세현",Part.HUMANRESOURCES),
			     new Sawon("113","이기효",Part.DESIGN),
			     new Sawon("114","이호창",Part.DESIGN)};
		
	for(Sawon s:sawon) {
		System.out.println(s);
	}

	}

}