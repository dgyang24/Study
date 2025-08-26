package BAEK.프린터큐1966;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				q.add(sc.nextInt());

			}
			int cnt = 0;
			// 시작
			while (q.size()!=0) {
				int max = q.peek();
				boolean isMax = false;
				for (int i = 0; i < N; i++) {
					int poll = q.poll();
					if (max < poll) {
						isMax = true;
					}
					q.add(poll);
				}
				if (isMax) {
					// peek보다 큰 값있으면 add
					q.add(q.poll());
				} else {
					// 없으면 poll
					q.poll();
					cnt++;
					N--;
					if(M == 0) break;
				}
				if(M == 0) M = N;
				M--;

			} // 반복 끝
			System.out.println(cnt);

		}

	}

}
