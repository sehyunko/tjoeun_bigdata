package gitupload;

/*76,45,34,89,100,50,90,92  8���� ���� 
 * 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�. 
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
		
		
		System.out.println("�հ�:"+sum+"  ���:"+avg);
		System.out.println("�ִ밪:"+max+"  �ּҰ�:"+min);

	}

}
