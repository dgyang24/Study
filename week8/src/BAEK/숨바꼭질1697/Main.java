package BAEK.숨바꼭질1697;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N, M;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cnt = 0;
		if(N == M) {
			System.out.println(0);
			return;
		}
		bfs(N);
		System.out.println(cnt);

	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		Set<Integer> visited = new HashSet<>();
		while(!q.isEmpty()) {
			//사이즈만큼 돌리면서 매 싸이클에 포함되어있는 숫자들에 대해
			//모든 경우의수를 비교하여 타겟과 맞으면 출력
			int size = q.size();
			cnt++;
			for(int i = 0; i < size; i++) {
				int curr = q.poll();
				//-1, +1 *2 에 대해 비교후 넣기
				int diff = curr-1;
				int add = curr+1;
				int mul = curr*2;
				if(diff == M || add == M|| mul == M)  return;
				//정답을 못찾았으면 다음싸이클 
				//음수면 안됨
				if(diff>=0 && diff <= 100000 && !visited.contains(diff)) {
					q.add(diff);
					visited.add(diff);
				}
				if(add>=0 && add <= 100000 && !visited.contains(add)) {
					q.add(add);
					visited.add(add);
				}
				if(mul>=0 && mul <= 100000 && !visited.contains(mul)) {
					q.add(mul);
					visited.add(mul);
				}
			}
			
			
		}//while
		
		
	}

}
