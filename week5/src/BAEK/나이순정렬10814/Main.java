package BAEK.나이순정렬10814;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] age = new int[N][2];
		String[][] names = new String[N][2];
		for(int i = 0; i < N; i++) {
			//삽입할 때 앞에 id값(우선순위)을 넣어 정렬
			age[i][0] = i;
			age[i][1] = sc.nextInt();
			names[i][0] = Integer.toString(i);
			names[i][1] = sc.next();
		}
		//나이순으로 배열을 나이 순으로 정렬하고 해당id에 해당하는 이름을 스트링 빌더에 넣는다.
		StringBuilder sb = new StringBuilder();
		Arrays.sort(age, (o1, o2) -> {
			//나이가 같은 경우, 우선순위 id를 기준으로 오름차순 정렬
			if(o1[1] == o2[1]) return o1[0] - o1[0];
			// 나이 기준 오름차순 정렬
			else return o1[1] - o2[1];
		});
		//sb에 넣기
		for(int i = 0; i < age.length; i++) {
			//우선순위 idx
			int idx = age[i][0];
			sb.append(age[i][1]).append(" ").append(names[idx][1]).append("\n");
		}
		System.out.println(sb);
		
	}

}
