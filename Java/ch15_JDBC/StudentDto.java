package com.lect.ex3Student;

public class StudentDto {
	private String sNo, sName,mName;
	private int score, mNo, sExpel,rank;
	
	public StudentDto(String sNo, String sName, int score, int mNo, int sExpel) {

		this.sNo = sNo;
		this.sName = sName;
		this.score = score;
		this.mNo = mNo;
		this.sExpel = sExpel;
	}
	
	

	public StudentDto(int rank, String sName, String mName, int score) {
		this.sName = sName;
		this.score = score;
		this.rank = rank;
		this.mName = mName;
	}
	
	public StudentDto(int rank, String sName, int score) {
		this.sName = sName;
		this.score = score;
		this.rank = rank;
	}
	
	public StudentDto(String sName, int score, int mNo) {
		this.sName = sName;
		this.score = score;
		this.mNo = mNo;
	}
	
	
	public StudentDto(String sNo, String sName, int score, int mNo) {
		this.sNo = sNo;
		this.sName = sName;
		this.score = score;
		this.mNo = mNo;
	}

	

	public StudentDto(String sNo, String sName, String mName, int score) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}
	
	
	public String getsNo() {
		return sNo;
	}

	public String getsName() {
		return sName;
	}

	public int getScore() {
		return score;
	}

	public int getmNo() {
		return mNo;
	}

	public int getsExpel() {
		return sExpel;
	}
	
	
	@Override
	public String toString() {
		if(rank==0)
			return sNo+"\t"+sName+"\t"+mName+"\t"+score+"\n";
		else
			return rank+"\t"+sName+"\t"+score+"\n";
	}
	
	
	
	
	
	
}
