package BAEK.듣보잡1764;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<String> notHear = new HashSet<>();
		for(int i = 0; i< N; i++)
			notHear.add(sc.next());
		List<String> map = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String s = sc.next();
			if(notHear.contains(s))
				map.add(s);
		}
		Collections.sort(map);
		System.out.println(map.size());
		for(int i = 0; i < map.size(); i++)
			System.out.println(map.get(i));
	}

}
