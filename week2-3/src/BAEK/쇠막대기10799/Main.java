package BAEK.쇠막대기10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		boolean isPop = false;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				stack.push(c);
				isPop = false;
			}
			else {
				stack.pop();
				if(isPop) {
					cnt+=1;
				}else {
					cnt+=stack.size();
					isPop = true;
				}
				
				
			}
		}
		System.out.println(cnt);

	}

}
