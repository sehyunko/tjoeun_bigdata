package gitupload;

public class MenuTestMain {

	public static void main(String[] args) {
		Ex01_inheritance_HQ[] branch = {new Ex01_inheritance_branch(),
										new Ex01_inheritance_branch(), 
										new Ex01_inheritance_branch()}; 
		
//		���а�1ȣ��: ���� ������ ������,  ��ġ��� 5000������ ���߰� ������ ������ 500�� ������. 
		branch[0].setKimchi(5000);
		branch[0].setDbokki(4500);
		
		
				
//		���ǰ�2ȣ��: ���� ������ ������, ������ ���ݸ� 2000�� �λ��� �� 
		branch[1].setDbokki(7000);
				
//		���ð�3ȣ��: ���簡���� �״�� ������, ��ġ��� �δ�� ������ ���� 1000���� �λ��� ��
		branch[2].setKimchi(7000);
		branch[2].setBude(7500);
		
		System.out.println("\t **���а� 1ȣ��**");
		System.out.println(branch[0]);
		System.out.println("\t **���ǰ� 2ȣ��**");
		System.out.println(branch[1]);
		System.out.println("\t **���ð� 3ȣ��**");
		System.out.println(branch[2]);
		}

	}
