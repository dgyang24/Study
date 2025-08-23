package BAEK.제로10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < K; i++) {
			int n = sc.nextInt();
			//0이면 pop
			if(n == 0) {
				stack.pop();
			}else {
				//아니면 값넣기
				stack.add(n);
			}	
		}
		//합 계산
		int sum = 0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);

	}

}
