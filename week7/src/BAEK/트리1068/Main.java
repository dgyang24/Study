package BAEK.트리1068;

import java.util.ArrayList;
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
		 int root = 0;
		 adj = new ArrayList[N];
		 for(int i = 0; i < N; i++)
			 adj[i] = new ArrayList<>();
		 //인접리스트로 트리 생성
		 for(int i = 0; i < N; i++) {
			 int from = sc.nextInt();
			 if(from == -1) {
				 root = i;
				 continue;
				 //루트 저장하고 끝
			 }
			 int to = i;
			 //부모 -> 자식
			 adj[from].add(to);
		 }
		 int delNode = sc.nextInt();
		 int ans = 0;
		 //초기화 끝
		 
		 //bfs로 자식 삭제
		 bfs(delNode);
		 //모든 노드 순회하면서
		 for(int i = 0; i < N; i++) {
			//1. 삭제되지 않았고
			 if(adj[i] == null) continue;
			 boolean isLeaf = true;
			 //2. 자식 노드가 없으면 리프
			 for(int j = 0; j < adj[i].size(); j++) {
				 int c = adj[i].get(j); //대상 노드의 자식
				 if(adj[c] != null) {
					 isLeaf = false;
					 break;
				 }
			 }
			 if(isLeaf) ans++;
		 }
		 System.out.println(ans);
		 
		 
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		q.add(start);
		//중요!! 삭제할 노드들 넣어놓ㅎ기
		List<Integer> rmList = new ArrayList<>();
		rmList.add(start);
		while (!q.isEmpty()) {
			int curr = q.poll();

				for (int n : adj[curr]) {
					if (visited[n])
						continue;
					visited[n] = true;
					rmList.add(n);
					q.add(n);
				}
			}


		//삭제 대상 다 삭제해줘잉!!
		for(int i = 0; i < rmList.size(); i++) {
			int n = rmList.get(i);
			adj[n] = null;
		}

	}

}
