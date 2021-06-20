package gitupload;

public class AClass {
	private int intVar;
	private static AClass INSTANCE; //=new AClass(); 

	public static AClass getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new AClass();
		}
		return INSTANCE; 
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar; 
	}
	public int getIntvar() {
		return intVar;
	}
	
	

}
