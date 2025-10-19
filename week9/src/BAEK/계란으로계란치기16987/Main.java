package BAEK.계란으로계란치기16987;

import java.util.Scanner;

public class Main {
	static class Egg {
		int S,W;

		public Egg(int s, int w) {
			S = s;
			W = w;
		}
	}
	static int N;
	static Egg[] eggs;
	static boolean[] visited;
	static int ans,cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N == 1) {
			System.out.println(0);
			return;
		}
		eggs = new Egg[N];
		for(int i = 0; i < N; i++) {
			eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
		}
		ans = 0;
		cnt = 0;
		visited = new boolean[N];
		//초기화 끝
		dfs(0);
		System.out.println(ans);
		
	}
	static void dfs(int start) {
		//기저 : start = N
		if(start == N) {
			ans = Math.max(ans, cnt);
		}
		//재귀
		for(int i = start; i < N; i++) {
			
			
			
			
		}
	}
}
