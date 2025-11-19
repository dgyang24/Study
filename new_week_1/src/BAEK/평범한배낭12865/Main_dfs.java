package BAEK.평범한배낭12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_dfs {
	static class Item{
		int w,v;

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
		
	}
	static int N;
	static int K;
	static Item[] list;
	static boolean[] visited;
	static int sumV;
	static int maxV;
	static int cntW;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sumV=0;
		maxV=0;
		cntW=0;
		list = new Item[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//초기화 끝
		
		dfs(0);
		System.out.println(maxV);
	}
	static void dfs(int k) {
		//기저1: 리스트 끝까지 갔을 때
		if(k==N) return;
		//기저2: 가중치가 K를 넘어가면
		if(cntW > K) return;
		//재귀
		for(int i = 0; i < N; i++) {
			//방문쳌
			if(visited[i]) continue;
			visited[i] = true;
			//가방에 담고 K보다 작으면 max값에 넣어
			sumV+=list[i].v;
			cntW+=list[i].w;
			if(cntW <= K) maxV = Math.max(sumV, maxV);
			//다음 턴~
			dfs(k+1);
			//취소 턴~
			sumV-=list[i].v;
			cntW-=list[i].w;
			visited[i] = false;
		}
		
		
	}
}
