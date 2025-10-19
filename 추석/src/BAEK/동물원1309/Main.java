package BAEK.동물원1309;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] dp = new int[N+1][3];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for(int i = 2; i <= N; i++) {
			//현재 줄 모두 비워졌을 때 경우의 수,
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2]) % 9901;
			//현재 줄 중 왼쪽 칸만 채워졌을때
			dp[i][1] = (dp[i-1][0]+dp[i-1][2]) % 9901;
			//현재 줄 중 오른쪽 칸만 채워졌을 때
			dp[i][2] = (dp[i-1][0]+dp[i-1][1]) % 9901;
		}
		int ans = (dp[N][0]+dp[N][1]+dp[N][2])%9901;
		System.out.println(ans);

	}

}
