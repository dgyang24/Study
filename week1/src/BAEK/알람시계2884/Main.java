package BAEK.알람시계2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt()-45;
		if((min) < 0) {
			hour-=1;
			min += 60;
		}
		if(hour < 0)
			hour+=24;
		System.out.println(hour + " " + min);
		

	}

}
