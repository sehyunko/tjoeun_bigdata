package ch02_control;

/*실행할 떄 마다 난수 점수(0~100점)를 발생시켜 
 * 학점을 출력하는 프로그램을 만드는 예제*/

public class Ex01_switch {

	public static void main(String[] args) {
		int score; 
		score = (int)(Math.random()*101);
		System.out.println("원 점수는: "+score);
		switch(score/100) {
		case 10:
		case 9:
			System.out.println("학점은 A");
		break; 
		case 8:
			System.out.println("학점은 B");
		break; 
		case 7:
			System.out.println("학점은 C");
		break; 
		case 6: 
			System.out.println("학점은 D");
		default:
			System.out.println("학점은 F");
		break;
		
		}

	}

}
