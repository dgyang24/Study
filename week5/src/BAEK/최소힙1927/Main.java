package BAEK.최소힙1927;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int T = sc.nextInt();
		//T만큼 연산 실행
		for(int tc = 1; tc<= T; tc++) {
			int n = sc.nextInt();
			if(n == 0) {
				//pq가 비어있으면 0 출력 아니면 젤 작은 맨 앞에 거 출력
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
					
				}
			}else {
				//0이 아니면 넣어.
				pq.add(n);
			}
		}
		
	}

}
