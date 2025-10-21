package BAEK.트럭13335;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Truck {
		int W;

		public Truck(int w) {
			W = w;
		}
		
		
	}
	
	static int N,W,L;
	static int[] bridge;
	static Queue<Truck> waiting, end;
	static int ans;
	static int currentWeight; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = 0;
		N = sc.nextInt(); //트럭개수
		W = sc.nextInt(); //다리길이
		L = sc.nextInt(); //최대하중
		currentWeight = 0; //현재 다리 총 무게
		bridge = new int[W];
		waiting = new LinkedList<>();
		end = new LinkedList<>();
		//트럭 넣기
		for(int i = 0; i < N; i++) {
			waiting.add(new Truck(sc.nextInt()));
		}
		//초기화 끝
		while(end.size() < N) {
	        ans++;
	        // 1. 다리 맨 끝 트럭이 있으면 건널거야~
	        if (bridge[W-1] != 0) {
	            end.add(new Truck(bridge[W-1]));
	            currentWeight -= bridge[W-1];
	        }
	        
	        // 2. 다리 위에 있는 트럭 앞으로 밀착
	        for(int i = W-1; i > 0; i--) {
	            bridge[i] = bridge[i-1];
	        }
	        
	        // 3. 새 트럭 넣을까 말까~
	        int addTruckWeight = 0; 
	        //기다리는 트럭이 있으면~
	        if(!waiting.isEmpty()) {
	            int nextTruckW = waiting.peek().W;
	            
	            //현재 무게 + 다음 들어갈 무게 <= 최대 중량이면 넣어
	            if (currentWeight + nextTruckW <= L) { 
	                addTruckWeight = waiting.poll().W;
	            }
	        }
	        
	        // 다리 첫 공간 갱신
	        bridge[0] = addTruckWeight;
	        //무게도 갱신
	        currentWeight += addTruckWeight; 

	    }
		System.out.println(ans);
		
		

	}//main

	

}
