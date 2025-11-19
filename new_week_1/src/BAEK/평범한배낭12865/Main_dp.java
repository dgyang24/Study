package BAEK.평범한배낭12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_dp {
	static class Item implements Comparable<Item> {
		int w, v;

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Item o) {
			return this.w - o.w;
		}

	}

	static int N;
	static int K;
	static Item[] list;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new Item[N + 1];
		dp = new int[N + 1][2]; // 0 :무게, 1:가치
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		list[0] = new Item(0,0);
		Arrays.sort(list);
		// 초기화 끝

		// dp :
		for (int i = 1; i <= N; i++) {
			// 조건 1: 현재 무게가 k 초과하면 break; <- 오름정렬했기 때문
			if (list[i].w > K)
				break;
			// 현재 무게 일단 넣어
			dp[i][0] = list[i].w;
			dp[i][1] = list[i].v;
			// 조건 2: 이전 최적 무게와 더한 값이 k이하이면, 이전 무게 넣고 가치값도 갱신
			if ((dp[i - 1][0] + dp[i][0]) <= K) {
				// 무게 갱신
				dp[i][0] = dp[i - 1][0] + dp[i][0];
				// 가치 갱신
				dp[i][1] = dp[i - 1][1] + dp[i][1];
			} else if (dp[i][1] < dp[i - 1][1]) {
				// 그게 아니라면 이전게 더 우세하면 이전걸로 갱신
				dp[i][0] = dp[i - 1][0];
				dp[i][1] = dp[i - 1][1];
			}
		}

		System.out.println(dp[N][1]);
	}

}
