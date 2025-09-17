package BAEK.스도쿠1580;

import java.util.Scanner;

public class Main {
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		dfs();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
		

	}//main
	
	static boolean dfs() {
		//board를 순회하면서 0이면 처리할거야
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == 0) {
					//1~9까지 하나씩 넣어보고 충족하면 ㄱ 아
					for(int k = 1; k <= 9; k++) {
						board[i][j] = k;
						//유효성 (중복검사)
						if(findRC(i,j) || findInBox(i,j)) {
							//유효하지 않으면 초기화할거고 넘어갈래
							board[i][j] = 0;
							continue;
						}
						//k를 넣고 돌려볼건데 성공하면 그만!
						if(dfs()) return true;
						//여긴 실패를 뜻하므로 초기화 + false반환
						board[i][j] = 0;
					}
					//1~9까지 다 돌려봤는데 안나와 그럼 실패!
					return false;
				}
			}
		}
		//여기까지 오면 다 채웠으므로 true;
		return true;
	}
	//현재 행, 열에 중복되는 숫자가 있니?
	static boolean findRC(int r, int c) {
		int n = board[r][c];
		int cnt = 0;
		//행 검사
		for(int j = 0; j < 9; j++) {
			if(board[r][j] == n) cnt++;
		}
		if(cnt >= 2) return true;
		cnt = 0;
		//열검사
		for(int i = 0; i < 9; i++) {
			if(board[i][c] == n) cnt++;
		}
		if(cnt >= 2) return true;
		return false;
	}
	//현재위치 기준 3*3안에 같은 숫자가 있니~
	static boolean findInBox(int r, int c) {
		//3보다 크면 나머지 빼줘잉!
		int cr = (r/3)*3;
		int cc = (c/3)*3;
		int n = board[r][c];
		int cnt = 0;
		for(int i = cr; i < cr+3;i++) {
			for(int j = cc; j < cc+3; j++) {
				if(board[i][j] == n) cnt++;
			}
		}
		if(cnt >= 2) return true;
		
		return false;
		
		
	}
	

}
