package BAEK.N번째큰수2075;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N*N; i++)
			pq.add(-sc.nextInt());
		for(int i = 0; i < N-1; i++) {
			pq.poll();
		}
		System.out.println(-pq.poll());
	}

}
