package gitupload;

public class Ex02_beforeOOP {
	private int input;

	public Ex02_beforeOOP(int input) {
		this.input = input;
	}
	
	public void printGugudan() {
		for(int i=1; i<10;i++) {
			System.out.println(input+"x"+i+"="+input*i);
		}
	}

	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
	} 
	
	
	
}
