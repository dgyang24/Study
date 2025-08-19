package BAEK.평균은넘겠지4344;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();//학생 수
			int[] score = new int[N];
			int sum = 0;
			//배열 생성
			for(int i = 0; i < N; i++) {
				int s = sc.nextInt();
				score[i] = s;
				sum += s;
			}
			double avg = sum / (double) N;
			int topS = 0; //평균을 넘는 학생 수
			for(int i = 0; i < N; i++) {
				if(score[i] > avg)
					topS++;
			}
			double result = (topS/(double)N)*100 ;
			System.out.println(Math.round(result*Math.pow(10, 3))/(double) Math.pow(10, 3)+"%");
			
		}

	}

}
