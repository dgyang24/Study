package BAEK.색종이2563;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[100][100];
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//색칠하기
		for(int i = 0; i < N; i++) {
			for(int x = arr[i][0]; x < arr[i][0]+10; x++) {
				for(int y = arr[i][1]; y < arr[i][1]+10; y++) {
					if(x < 100 && y < 100)
						paper[x][y] = 1;
				}
			}
		}
		//색칠공간세기
		int cnt = 0;		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1)
					cnt++;
			}
		}
		//출력(전체 너비 - 겹치는 너비)
		System.out.println(cnt);

	}

}
