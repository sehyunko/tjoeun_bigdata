package gitupload;

/*76,45,34,89,100,50,90,92  8개의 값을 
 * 1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요. 
*/
public class Ex01_array {

	public static void main(String[] args) {
		int[] nums = {76,45,34,89,100,50,90,92}; 
		int sum=0; 
		int avg; 
		int max=0; 
		int min=1000; 
		for(int i=0;i<nums.length;i++) {
			sum +=nums[i]; 
		}
		
		avg = sum/nums.length; 
		
		for(int i=0;i<nums.length-1;i++) {
			if(max<nums[i]) {
				max = nums[i]; 
			}
		}
		for(int i=0; i<nums.length;i++) {
			if(min>nums[i]) {
				min = nums[i]; 
			}
		}
		
		
		System.out.println("합계:"+sum+"  평균:"+avg);
		System.out.println("최대값:"+max+"  최소값:"+min);

	}

}
