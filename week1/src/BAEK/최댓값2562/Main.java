package BAEK.최댓값2562;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int[] arr = new int[9];
		int cnt = 0;
		for(int i = 0; i < 9; i++) {
			int n = sc.nextInt();
			arr[i] = n;
			if(n > max)
				max = n;
		}
		for(int i = 0; i < 9; i++) {
			if(arr[i] == max) {
				cnt = i+1;
				break;
			}
		}
		System.out.println(max);
		System.out.println(cnt);

	}

}
