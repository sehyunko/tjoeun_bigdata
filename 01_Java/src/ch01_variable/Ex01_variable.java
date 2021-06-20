package gitupload;

/*국어,영어 수학 점수를 각 변수에 할당 후 
 *총점, 평균을 출력하는 예제
*/
public class Ex01_variable {
	
	public static void main(String[] args) {
		double kor;  
		double english;
		double math; 
		double sum; 
		double avg; 
		
		kor = 96.5; 
		english = 92.3; 
		math = 86.4; 
		
		sum = kor+english+math; 
		avg = sum/3; 
		// 소수점 두번 자리 까지만 표기
		System.out.printf("총점: %3.2f|평균 점수:%3.2f",sum,avg);

	}

}