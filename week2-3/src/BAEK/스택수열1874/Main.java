package BAEK.스택수열1874;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//목표배열 생성
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		List<Integer> list = new ArrayList();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		//넣을 숫자
		int n = 1;
		//목표 배열의 인덱스
		int idx = 0;
		while(n<=N) {
			
			//목표배열의 인덱스와 같으면 팝 + 리스트(n++) + 빌더에 넣기 
			if(!stack.isEmpty() && stack.peek() == arr[idx] ) {
				list.add(stack.pop());
				sb.append("-").append("\n");
				idx++;
			}else {
				//푸시 + 빌더에 넣기
				stack.push(n++);
				sb.append("+").append("\n");
			}
			
		}
		//나머지 다 털기
		while(!stack.isEmpty()) {
			list.add(stack.pop());
			sb.append("-").append("\n");
		}
		//비교해서 같으면 출력 틀리면 NO출력
		boolean isSame = true;
		for(int i = 0; i < N; i++) {
			if(arr[i] != list.get(i)) {
				isSame= false;
				break;
			}
		}
		if(isSame) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}

}
