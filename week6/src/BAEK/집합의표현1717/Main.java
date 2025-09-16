package BAEK.집합의표현1717;

import java.util.Scanner;

public class Main {
	//부모리스트
	static int[] p;
	//집합크기
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt(); //연산개수
		p = new int[N+1];
		
		//p 초기화
		for(int i = 1; i<= N; i++)
			p[i] = i;
		
		
		for(int i = 0; i < M; i++) {
			int n = sc.nextInt();
			int from = sc.nextInt();
			int to = sc.nextInt();
			//0이면 인접노드 양방향 연결
			if(n == 0) {
				//합집합 할고얌
				union(from, to);
			}
			//1이면 가능 여부 판단해서 결과 출력
			else {
				if(find(from) == find(to)) System.out.println("YES");
				else System.out.println("NO");
			}
			
		}

	}//main
	
	static void union(int from, int to) {
		int pX = find(from);
		int pY = find(to);
		
		if(pX != pY) {
			p[pY] = pX;
		}
		
		
	}
	static int find(int from) {
		if(p[from] == from) return from;
		return find(p[from]);
	}

}
