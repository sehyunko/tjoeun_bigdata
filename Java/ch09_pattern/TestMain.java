package singleton.step1;

public class TestMain {

	public static void main(String[] args) {
		AClass a = AClass.getInstance(); 
		AClass b = AClass.getInstance(); 
		
		if(a==b) {
			System.out.println("a b ��ü�� ����");
			System.out.println(a);
			System.out.println(b);
		} else {
			System.out.println("a b ��ü�� ���� �ٸ���");
			System.out.println(a);
			System.out.println(b);
		}
	}

}
