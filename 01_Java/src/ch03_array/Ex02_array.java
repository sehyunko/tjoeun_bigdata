package gitupload;

/*거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄때 몇개씩 주어야 하나?*/

public class Ex02_array {

	public static void main(String[] args) {
		/* 아이디어: 거스름돈을 500원 단위로 먼저 나눔. 나누기의 몫이 500원 동전의 갯수가 됨.
		 * 500원으로 나눈 나머지를 그 다음 큰 단위인 100원 단위로 나눔. 이 과정을 계속 반복 */
		int money = 2680; 
		int[] units = {500,100,50,10}; 
		int[] change = new int[4]; 
		
		for(int i =0; i<units.length;i++) {
			change[i] = money/units[i]; 
			money = money%units[i]; 
		}
		
		for(int i=0; i<change.length;i++) {
			System.out.println(units[i]+"원 "+change[i]+"개");
		}

	}

}
