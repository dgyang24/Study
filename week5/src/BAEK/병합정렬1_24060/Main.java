package BAEK.병합정렬1_24060;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int K;
	static int cnt;
	static int ans;
	static int[] arr;
	static int[] tmp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		cnt = 0;
		ans = 0;
		arr = new int[N];
		tmp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(0, N-1);
		if(cnt < K) System.out.println(-1);
		else System.out.println(ans);
		
//		System.out.println(Arrays.toString(arr));

	}
	static void mergeSort(int left, int right) {
		
		//left , right가 교차되지 않았을 때
		if(left < right) {
			int mid = (left+right) / 2;
			mergeSort(left, mid); //왼쪽 부분 분할
			mergeSort(mid+1, right); // 오른쪽 부분 분할
			
			//병합
			merge(left, mid, right);
		}
		
	}
	static void merge(int left, int mid, int right) {
		//각 구간의 시작점
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		//왼쪽 오른쪽 교차 비교할 건데 둘 중 하나라도 범위 벗어나면 그만
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R]) tmp[idx++] = arr[L++];
			else tmp[idx++] = arr[R++];
			
		}//한 구간 끝
		//나머지 구간 털기
		if(L <= mid) {
			for(int i = L; i <=mid; i++) {
				tmp[idx++] = arr[i];
			}
		}else {
			for(int i = R; i<=right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		//원본에 덮기
		for(int i = left; i <= right; i++) {
			cnt++;
			arr[i] = tmp[i];
//			System.out.println(Arrays.toString(arr));
//			System.out.println(tmp[i]);
			if(cnt == K) ans = tmp[i];
			
			
		}
		
		
	}
		
	

}
