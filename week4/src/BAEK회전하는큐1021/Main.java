package BAEK회전하는큐1021;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<Integer> dq;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dq = new LinkedList<>();
		for(int i = 1; i <= N; i++)
			dq.add(i);
		int M = sc.nextInt();
		cnt = 0;
		//초기화 끝
		
		//목표물뽑아내기
		for(int i = 0; i < M; i++) {
			int target = sc.nextInt();
			findTarget(target);
			dq.pollFirst();
		}
		System.out.println(cnt);
		

	}
	//타겟 찾기
	static void findTarget(int target) {
		int idx = dq.indexOf(target);
		//idx 가 dq의 절반 기준 왼쪽에 있으면좌측이동, 반대면 우측이동하는게 더 빠름
		if(idx <= dq.size()/2) {
			while(target != dq.getFirst()) {
				moveLeft();
			}
		}
		else {
			while(target != dq.getFirst()) {
				moveRight();
			}
		}
		
	}
	
	//act2. 왼쪽으로 한 칸 이동
	static void moveLeft() {
		dq.add(dq.pollFirst());
		cnt++;
	}
	//act3. 오른쪽으로 한 칸 이
	static void moveRight() {
		dq.addFirst(dq.pollLast());
		cnt++;
	}
}
