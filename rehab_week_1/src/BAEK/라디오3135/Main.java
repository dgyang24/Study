package BAEK.라디오3135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int curr = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int diff = Math.abs(goal-curr);
		//초기화끝
		for(int i = 0; i < n; i++) {
			//즐찾 이동 1번 + 나머지 1씩이동(차이)
			int tmp_diff = 1+Math.abs(goal-arr[i]);
			
			diff = Math.min(diff, tmp_diff);
		}
		
		System.out.println(diff);
	}

}
