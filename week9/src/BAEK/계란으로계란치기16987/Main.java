package BAEK.계란으로계란치기16987;

import java.util.Scanner;

public class Main {
	static class Egg {
		int S,W;

		public Egg(int s, int w) {
			S = s;
			W = w;
		}
	}
	static int N;
	static Egg[] eggs;
	static int ans,cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N == 1) {
			System.out.println(0);
			return;
		}
		eggs = new Egg[N];
		for(int i = 0; i < N; i++) {
			eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
		}
		ans = 0;
		cnt = 0;
		//초기화 끝
		dfs(0);
		System.out.println(ans);
		
	}
	static void dfs(int curr) {
		//기저 : curr = N
		if(curr == N) {
			cnt = 0;
			for(int i = 0; i < N; i++) {
				if(eggs[i].S <= 0) cnt++;
			}
			
			ans = Math.max(ans, cnt);
			return;
		}
		//내가 들고 있는 계란의 내구도가 0이하면 다음 계란으로 넘어가
		if(eggs[curr].S <= 0) {
			dfs(curr+1);
			return;
		}
		
		boolean canHit = false; 
		
		//재귀
		for(int i = 0; i < N; i++) {
			//내 자신 혹은 칠 계란의 내구도가 0이하면 넘어가
			if(curr == i || eggs[i].S <= 0) continue;
			canHit = true;
			//이제 깨뜨릴거야
			eggs[curr].S -= eggs[i].W;
			eggs[i].S -= eggs[curr].W;
			
			dfs(curr+1);
			
			//원상복구
			eggs[curr].S += eggs[i].W;
			eggs[i].S += eggs[curr].W;	
		}
		//못깼으면 넘어가
		if(!canHit) {
			dfs(curr+1);
		}
		
	}
}
