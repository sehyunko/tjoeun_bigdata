package com.lect.API;

public class SawonMain {

	public static void main(String[] args) {
		Sawon[] sawon = {new Sawon("111","김길동",Part.ACCOUNTING), 
			     new Sawon("112","김세현",Part.HUMANRESOURCES),
			     new Sawon("113","이기효",Part.DESIGN),
			     new Sawon("114","이호창",Part.DESIGN)};
		
	for(Sawon s:sawon) {
		System.out.println(s);
	}

	}

}
