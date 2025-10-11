package BAEK.친구비16562;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from,to,cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	static int[] p;
	static int[] costs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int money = sc.nextInt();
		costs = new int[V+1];
		for(int i = 1; i <= V; i++)
			costs[i] = sc.nextInt();
		Edge[] edges = new Edge[E];
		
		for(int i = 0 ; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			//두 정점 중 싼놈을 기준으로 비용 저장
			int cost = Math.min(costs[from], costs[to]);
			
			edges[i] = new Edge(from, to, cost);
		}
		Arrays.sort(edges);
		
		// 부모집합
		p = new int[V+1];
		for(int i = 1; i <= V; i++)
			p[i] = i;
		//친구관계가 모두 연결이 안되어 있으므로 간선만큼만 뽑을거야
		for(int i = 0; i<E; i++) {
			int px = findSet(edges[i].from);
			int py = findSet(edges[i].to);
			if(px != py) {
				//비용이 작은놈이 부모로 연결되게
				if(costs[px] <= costs[py]) {
					p[py] = px;
				}else {
					p[px] = py;
				}
			}
			
		}
		int ans = 0;
		//친구비 최소비용
		for(int i = 1; i <= V; i++) {
			if(i == p[i]) {
				ans+=costs[i];
			}
		}
		
		//출력
		if(ans <= money) {
			System.out.println(ans);
		}else {
			System.out.println("Oh no");
		}
		
		
		
	}//main
	
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		
		return p[x];
	}

}
