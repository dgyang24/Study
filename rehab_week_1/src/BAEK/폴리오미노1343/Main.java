package BAEK.폴리오미노1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		StringBuilder sb = new StringBuilder();
		//하나씩 순회
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			int cnt = 0;
			int j = i;
			//다음 글자가 X인 경우 i부터 세자
			while(j < str.length()) {
				c = str.charAt(j);
				if(c == 'X') {
					cnt++;
				}
				else break;
				j++;
			}
			
			//cnt가 홀수이면 -1출력하고 그만
			if(cnt % 2 == 1) {
				System.out.println(-1);
				return;
			}
			//cnt가 4 이상이면 A로 채울거얌
			while(cnt >= 4) {
				sb.append("AAAA");
				cnt-=4;
				i+=4;
			}
			
			//2이상이면 B
			while(cnt >= 2) {
				sb.append("BB");
				cnt -= 2;
				i+=2;
			}
			//.이면 그냥 넣어
			if(c == '.') {
				sb.append('.');
			}
		}
		System.out.println(sb);
	}
}
