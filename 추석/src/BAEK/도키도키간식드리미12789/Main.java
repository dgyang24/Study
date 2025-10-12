package BAEK.도키도키간식드리미12789;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//현재 줄
		Queue<Integer> q = new LinkedList<>();
		//임시 공간
		Stack<Integer> stack = new Stack<>();
		//현재차례
		int curr = 1;
		//현재 줄 입력
		for(int i = 0; i < N; i++)
			q.add(sc.nextInt());
		//초기화 끝
		
		//일단 줄서 
		while(true) {
			while(!q.isEmpty()) {
				int nextQ = q.peek();
				//1. 현재 줄에 사람이 있고 현재차례와 같으면 뽑고
				if(nextQ == curr) {
					q.poll();
					curr++;
				}else {
					//아니면 임시 공간으로 넣어
					stack.add(q.poll());
				}
				if(!q.isEmpty() && q.peek() != curr) break;
				
			}
			while(!stack.isEmpty()) {
				//임시 공간에 사람이 있고
				int nextS = stack.peek();
				//현재차례 같으면 뽑아.
				if(nextS == curr) {
					stack.pop();
					curr++;
				}
				if(!stack.isEmpty() && stack.peek() != curr) break;
				
			}
			
			if(q.isEmpty()) {
				//큐가 다 비어있고, 스택도 다 비어있으면 나와
				if(stack.isEmpty()) break;
				//큐가 다 비어있고, 스택이 안비어있을때, 피크가 현재차례와 다르면 나와
				else {
					if(stack.peek() != curr) break;
				}
			}
			
			
			
			
		}//while
		
		//curr을 계속 ++ 해줬기 때문에 알맞은 줄서기면 curr == N+1이 되어야함
		if(curr == N+1) System.out.println("Nice");
		else System.out.println("Sad");

	}//main

}
