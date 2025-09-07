package BAEK.수정렬하기2_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while(!pq.isEmpty())
			sb.append(pq.poll()).append("\n");
		System.out.println(sb);
	}

}
