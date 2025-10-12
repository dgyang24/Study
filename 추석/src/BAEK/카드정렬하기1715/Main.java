package BAEK.카드정렬하기1715;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N,cnt;
//	static boolean[] visited;
	static PriorityQueue<Integer> card;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		card = new PriorityQueue<>();
//		visited = new boolean[N];
		for(int i = 0; i < N; i++)
			card.add(sc.nextInt());
		cnt = 0;
		ans = 0;
		//초기화끝
		
		//카드가 2개 이상일때
		while(card.size() >= 2) {
			int first = card.poll();
			int second = card.poll();
			
			int sum = first+second;
			ans+=sum;
			card.add(sum);
		}
		
		System.out.println(ans);
		
		
		
	}

}
