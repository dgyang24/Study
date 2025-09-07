package BAEK.최대힙11279;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			if (n == 0) {
				if (pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(-pq.poll());
			} else {
				pq.add(-n);
			}

		}
	}

}
