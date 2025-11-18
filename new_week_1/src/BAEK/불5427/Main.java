package BAEK.불5427;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 가로
	static int row;
	// 세로
	static int col;
	// 미로
	static char[][] maze;

	// 불 위치 리스트
	static Queue<int[]> fire;
	// 불의 도달 시간
    static int[][] fireTime; 
    
    // 상근이의 도달 시간
    static int[][] personTime;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			col = sc.nextInt();
			row = sc.nextInt();
			maze = new char[row][col];
			//시간 기록 초기화
			fireTime = new int[row][col];
            personTime = new int[row][col];
            for(int i=0; i<row; i++) {
                Arrays.fill(fireTime[i], -1);
                Arrays.fill(personTime[i], -1);
            }
			// 출발위치
			int[] start = new int[2];
			// 불위치 리스트
			fire = new LinkedList<>();
			for (int i = 0; i < row; i++) {
				String str = sc.next();
				for (int j = 0; j < col; j++) {
					char c = str.charAt(j);
					maze[i][j] = c;
					if (c == '@') {
						start[0] = i;
						start[1] = j;
					}
					if (c == '*') {
						fire.add(new int[] { i, j });
						fireTime[i][j] = 0; //불 시간 초기화
					}
				}
//				System.out.println(Arrays.toString(maze[i]));
			}
			// 초기화 끝
			//불시간 먼저 계산
			fireBFS(fire);
			int result = personBFS(start[0], start[1]);
			if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }

		} // tc

	}// main

	// 불 시간 계산
    static void fireBFS(Queue<int[]> fireQueue) {
        // fireQueue는 초기 불 위치로 이미 채워져 있고 fireTime도 0으로 설정되어 있음.
        
        while (!fireQueue.isEmpty()) {
            int[] curr = fireQueue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // 범위 체크
                if (nr < 0 || nc < 0 || nr >= row || nc >= col) continue;

                // 벽(#)이 아니고 아직 불이 도달하지 않은 칸이라면 확산
                if (maze[nr][nc] != '#' && fireTime[nr][nc] == -1) {
                    fireTime[nr][nc] = fireTime[r][c] + 1;
                    fireQueue.add(new int[] { nr, nc });
                }
            }
        }
    }
	
    static int personBFS(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        
        // 상근이 초기 위치 설정
        q.add(new int[] { startR, startC });
        personTime[startR][startC] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int time = personTime[r][c];
            
            //4방
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // 1. 다음 칸이 미로의 경계 밖이라면 (이동 성공 후 탈출)
                if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
                    return time + 1; // 현재 시간 + 1초 후 탈출
                }
                
                // 2.  벽이 아니고, 아직 방문하지 않은 칸일 때만
                if (maze[nr][nc] != '#' && personTime[nr][nc] == -1) {
                    
                    int nextTime = time + 1;
                    int fireArriveTime = fireTime[nr][nc];

                    // 상근이가 불보다 먼저 도착할 수 있나?혹은 불이 닿지 않는 곳인가
                    if (fireArriveTime == -1 || nextTime < fireArriveTime) {
                        
                        personTime[nr][nc] = nextTime;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }
        
        // 여기까지 왔으면 탈출 못한거임
        return -1;
    }
	
	

}
