package ch01_variable;

/*����,���� ���� ������ �� ������ �Ҵ� �� 
 *����, ����� ����ϴ� ����
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
		// �Ҽ��� �ι��� �ڸ� ������ ǥ��
		System.out.printf("����: %3.2f|��� ����:%3.2f",sum,avg);

	}

}
