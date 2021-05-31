package singleton.step1;

public class TestMain {

	public static void main(String[] args) {
		AClass a = AClass.getInstance(); 
		AClass b = AClass.getInstance(); 
		
		if(a==b) {
			System.out.println("a b 객체가 같다");
			System.out.println(a);
			System.out.println(b);
		} else {
			System.out.println("a b 객체는 서로 다르다");
			System.out.println(a);
			System.out.println(b);
		}
	}

}
