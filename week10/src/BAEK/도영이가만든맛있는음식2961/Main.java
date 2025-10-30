package BAEK.도영이가만든맛있는음식2961;

import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] visited;
	static int bitter, sour;
	static int[][] arr;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		bitter = 0;
		sour = 1;
		//초기화 끝
		
		dfs(0);
		
		System.out.println(min);
		
		

	}
	
	static void dfs(int n) {
		//기저 : n이 끝까지 가면 그냥 리턴해
		if(n == N) return;
		
		//재귀 : 하나씩 비교 하면서 그거 해
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			sour *= arr[i][0];
			bitter += arr[i][1];
			int diff = Math.abs(sour-bitter);
			min = Math.min(diff, min);
			dfs(n+1);
			visited[i] = false;
			sour /= arr[i][0];
			bitter -= arr[i][1];
			
		}
		
		
		
	}

}
