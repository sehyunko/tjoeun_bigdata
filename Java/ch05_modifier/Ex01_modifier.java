package ch05_modifier;
/*
�������������������������������������������������
		�� �� ǥ
------------------------------------------------
	��ȣ �̸�	����	����	����	����	���
------------------------------------------------
	1   ���켺	90	80	95	265	88
	2   ���ϴ�	100	80	95	275	91
	3   Ȳ����	95	80	90	265	88
	4   ������	95	90	99	284	94
	5   ������	90      90      90     270     90
------------------------------------------------
�������������������������������������������������
* ���� ���̺��� �ۼ��ϴ� ���α׷��� �ۼ��Ͻÿ� 
*/

public class Ex01_modifier {
	private int id; 
	private String name; 
	private int kor; 
	private int eng; 
	private int math;
	private int individualTotal; 
	private int individualAvg;

	
	public Ex01_modifier(int id,String name, int kor, int eng, int math) {
		this.id = id; 
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		individualTotal = kor+eng+math; 
		individualAvg = individualTotal/3;
	}
	
	public void printTable() {
		System.out.print("\t"+id+"  "+name+"  "+kor+"  "+eng+"  "+math+"  "+individualTotal+"  "+individualAvg); 
		System.out.println();
	}
	
	
	
	
	
}
