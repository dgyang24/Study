package BAEK.문자열폭발9935;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String M = sc.next();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			stack.push(c);
			StringBuilder tmp = new StringBuilder();
			for (int j = M.length() - 1; j >= 0; j--) {
				if(stack.isEmpty()||stack.peek() != M.charAt(j)) {
					//if(j !=  M.length() - 1 ) {
						tmp.reverse();
						for(int k = 0; k < tmp.length(); k++) {
							stack.push(tmp.charAt(k));
						}
					//}
					break;
				}
				if(!stack.isEmpty()) {
					tmp.append(stack.pop());
				}
				
				
			}
		}
		if(stack.size() == 0) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			while(!stack.empty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb.reverse());
		}

	}

}
