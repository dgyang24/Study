package BAEK.서로다른부분문자열의개수;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Set<String>set = new HashSet<>();
		
		//각 문자로 시작하는 문자열 set에 넣기
		for(int i = 0; i < str.length(); i++) {
			String tmp = "";
			for(int j = i; j < str.length(); j++) {
				tmp += str.charAt(j);
				set.add(tmp);
			}
			
		}
		System.out.println(set.size());

	}
}
