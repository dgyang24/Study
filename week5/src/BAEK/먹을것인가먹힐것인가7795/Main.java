package BAEK.먹을것인가먹힐것인가7795;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//A 크기
			int N = sc.nextInt();
			//B 크기
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for(int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			for(int i = 0; i < M; i++)
				B[i] = sc.nextInt();
			//먹을 수 있는 쌍의 개수
			int cnt = 0;
			//B를 오름차순 정렬하고, B의 맨 뒤의 값부터 비교하면서 작은값이 나타나는 순간 그만 + cnt j+1
			Arrays.sort(B);
			for(int i = 0; i < A.length; i++) {
				//B의 가장작은 값보다 작으면 그냥 컨티뉴
				if(A[i] <= B[0]) continue;
				for(int j = B.length-1; j >= 0; j--) {
					//B[j]가 A[i]보다 작은 값을 만나면 cnt에 그만큼 개수 더해주고 브렠
					if(B[j] < A[i]) {
						cnt += j+1;
						break;
					}
				}
			}
			System.out.println(cnt);
			
		}

	}

}
