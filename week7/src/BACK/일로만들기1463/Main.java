package BACK.일로만들기1463;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		int cnt = 0;
		//1->N 까지 되는 방법 중 최솟값 기록
		//우리의 목표값은 1이므로, 1은 연산횟수가 0임 
		//그래서 2부터 돌거임
		for(int i = 2; i <= N; i++) {
			//조건 1: i-1인덱스에서 +1하는 방법
			dp[i] = dp[i-1]+1;
			//조건 2: i가 3의 배수일 때 i/3인덱스 값 +1한게 지금 현재갑보다 작은지 비교
			if(i % 3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			//조건 : i가 2의 배수일때 i/2의 인덱스 값 + 1한게 지금현재값보다 작은지 비교
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			
		}
		System.out.println(dp[N]);

	}

}
