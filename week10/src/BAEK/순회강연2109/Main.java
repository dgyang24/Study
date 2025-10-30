package BAEK.순회강연2109;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static class lecture implements Comparable<lecture> {
		int fee, day;

		public lecture(int fee, int day) {
			this.fee = fee;
			this.day = day;
		}

		@Override
		public int compareTo(lecture o) {
			//날짜가 같으면 요금이 큰거부터
			if(o.day == this.day) {
				return o.fee-this.fee;
			}
			//날짜가 작은 거부터
			return this.day - o.day;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		lecture[] arr = new lecture[N];
		Set<Integer> visited = new HashSet<>();
		for(int i = 0; i < N; i++) {
			arr[i] = new lecture(sc.nextInt(), sc.nextInt());
		}
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(arr);
		int cnt = 0;
		//초기화 끝
		
		for(int i = 0; i < N; i++) {
			//1. 진행된 일정보다 같거나 작으면 일단 넣어 + 날짜세기
			if(cnt< arr[i].day ) {
				pq.add(arr[i].fee);
				cnt++;
			}else {
				if(!pq.isEmpty()) {
					//2. 진행된 일정보다 해당 날짜가 작으면 현재 넣은 값에서 가장 작은값, 지금 값 중 큰거 넣어
					int max = pq.poll();
					max = Math.max(max, arr[i].fee);
					pq.add(max);
				}
			}
			//System.out.println("pq="+pq);
		}
		
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		
		
		System.out.println(sum);

	}

}
