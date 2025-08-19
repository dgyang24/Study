package BAEK.평균1546;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			int score = sc.nextInt();
			arr[i] = score;
			if(score > max)
				max = score;
		}
		
		double sum = 0;
		for(int i = 0; i < n; i++) {
			sum += (double) arr[i]/max*100;
		}
		double avg = sum / (double) n;
//		double result = Math.round(avg*Math.pow(10, 6))/(double)(Math.pow(10, 6));
		System.out.println(avg);
		
	}

}
