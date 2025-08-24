package BAEK.방번호1475;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i <=8; i++) {
			map.put((char) (i + '0'), 0);
		}
		// 각 숫자 개수세기
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '9')
				c = '6';
			int n = map.get(c)+1;

			map.put(c, n);
		}
		// 6,과 9는 반띵
		map.put('6', (int) Math.round(map.get('6') / 2.0));
		System.out.println(Collections.max(map.values()));
	}

}
