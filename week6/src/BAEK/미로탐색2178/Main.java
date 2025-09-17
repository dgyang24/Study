package BAEK.미로탐색2178;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int N;
	static int M;
	static char[][] maze;
	static int[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new int[N][M];
		maze = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j);
			}
//			System.out.println(Arrays.toString(maze[i]));
		}
		bfs(0,0);
		
		System.out.println(visited[N-1][M-1]); 
		
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		visited[r][c] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
			
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(maze[nr][nc] == '1' && visited[nr][nc] == 0) {
					visited[nr][nc] = visited[cr][cc]+1;
					q.add(new int[] {nr,nc});
				}
			}
			
			
			
		}
		
	}
	
	

}
