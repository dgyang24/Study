package BAEK.나무자르기2805;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static long[] tree;
	static long sum;
	static long height;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		tree = new long[N];
		for(int i = 0; i < N; i++) {
			tree[i] = sc.nextLong();
		}
		Arrays.sort(tree);
		long start = 0;
		long end = tree[N-1];
		long ans = 0;
		//초기화
		
		//이진 탐색 : 나무 배열을 볼 게 아니라 절단기 높이를 봐야됨
		while(start <= end) {
			long mid = (start+end)/2;
			height = mid; 
			sum = 0;
			//나무를 순회하면서 현재 높이를 기준으로 잘린 나무들의 합을 갱신
			for(int i = 0; i < N; i++) {
				long diff = tree[i] - height;
				if(diff > 0) {
					//잘린 나무가 있으면 sum에 더해
					sum += diff;
				}
			}
			//나무의 길이가 M보다 작으면 0으로 초기화
			if(sum < M) {
				//왼쪽 부분 볼거야.
				end = mid-1;
			}
			else {
				//나무 길이가 M보다 크거나 같으면 
				//오른쪽 볼래
				start = mid+1;
				ans = mid;
			}
		}
		//높이 출력
		System.out.println(ans);
		
	}
}
