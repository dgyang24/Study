package BAEK.토마토7576;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] box;
	static int ans;
	static int cols,rows;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cols = sc.nextInt();
		rows = sc.nextInt();
		// 익은 토마토 위치리스트
		List<int[]> list = new ArrayList<>();
		ans = 0;
		box = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int n = sc.nextInt();
				box[i][j] = n;
				if (n == 1)
					list.add(new int[] { i, j });
			}
//			System.out.println(Arrays.toString(box[i]));
		}
		// 초기화 끝
		
		bfs(list);
		if(isFull()) System.out.println(ans); 
		else System.out.println(-1);
	}

	static void bfs(List<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> tmpQ = new LinkedList<>();
		for (int i = 0; i < list.size(); i++)
			q.add(list.get(i)); // 사과 위치 넣기

		while (!q.isEmpty()) {
			int size = q.size();
			for(int k = 0; k < size; k++) {
				int[] curr = q.poll();
				int cr = curr[0];
				int cc = curr[1];
				
				//4방탐색
				for(int i = 0; i < 4; i++) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];
				
					//범위쳌
					if(nr < 0 || nc < 0|| nr >= rows || nc >= cols) continue;
					//0이 아니면 패쓰!
					if(box[nr][nc] != 0) continue;
					//여기까지 왔으면 사과 익혀
					box[nr][nc] = 1;
					//다음 사이클에 이 위치 추가!
					q.add(new int[] {nr,nc});
				
				}
				
			}
			//q의 사이즈만큼 돌기 + 다음 사이클이 있다면 하루 증가
			if(!q.isEmpty())ans++;
			
		}

	}
	//박스가 다 익었나요?
	static boolean isFull() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(box[i][j] == 0) return false;
			}
		}
		return true;
	}

}
