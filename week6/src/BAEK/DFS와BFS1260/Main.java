package BAEK.DFS와BFS1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer>[] adj;
	static boolean[] visited;
	static StringBuilder sbD;
	static StringBuilder sbB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		visited = new boolean[N + 1];
		sbD = new StringBuilder();
		sbB = new StringBuilder();
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();
		// 인접리스트에 간선 정보입력
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			//양방향
			adj[from].add(to);
			adj[to].add(from);
		}
		//정렬
		for(int i = 1; i < adj.length; i++) {
			Collections.sort(adj[i]);
		}
		// dfs, bfs 각 실행하고
		dfs(V);
		visited = new boolean[N + 1];
		bfs(V);
		// 출력
		System.out.println(sbD);
		System.out.println(sbB);

	}

	static void dfs(int v) {
		visited[v] = true;
		sbD.append(v).append(" ");
		for (int i = 0; i < adj[v].size(); i++) {
			int n =adj[v].get(i);
			if (visited[n]) continue;
			dfs(n);
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		while (!q.isEmpty()) {
			int n = q.poll();
			if (visited[n])
				continue;
			visited[n] = true;
			sbB.append(n).append(" ");
			for (int i = 0; i < adj[n].size(); i++) {
				q.add(adj[n].get(i));
			}

		}

	}

	static boolean isTrue() {
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

}
