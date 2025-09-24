package BAEK.일로만들기1463;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while(N != 1) {
			//규칙 1. 3으로 나눠 떨어지면 걍 나눠
			if(N % 3 == 0) {
				N /= 3;
				continue;
			}
			//규칙 2. 현재값이 2로 나눠지고, -1한값이 3으로 나눠질때 
			if(N % 2 == 0) {
				if((N-1)%3 == 0) {
					// 2로 나눈 값과 비교해서 3이 더 작으면 -1 2가 더 작으면 /2
					int n2 = N/2;
					int n3 = (N-1)/3;
				}
			}
			
			//규칙 3. 3과 2 둘 다 안나눠 떨어지면 -1
			cnt++;
		}
		
		
		
		//출력
		

	}

}
