package BAEK.트리의부모찾기11725;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Integer>[] adj;
	static int N;
	static boolean[] visited;
	static int[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		tree = new int[N+1];
		for(int i =1 ; i <= N; i++)
			adj[i] = new ArrayList<>();
		for(int i = 0; i < N-1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			
			//양방향 저장
			adj[from].add(to);
			adj[to].add(from);
		}
		bfs(1);
		for(int i = 2; i<= N; i++)
			System.out.println(tree[i]);
			
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			//curr의 연결된 자식 노드들 연결
			for(int node : adj[curr]) {
				if(visited[node]) continue;
				visited[node]  = true;
				tree[node] = curr;
				q.add(node);
				
			}
			
		}
		
		
	}

}
