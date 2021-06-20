package gitupload;

public class MenuTestMain {

	public static void main(String[] args) {
		Ex01_inheritance_HQ[] branch = {new Ex01_inheritance_branch(),
										new Ex01_inheritance_branch(), 
										new Ex01_inheritance_branch()}; 
		
//		대학가1호점: 본사 가격을 따르되,  김치찌개를 5000원으로 낮추고 떡볶이 가격은 500원 내릴것. 
		branch[0].setKimchi(5000);
		branch[0].setDbokki(4500);
		
		
				
//		증권가2호점: 본사 가격을 따르되, 떡볶이 가격만 2000원 인상할 것 
		branch[1].setDbokki(7000);
				
//		주택가3호점: 본사가격을 그대로 따르되, 김치찌개와 부대찌개 가격을 각각 1000원씩 인상할 것
		branch[2].setKimchi(7000);
		branch[2].setBude(7500);
		
		System.out.println("\t **대학가 1호점**");
		System.out.println(branch[0]);
		System.out.println("\t **증권가 2호점**");
		System.out.println(branch[1]);
		System.out.println("\t **주택가 3호점**");
		System.out.println(branch[2]);
		}

	}
