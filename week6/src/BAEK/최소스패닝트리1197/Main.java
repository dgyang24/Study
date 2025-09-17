package BAEK.최소스패닝트리1197;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
		
	}
	static int[] p;
	static int V,E;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); //정점개수
		E = sc.nextInt(); //간선개수
		p = new int[V+1];
		for(int i =1; i <= V; i++)
			p[i] = i;
		Edge[] edges = new Edge[E];
		//간선 넣기
		for(int i = 0; i < E; i++){
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		//가중치 기준으로 정렬
		Arrays.sort(edges);
		//가중치 합
		//간선 V-1개 뽑으면 사이클 x 최소스패닝될듯?
		int pick = 0;
		int ans = 0; //가중치 합
		for(int i = 0; i<E; i++) {
			if(pick == V-1) break;
			
			int px = findSet(edges[i].from);
			int py = findSet(edges[i].to);
			//부모가 다르면
			//연결이 안되있으니까 연결시켜
			if(px != py) {
				p[py] = px;
				pick++;
				ans += edges[i].cost;
			}
			
		}
		System.out.println(ans);

	}
	//부모찾기
	static int findSet(int x) {
		if(x != p[x]) return p[x] = findSet(p[x]);
		return x;
	}
}
