package BAEK.단어뒤집기2_17413;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// 괄호 나오면 닫는 괄호 나올때 까지 그대로 집어넣어
			if (c == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				while (true) {
					c = str.charAt(i);
					sb.append(c);
					i++;
					// 닫는 괄호면 초기화
					if (c == '>') {
						i--;
						break;
					}
				}

			}

			else {
				// 공백이오면 스택 다 넣기
				if (c == ' ') {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(c);
				}
				else stack.push(c);
			}

		}
		// 남은거 있으면 다 털어
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}

}
