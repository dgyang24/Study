package BAEK.나는야_포켓몬마스터_이다솜1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, String> map = new HashMap<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++)
			map.put(i, sc.next());
		for(int i = 0 ; i < M; i++) {
			//다음 입력값이 숫자일때
			if(sc.hasNextInt()) {
				sb.append(map.get(sc.nextInt())+"\n");
			}else {
				String str = sc.next();
				for(int key : map.keySet()) {
					if(map.get(key).equals(str)) {
						sb.append(key+"\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}

}
