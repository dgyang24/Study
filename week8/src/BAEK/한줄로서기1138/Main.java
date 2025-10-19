package BAEK.한줄로서기1138;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] result = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		//초기화
		
		//큰 수부터, 빈칸의 개수를 세면서 arr에 들어있는 빈칸의 개수 + 다음 빈칸 자리에 넣기
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			int goal = arr[i];
			for(int j = 0; j < N; j++) {
				if(result[j] == 0) {
					if(goal == cnt) {
						result[j] = i+1;
						break;
					}
					cnt++;
				}
				
			}
			
			
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(result[i] + " ");
		}

	}

}
