package BAEK.OX퀴즈8958;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc <T; tc++) {
			int sum = 0;
			int cnt = 1;
			String str = sc.next();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == 'O') {
					sum += cnt;
					cnt++;
				}else {
					cnt = 1;
				}
			}
			System.out.println(sum);
		}
		

	}

}
