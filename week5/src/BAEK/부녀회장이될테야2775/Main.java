package BAEK.부녀회장이될테야2775;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.println(countPerson(k, n));
			
			
		}

	}
	static int countPerson(int k, int n) {
		
		//종료조건
		//0층일 때는 각 호수에 해당하는 명수가 살고 있음
		if(k == 0) return n ;
		if(n == 1) return 1;
		//재귀조건
		//각 k층 n호의사람 수 = 옆집 사람수 + 바로 밑집 사람
		return countPerson(k-1,n) + countPerson(k,n-1);
		
	}

}
