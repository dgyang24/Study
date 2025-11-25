package BAEK.영역구하기2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int M,N,K;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		int[] init = {0, M-1};// 초기 비교대상 좌표
		int[][] arr = new int[K][4]; //직사각형 좌표
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			arr[i][0] = init[1] - r1;
			arr[i][1] = init[0] + c1;
			arr[i][2] = init[1] - (r2-1);
			arr[i][3] = init[0] + (c2-1);
			
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(); //영역리스트
		//초기화 끝
		
		//색종이 칠하자
		for(int i = 0; i < K; i++) {
			fill(arr[i][0], arr[i][1], arr[i][2], arr[i][3]);
		}
		
//		for(int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		
		//구분 나누자
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				pq.add(bfs(i,j));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()+"\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+" ");
		}
		System.out.println(sb);
		
		
	}
	
	static int bfs(int r, int c) {
		int cnt = 1; //여기 왔다는건 최소 1개 이상은 있다는 거니까
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r,c});
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			//4방
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				//범위탐색
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				//방문탐색
				if(visited[nr][nc]) continue;
				//이것도 아니면 큐에 넣고 현재 위치 쳌 하고 영역 세!
				visited[nr][nc] = true;
				q.add(new int[] {nr,nc});
				cnt++;
				
			}
			
			
		}
		
		
		
		
		return cnt;
	}
	
	
	
	
	static void fill(int r1, int c1, int r2, int c2) {
		int cr = Math.min(r2, r1);
		int er = Math.max(r2, r1);
		
		int cc = Math.min(c1, c2);
		int ec = Math.max(c1, c2);
		
		for(int i = cr; i <= er; i++) {
			for(int j = cc; j <= ec; j++) {
				visited[i][j] = true;
			}
		}
				
		
	}

}
