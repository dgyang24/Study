package BAEK.농장관리1245;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 상 하 좌 우 좌상 우상 좌하 우하
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static int N, M;
	static int[][] farm;
	static int cnt;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		farm = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				farm[i][j] = sc.nextInt();
			}
		}
		cnt = 0;
		visited = new boolean[N][M];
		// 초기화끝

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;
				bfs(i, j);

			}
		}

		System.out.println(cnt);

	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		boolean isTrue = true;
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int target = farm[cr][cc];

			// 8방탐색
			for (int i = 0; i < 8; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				// 범위탐색
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				// 타겟보다 크면 false 
				if (farm[nr][nc] > target) {
					isTrue = false;
				}
				// 타겟과 같으면 q에 넣기
				if (!visited[nr][nc] && farm[nr][nc] == target) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}

		}
		// 만약 봉우리가 맞으면 cnt+
		if (isTrue)
			cnt++;

	}

}
