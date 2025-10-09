package BAEK.꽃길14620;

import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int[][] garden;
	static boolean[][] visited;
	static int sum;
	static int tmpSum; // 비교 합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		garden = new int[N][N];
		visited = new boolean[N][N];
		sum = Integer.MAX_VALUE;
		tmpSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				garden[i][j] = sc.nextInt();
			}
		}
		// 초기화 끝

		dfs(0, 0, 0);

		System.out.println(sum);

	}

	static void dfs(int r, int c, int cnt) {
		// 기저: cnt == 3
		if (cnt == 3) {
			sum = Math.min(sum, tmpSum);
			return;
		}
		// 재귀: 2차원 순회하면서 쳌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 1. 방문쳌
				if (visited[i][j])
					continue;
				// 2. 꽃이 될 수 있니?
				if (isFlower(i, j)) {
					// 될 수 있으면 땅값더하기
					// 방문표시
					checkVisited(i, j, true);
					// 3. 다음 좌표로 넘어가
					dfs(r, c + 1, cnt + 1);
					// 4. 방문취소 + 직전 더한값 빼주기
					// 될 수 있으면 땅값더하기
					// 방문표시
					checkVisited(i, j, false);
				}

			}
		} // 2차원 끝

	}// dfs

	// 꽃심기 ㄱㄴ?
	static boolean isFlower(int r, int c) {
		// 4방 탐색하면서
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 범위 벗어나거나
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				return false;
			// 방문이 되어있으면 false
			if (visited[nr][nc])
				return false;
		}

		// 위 검사 모두 통과하면 심을 수 있어!
		return true;
	}

	// 방문쳌 + 합 더하기
	static void checkVisited(int r, int c, boolean check) {
		int tmp = garden[r][c];
		// 꽃을 심을 수 있는 경우에만 들어오니까
		// 4방하면서 다 더하고
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 방문쳌
			visited[nr][nc] = check;
			tmp += garden[nr][nc];
		}

		// check에 따라 tmpsum에 더할지 뺄지
		if (check) {
			tmpSum += tmp;
		} else {
			tmpSum -= tmp;
		}

	}

}
