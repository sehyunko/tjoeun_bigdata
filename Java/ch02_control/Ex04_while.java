package ch02_control;

/*1에서 100사이에 있는 3의 배수 누적합을 구하는 예제*/

public class Ex04_while {

	public static void main(String[] args) {
		int num=0; 
		int sum=0; 
		while(num<=100) {
			num++;
			if(num%3!=0) {
				continue; 
			} else {
				sum +=num; 
			}
			
		} 
		System.out.println("1~100사이의 3배수의 누적합은 "+sum);

	}

}
