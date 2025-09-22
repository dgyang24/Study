package BAEK.파티1238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	static final int INF = Integer.MAX_VALUE;
	static int V,E,home;
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			V = sc.nextInt();
			E = sc.nextInt();
			home = sc.nextInt();
			List<Edge>[] adj = new ArrayList[V+1];
			List<Edge>[] rAdj = new ArrayList[V+1]; //역방향 파티 -> 집
			for(int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
				rAdj[i] = new ArrayList<>();
			}
				
				
			int[] dist = new int[V+1];
			int[] rDist = new int[V+1]; //역방향
			Arrays.fill(dist, INF);
			Arrays.fill(rDist, INF);
			for(int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int cost = sc.nextInt();
				//역방향 인접 리스트도 같이 넣을거야~!
				adj[from].add(new Edge(to, cost));
				rAdj[to].add(new Edge(from, cost));
			}
			dijxtra(home, adj, dist);
			dijxtra(home, rAdj, rDist);
			int max = Integer.MIN_VALUE;
			for(int i = 1; i <= V; i++) {
				int sum = dist[i] + rDist[i];
				max = Math.max(max, sum);
			}
			System.out.println(max);
	}
	
	static void dijxtra(int start, List<Edge>[] adj, int[] dist) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			//방문 쳌
			if(visited[curr.to]) continue;
			visited[curr.to] = true;
			//최단거리 검색
			for(Edge node : adj[curr.to]) {
				if(!visited[node.to] && dist[node.to] > dist[curr.to] + node.cost) {
					dist[node.to] = dist[curr.to] + node.cost;
					pq.add(new Edge(node.to, dist[node.to]));
				}
			}
		}
	}

}