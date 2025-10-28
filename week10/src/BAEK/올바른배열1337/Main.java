package BAEK.올바른배열1337;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = i; j < j+5; j++){
				if(j >= N) break;
				if(arr[j] < arr[i]+5)
					cnt++;
			}
			cnt = 5-cnt;
			ans = Math.min(ans, cnt);
			if(ans == 0) {
				break;
			}
		}
		System.out.println(ans);

	}

}
