package BACK.바이러스2606;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Integer>[] adj;
	static int V,E;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V+1];
		ans = 0;
		for(int i = 1; i <=V; i++)
			adj[i] = new ArrayList<>();
		//초기화
		
		//간선정보 양방향 저장
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adj[from].add(to);
			adj[to].add(from);
		}
		bfs(1);
		System.out.println(ans);
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[V+1];
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			//연결되어 있는 애들 얼마나 있니?
			for(int node : adj[curr]) {
				//방문쳌
				if(visited[node]) continue;
				visited[node] = true;
				//q에 넣고 넣은만큼 세기(연결되어있따는거니까)
				q.add(node);
				ans++;
			}
		}
	}
}
