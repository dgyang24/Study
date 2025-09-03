package BAEK.풍선터뜨리기2346;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//풍선 리스트 초기화
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		//풍선 터트리는 순서 
		List<Integer> ans = new ArrayList<>();
		ans.add(1);
		//풍선터트리기 시작!
		//폭발물로부터 어느정도 떨어져 있는지
		int cnt = 0;
		//첫순서는 무조건 1번 풍선 터트릴거야.
		cnt = arr[0]; //다음 풍선은 어디로 이동할건지 초기값은 1번풍
		arr[0] = 0;
		int idx = 0; //순회 인덱스 
		int move = 0;//이동거리
		//ans 사이즈가 N이 아닐동안 ㄱㄱ
		while(true) {
			if(arr[idx] != 0) {
				move++;
				//풍선 터트리기
				if(move == Math.abs(cnt)) {
					ans.add(idx+1);
					cnt = arr[idx];
					arr[idx] = 0;
					move = 0;
				}
			}
			//음수 양수 처리
			if(cnt >= 0) {
				idx =(idx+1)%N;
			}else if (cnt < 0) {
				idx = (idx - 1)%N;
				//-1로 넘어가면 다시 뒤로 돌아가야됨
				if(idx < 0) idx = N-1;
			}
			if(ans.size() == N) break;
		}//풍선터트리기 끝
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < ans.size(); k++)
			sb.append(ans.get(k)).append(" ");
		//출력
		System.out.println(sb);
	}

}
