package ch02_control;

/*������ �� ���� ���� ����(0~100��)�� �߻����� 
 * ������ ����ϴ� ���α׷��� ����� ����*/

public class Ex01_switch {

	public static void main(String[] args) {
		int score; 
		score = (int)(Math.random()*101);
		System.out.println("�� ������: "+score);
		switch(score/100) {
		case 10:
		case 9:
			System.out.println("������ A");
		break; 
		case 8:
			System.out.println("������ B");
		break; 
		case 7:
			System.out.println("������ C");
		break; 
		case 6: 
			System.out.println("������ D");
		default:
			System.out.println("������ F");
		break;
		
		}

	}

}
