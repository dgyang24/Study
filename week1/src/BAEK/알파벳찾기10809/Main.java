package BAEK.알파벳찾기10809;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] abc = new int[26];
		//배열 초기화
		for(int i = 0; i < abc.length; i++)
			abc[i] = -1;
		//알파벳 찾기
		for(int i = 0; i < str.length(); i++) {
			//값이 들어있는지 확인
			if(abc[str.charAt(i)-'a'] == -1) {
				abc[str.charAt(i)-'a'] = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < abc.length; i++)
			sb.append(abc[i]).append(" ");
		System.out.println(sb);
	}

}
