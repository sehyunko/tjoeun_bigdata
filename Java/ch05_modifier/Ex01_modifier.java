package ch05_modifier;
/*
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		성 적 표
------------------------------------------------
	번호 이름	국어	영어	수학	총점	평균
------------------------------------------------
	1   정우성	90	80	95	265	88
	2   김하늘	100	80	95	275	91
	3   황정민	95	80	90	265	88
	4   강동원	95	90	99	284	94
	5   유아인	90      90      90     270     90
------------------------------------------------
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
* 위의 테이블을 작성하는 프로그램을 작성하시오 
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
