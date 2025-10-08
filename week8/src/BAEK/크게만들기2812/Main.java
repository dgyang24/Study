package BAEK.크게만들기2812;

import java.util.Scanner;

public class Main {
	static int N,M;
	static String str;
	static int max;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		str = sc.next();
		max = Integer.MIN_VALUE;
		visited = new boolean[N];
		sb = new StringBuilder();
		dfs(1);
		
		System.out.println(max);
		
	}
	
	static void dfs(int n) {
		int length = N-M;
		//기저 : n ==length
		if(n == length) {
			//비교하고 리턴
			max = Math.max(max, Integer.parseInt(sb.toString()));
			return;
		}
		
		//문자열 길이만큼 반복하면서 
		for(int i = 0; i < length; i++) {
			char c = str.charAt(i);
			//방문쳌
			if(visited[i]) continue;
			sb.append(c);
			visited[i] = true;
			dfs(n+1);
			sb.deleteCharAt(sb.length());
			visited[i] = false;
			
		}
		
	}
}
