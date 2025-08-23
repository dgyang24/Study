package BAEK.Strfry11328;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			//문자열 a
			String a = sc.next();
			//문자열 b
			String b = sc.next();
			
			//가능 불가능?
			boolean isP = true;
			//길이 쳌 --> 다르면 isP = false
			if(a.length() != b.length()) isP = false;
			//a b를 구성하고 있는 문자열이 하나라도 다르면 Impossible
			if(isP) {
				char[] arrA = new char[a.length()];
				char[] arrB = new char[b.length()];
				for(int i = 0; i < a.length(); i++) {
					arrA[i] = a.charAt(i);
					arrB[i] = b.charAt(i);
				}
				Arrays.sort(arrA);
				Arrays.sort(arrB);
				for(int i = 0; i < arrA.length; i++) {
					if(arrA[i] != arrB[i]) {
						isP = false;
						break;
					}
				}
			}
			
			if(isP) {
				System.out.println("Possible");
			}else {
				System.out.println("Impossible");
			}
			
			
		}

	}

}
