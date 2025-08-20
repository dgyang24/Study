package BAEK.숫자의개수2577;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String sum = A*B*C + ""; //형변환
		int[] count = new int[10];
		
		for(int i = 0; i < sum.length(); i++) {
			count[sum.charAt(i)-'0']++;
		}
		
		for(int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
		

	}

}
