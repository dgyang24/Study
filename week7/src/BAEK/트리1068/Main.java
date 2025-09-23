package BAEK.트리1068;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Integer>[] adj;
	static int N;
	static int[] tree;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 tree = new int[N];
		 adj = new ArrayList[N];
		 for(int i = 0; i < N; i++)
			 adj[i] = new ArrayList<>();
		 for(int i = 0; i < N; i++)
			 tree[i] = sc.nextInt();
		 int delNode = sc.nextInt();
		 tree[delNode] = -2;
		 for(int i = 0; i < N; i++) {
			 if(tree[i] == delNode) tree[i] = -2;
		 }
		 int ans = 0;
		 for(int i = 0; i < N; i++)
			 if(tree[i] != -2) ans++;
		 
		 System.out.println(ans);
		 
		
		 
		 
//		 //트리연결(양방향)
//		 for(int i = 0; i < N; i++) {
//			int from = sc.nextInt();
//			int to = i;
//			adj[from].add(to);
//			adj[to].add(from);
//		 }
//		 bfs(0);
		 
//		 System.out.println(Arrays.toString(tree));

	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		q.add(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int node : adj[curr]) {
				if(visited[node]) continue;
				visited[node] = true;
				
				tree[node] = curr;
				q.add(node);
				
			}
			
					
		}
	}

}
