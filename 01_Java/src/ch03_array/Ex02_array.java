package gitupload;

/*�Ž����� 2680�� 500, 100, 50, 10¥�� �������� �ٶ� ��� �־�� �ϳ�?*/

public class Ex02_array {

	public static void main(String[] args) {
		/* ���̵��: �Ž������� 500�� ������ ���� ����. �������� ���� 500�� ������ ������ ��.
		 * 500������ ���� �������� �� ���� ū ������ 100�� ������ ����. �� ������ ��� �ݺ� */
		int money = 2680; 
		int[] units = {500,100,50,10}; 
		int[] change = new int[4]; 
		
		for(int i =0; i<units.length;i++) {
			change[i] = money/units[i]; 
			money = money%units[i]; 
		}
		
		for(int i=0; i<change.length;i++) {
			System.out.println(units[i]+"�� "+change[i]+"��");
		}

	}

}
