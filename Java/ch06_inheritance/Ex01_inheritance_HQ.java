package ch06_inheritance;

public class Ex01_inheritance_HQ {
	/* ������ ������ ���� �޴��� �θ� Ŭ�������� å�� �ϰ�, 
	 * ���� Ŭ������ ��� �޾� ���а� 1ȣ��, ���ǰ� 2ȣ��, ���ð� 3ȣ�� Ŭ��������
	 * �ڽŵ��� ������ �°� �޴����� �� �����ϴ� ����*/
	
	public int kimchi = 6000; //��ġ�
	public int sunde= 7000; //����
	public int bude = 6500; //�δ��
	public int dbokki = 5000; //������
	
	@Override
	public String toString() { //toString �޼ҵ尡 ��ü�� �ּҰ� �ƴ� �޴��� ����� �� �ֵ��� �������̵�
		return "��ġ�:"+kimchi+"��| ����: "+sunde+"��| �δ��:"+bude+"��| ������: "+dbokki+"��";  
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
