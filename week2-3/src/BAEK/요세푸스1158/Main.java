package BAEK.요세푸스1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		//큐 생성 및 초기값
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		int i = 0;
		//요세푸스 수열
		while(q.size() > 1) {
			i = (i+1) % K;
			if(i == 0) {
				sb.append(q.poll()).append(", ");
			}else {
				q.add(q.poll());
			}
			
			
			
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);

	}

}
