package BAEK.색종이만들기2630;

import java.util.Scanner;

public class Main {
	static int[][] colorPaper;
	static int cntW;
	static int cntB;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cntW = cntB = 0;
		colorPaper = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				colorPaper[i][j] = sc.nextInt();
			}
		}//초기화
		
		dividePaper(0, 0, N);
		System.out.println(cntW);
		System.out.println(cntB);
	}
	
	//색종이 나눠서 찾기
	static void dividePaper(int row, int col, int size) {
		if(!isColorPaper(row, col, size)) {
			dividePaper(row, col, size/2); //좌상
			dividePaper(row, col+size/2, size/2); //우상
			dividePaper(row+size/2, col, size/2); //좌하
			dividePaper(row+size/2, col+size/2, size/2); //우하
		}
		
		
	}
	//색종이 구분
	static boolean isColorPaper(int row, int col, int size) {
		int s = colorPaper[row][col];
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col+size; j++) {
				if(colorPaper[i][j] != s) return false;
			}
		}
		if(s == 1) cntB++;
		else if(s == 0) cntW++;
		return true;
	}
	
	
}
