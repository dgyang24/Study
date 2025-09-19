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
	static List<Edge>[] adj;
	static int[] dist;
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			V = sc.nextInt();
			E = sc.nextInt();
			home = sc.nextInt();
			adj = new ArrayList[V+1];
			for(int i = 1; i <= V; i++)
				adj[i] = new ArrayList<>();
			dist = new int[V+1];
			Arrays.fill(dist, INF);
			for(int i = 0; i < E; i++) {
				adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
			}
			dijxtra(1);
			int max = Integer.MIN_VALUE;
			for(int i = 1; i <= V; i++) {
				int sum = dist[i] + dist[home];
				max = Math.max(max, sum);
			}
			System.out.println(max);
	}
	
	static void dijxtra(int start) {
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
				if(!visited[node.to] && dist[node.to] > dist[curr.to] + curr.cost) {
					dist[node.to] = dist[curr.to] + node.cost;
					pq.add(new Edge(node.to, dist[node.to]));
				}
				
				
			}
			
			
			
			
		}
		
		
	}

}