package gitupload;

import java.text.SimpleDateFormat;
import java.util.Date;
/*사원들의 사원번호, 이름, 부서를 출력받고
 *객체를 생성한 시간을 입사일로 해서 각 사원의 
 *사번,이름,부서,입사일을 출력하는 프로그램을 짜보자*/
public class Sawon {
	private String sawonNum;
	private String name; 
	private String department; 
	private String date;
	
	
	Date dateHired = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일"); 
	
	public Sawon(String sawonNum, String name, String department) {
		this.sawonNum = sawonNum;
		this.name = name;
		this.department = department;
		this.date = sdf.format(dateHired); 
	} 
	
	@Override
	public String toString() {
		return "[사번] "+sawonNum+"[이름] "+name+"[부서] "+department+"[입사일] "+date; 
	}
	
	
	
	
}
