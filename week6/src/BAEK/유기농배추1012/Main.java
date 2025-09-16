package BAEK.유기농배추1012;

import java.util.Scanner;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[][] field; //인접리스트
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			//가로
			M = sc.nextInt();
			//세로
			N = sc.nextInt();
			//배추 개수
			int E = sc.nextInt();
			int ans = 0; //지렁이
			field = new int[N][M]; 
			//배추 할당
			for(int i = 0; i < E; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				field[r][c] = 1;
			}
			//하나씩 순회하면서 지렁이세기 +dfs
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(field[i][j] == 1) {
						ans++;
						//위 배추와 연결된 배추 찾아서 없애기
						dfs(i,j);
					}
				}
			}
			System.out.println(ans);
			
		}//tc

	}
	static void dfs(int r, int c) {
		field[r][c] = 0;// 방문처리
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			//범위 안에 있고, 다음위치가 1이면 다음 위치도 다시 탐색 ㄱㄱ
			if(field[nr][nc] == 1) dfs(nr,nc);
		}
	}

}
