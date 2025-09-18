package BAEK.행성연결16398;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to,cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int N;
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		List<Edge> edges = new ArrayList<>(); //간선리스트
		p = new int[N+1];
		for(int i =1; i<=N; i++)
			p[i] = i;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int n = sc.nextInt();
				//중복 경로 방지 
				if(i > j) edges.add(new Edge(i,j,n));
			}
		}
		//초기화 끝!!
		
		int pick = 0;
		long ans = 0; //비용 총합 <- 이거 롱으로 안하면 큰일남
		//비용 오름차순
		Collections.sort(edges);
		//비용 순으로 돌면서 pick을 N-1개뽑을거임
		for(Edge node : edges) {
			if(pick == N-1) break;
			
			int px = findSet(node.from);
			int py = findSet(node.to);
			//연결안되어있으면 연결해줘잉!
			if(px!=py) {
				p[py] = px;
				pick++;
				ans+=node.cost;
			}
		}
		//출력
		
		System.out.println(ans);

	}//main
	//부모연결
	static int findSet(int x) {
		if(p[x] != x) {
			return p[x] = findSet(p[x]);
		}
		return x;
		
	}

}
