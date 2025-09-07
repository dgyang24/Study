package BAEK.국영수10825;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 학생관리배열
		String[][] students = new String[N][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				students[i][j] = sc.next();
			}
		} // 학생 입력 끝
			// 정렬
		Arrays.sort(students, (o1, o2) -> {

			// 0. 국,영,수 모두 같으면 이름 기준 오름차순
			if (o1[1].equals(o2[1]) && o1[2].equals(o2[2]) && o1[3].equals(o2[3])) {
				return o1[0].compareTo(o2[0]);
			}
			// 1. 국어, 영어 점수가 같으면 수학점수 기준 내림차순
			else if (o1[1].equals(o2[1]) && o1[2].equals(o2[2])) {
				return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
			}
			// 2. 국어점수만 같으면 영어점수 오름차순
			else if (o1[1].equals(o2[1])) {
				return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
			}
			// 3. 국어 기준 내림차
			else {
				return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
			}

		});
		// 출력
		for (int i = 0; i < students.length; i++)
			System.out.println(students[i][0]);

	}

}
