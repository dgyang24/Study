package BAEK.최단경로1753;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge> {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static final int INF = Integer.MAX_VALUE;
	static int V,E;
	static List<Edge>[] adj;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); //정점 개수
		E = sc.nextInt(); //간선 개수
		int start = sc.nextInt();
		adj = new ArrayList[V+1]; //인덱스 접근 쉽게 0은 안쓸거야
		for(int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		//길이 정보 넣기
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		//간선정보 넣기
		for(int i = 0; i < E; i++) {
			//시작 - 끝 - 가중치 순 넣기
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		dijkstra(start);
		
		for(int i = 1; i <dist.length; i++) {
			if(dist[i] == INF)
				System.out.println("INF");
			else System.out.println(dist[i]);
		}
			
		
		
	}//main
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;//시작점 설정
		pq.add(new Edge(start, 0));
		while(!pq.isEmpty()) {
			//제일 가중치 낮은거 하나 뽑고
			Edge curr = pq.poll();
			//방문했니
			if(visited[curr.to]) continue;
			//방문쳌하고
			visited[curr.to] = true;
			//목적지에 대한 간선을 순회하면서
			for(Edge node : adj[curr.to]) {
				//방문 안했고, 현재 노드와 가중치를 더한 것이 직선거리보다 작으면 
				if(!visited[node.to] && dist[node.to] > dist[curr.to]+node.cost) {
					//거리 갱신
					dist[node.to] = dist[curr.to] + node.cost;
					//추가
					pq.add(new Edge(node.to, dist[node.to]));
				}
				
				
			}
			
			
			
			
		}//while
		
		
	}

}
