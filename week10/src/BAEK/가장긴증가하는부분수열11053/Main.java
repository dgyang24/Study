package BAEK.가장긴증가하는부분수열11053;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		int N = sc.nextInt();
		for(int i = 0; i < N; i++)
			set.add(sc.nextInt());
		Integer[] arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);
		int ans = 1;
		//초기화 끝
		for(int i = 0; i < arr.length-1; i++) {
			int cnt = 1;
			for(int j = i+1; j < arr.length; j++) {
				int diff = arr[j] - arr[i];
				int curr = arr[i];
				for(int k = j; k < arr.length; k++) {
					if(arr[i]+diff == arr[k]) {
						curr = arr[k];
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
			
		}
		System.out.println(ans);
		
		
		
	}

}
