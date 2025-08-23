package BAEK.세로읽기113103;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열생성
		char[][] arr = new char[5][15];
		StringBuilder sb = new StringBuilder();
		//입력받은 값으로 배열 생성 빈곳은 그냥 놔두기
		for(int i = 0; i < 5; i++) {
			String str = sc.next();
			for(int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		//세로 출력
		for(int j = 0; j < 15; j++) {
			for(int i = 0; i < 5; i++) {
				if(arr[i][j] == '\0') {
					continue;
				}
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb);
		

	}

}
