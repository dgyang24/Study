package BAEK.나는야_포켓몬마스터_이다솜1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//숫자 ->포켓몬
		Map<Integer, String> map = new HashMap<>();
		//포켓몬 -> 숫자
		Map<String, Integer> map2 = new HashMap<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			String str = sc.next();
			map.put(i, str);
			map2.put(str, i);
		}
			
		for(int i = 0 ; i < M; i++) {
			//다음 입력값이 숫자일때
			if(sc.hasNextInt()) {
				sb.append(map.get(sc.nextInt())+"\n");
			}else {
				sb.append(map2.get(sc.next())+"\n");
			}
		}
		System.out.println(sb);
	}

}
