package gitupload;

/*������� �����ȣ, �̸�, �μ��� ��¹ް�
 *��ü�� ������ �ð��� �Ի��Ϸ� �ؼ� �� ����� 
 *���,�̸�,�μ�,�Ի����� ����ϴ� ���α׷��� ¥����*/
public class SawonMain {

	public static void main(String[] args) {
		Sawon[] sawon = {new Sawon("111","��浿",Part.ACCOUNTING), 
			     new Sawon("112","�輼��",Part.HUMANRESOURCES),
			     new Sawon("113","�̱�ȿ",Part.DESIGN),
			     new Sawon("114","��ȣâ",Part.DESIGN)};
		
	for(Sawon s:sawon) {
		System.out.println(s);
	}

	}

}