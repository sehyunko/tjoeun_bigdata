package ch06_inheritance;

public class Ex01_inheritance_HQ {
	/* 음식점 본사의 가격 메뉴를 부모 클래스에서 책정 하고, 
	 * 본사 클래스를 상속 받아 대학가 1호점, 증권가 2호점, 주택가 3호점 클래스에서
	 * 자신들의 사정에 맞게 메뉴가격 을 변경하는 예제*/
	
	public int kimchi = 6000; //김치찌개
	public int sunde= 7000; //순대
	public int bude = 6500; //부대찌개
	public int dbokki = 5000; //떡볶이
	
	@Override
	public String toString() { //toString 메소드가 객체의 주소가 아닌 메뉴를 출력할 수 있도록 오버라이드
		return "김치찌개:"+kimchi+"원| 순대: "+sunde+"원| 부대찌개:"+bude+"원| 떡볶이: "+dbokki+"원";  
	}
	
	
	//getters and setters 
	
	public int getKimchi() {
		return kimchi;
	}

	public void setKimchi(int kimchi) {
		this.kimchi = kimchi;
	}

	public int getSunde() {
		return sunde;
	}

	public void setSunde(int sunde) {
		this.sunde = sunde;
	}

	public int getBude() {
		return bude;
	}

	public void setBude(int bude) {
		this.bude = bude;
	}

	public int getDbokki() {
		return dbokki;
	}

	public void setDbokki(int dbokki) {
		this.dbokki = dbokki;
	}
	
	
	
	
	
}
