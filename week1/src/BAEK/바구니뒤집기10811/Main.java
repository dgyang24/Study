package BAEK.바구니뒤집기10811;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 바구니 개수
		int N = sc.nextInt();
		// 바구니 배열 생성
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		// M역순 횟수
		int M = sc.nextInt();
		// M만큼 반복하면서
		for (int tc = 0; tc < M; tc++) {
			// 시작점 i-1(인덱스)
			int start = sc.nextInt() - 1;
			// 끝점 j-1(인덱스)
			int end = sc.nextInt() - 1;
			// 시작점 ~ 끝점 역순
			for (int i = 0; i < Math.abs(end-start); i++) {
				//역순이 다시 바뀌지 않게
				if(start+i < end-i) {
					int tmp = arr[start+i];
					arr[start+i] = arr[end-i];
					arr[end-i] = tmp;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);

	}

}
