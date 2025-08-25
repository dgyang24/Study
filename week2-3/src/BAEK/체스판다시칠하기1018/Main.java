package BAEK.체스판다시칠하기1018;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//현재 체스판 상태
		int cR = sc.nextInt();
		int cC = sc.nextInt();
		int[][] board = new int[cR][cC];
		for(int i = 0; i < cR; i++) {
			String s = sc.next();
			for(int j = 0; j < cC; j++) {
				char c = s.charAt(j);
				if(c == 'W') {
					board[i][j] = 0;
				}else if(c == 'B') {
					board[i][j] = 1;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		//순회시작
		for(int r = 0; r < cR; r++) {
			for(int c = 0; c < cC; c++){
				//인덱스 에러 처리
				if(r+7 >= cR || c+7 >= cC) {
					continue;
				}
				//색칠하기
				int cntW = 0;
				int cntB = 0;
				for(int i = r; i < r+8; i++) {
					for(int j = c; j < c+8; j++) {
						//첫번째가 흑 or 백 
						int pointW = ((i+j) % 2 == 0) ? 0 : 1;
						int pointB = ((i+j) % 2 == 0) ? 1 : 0;
						if(board[i][j] != pointW) cntW++;
						if(board[i][j] != pointB) cntB++;
						
					}
				}//색칠 끝
				//최솟값비교
				min = Math.min(min, Math.min(cntW, cntB));
				
				
			}
		}//순회 끝
		System.out.println(min);

	}

}
