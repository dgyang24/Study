package BAEK.가장가까운공통조상3584;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int V, E;
	static List<Integer>[] adj;
	static int c1, c2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			V = sc.nextInt();
			E = V - 1;
			adj = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++)
				adj[i] = new ArrayList<>();
			// 인접리스트에 노드 연결
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				// 역방향으로 연결
				adj[to].add(from);

			}
			c1 = sc.nextInt();
			c2 = sc.nextInt();
			// 초기화 끝
			int ans = bfs(c1, c2);

			System.out.println(ans);
		}

	}// main

	static int bfs(int c1, int c2) {
		Queue<Integer> q = new LinkedList<>();
		q.add(c1);
		Set<Integer> tmpP = new HashSet<>();
		tmpP.add(c1);
		while (!q.isEmpty()) {
			int curr = q.poll();
			//일단 한쪽 노드먼저 부모 다 넣어봐
			for (int p : adj[curr]) {
				tmpP.add(p);
				q.add(p);
			}

		}
		
		//이제 비교대상 노드
		q.add(c2);
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(tmpP.contains(curr)) return curr;
			for(int p : adj[curr]) {
				if(tmpP.contains(p)) {
					return p;
				}
				q.add(p);
			}
		}
		
		
		
		
		return 0;
	}
}
