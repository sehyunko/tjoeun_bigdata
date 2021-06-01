package com.lect.API;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sawon {
	private String sawonNum;
	private String name; 
	private String department; 
	private String date;
	
	
	Date dateHired = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일"); 
	
	public Sawon(String sawonNum, String name, String department) {
		this.sawonNum = sawonNum;
		this.name = name;
		this.department = department;
		this.date = sdf.format(dateHired); 
	} 
	
	@Override
	public String toString() {
		return "[사번] "+sawonNum+"[이름] "+name+"[부서] "+department+"[입사일] "+date; 
	}
	
	
	
	
}
