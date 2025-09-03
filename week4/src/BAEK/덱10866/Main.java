package BAEK.덱10866;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//덱생성
		Deque<Integer> dq = new ArrayDeque<>();
		for(int tc = 1; tc <= T; tc++) {
		
			
			//명령어
			String str = sc.next();
			//스위치구문 이용해서 명령어 실행
			switch(str) {
			case "push_front" : 
				dq.offerFirst(sc.nextInt());
				break;
			case "push_back" : 
				dq.offer(sc.nextInt());
				break;
			case "pop_front" : 
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.pop());
				break;
			case "pop_back" : 
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.removeLast());
				break;
			case "size":
				System.out.println(dq.size());
				break;
			case "empty":
				if(dq.isEmpty()) System.out.println(1);
				else  System.out.println(0);
				break;
			case "front" :
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.peek());
				break;
			case "back" :
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.peekLast());
				
				
			}
			
			
			
		}

	}

}
