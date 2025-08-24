package BAEK.카드1_2161;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//카드더미 큐
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++)
			q.add(i);
		//결과문
		StringBuilder sb = new StringBuilder();
		//카드놀이 
		while(q.size() != 1) {
			//맨위 1장 버리고
			sb.append(q.poll()).append(" ");
			//System.out.println(sb);
			//그다음 맨위 1장을 밑으로
			q.add(q.poll());
			//System.out.println(q);
			
		}
		sb.append(q.poll());
		//출력
		System.out.println(sb);

	}

}
