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
<<<<<<< HEAD
	static void merge_sort(int[] A, int left, int right) {
		
		int mid = (left + right) /2;
		
		if(left == right) return;
=======
	static void merge(int left, int mid, int right) {
		//각 구간의 시작점
		int L = left;
		int R = mid + 1;
		int idx = left;
>>>>>>> 1c5e0268a114b84657a9aeac9bde7202e7ae251b
		
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
<<<<<<< HEAD
	static void merge(int[] A, int left, int mid, int right) {
		int n1 = mid - left + 1; // 왼쪽 배열의 길이
        int n2 = right - mid; // 오른쪽 배열의 길이
		//왼쪽 오른쪽 배열
		int[] leftTmp = new int[n1];
		int[] rightTmp = new int[n2];
		
		 // 왼쪽 배열 담기
        for (int i = 0; i < n1; i++) {
        	leftTmp[i] = A[left + i];
        }
        // 오른쪽 배열 담기
        for (int i = 0; i < n2; i++) {
        	rightTmp[i] = A[mid + 1 + i];
        }

        // 왼쪽 배열과 오른쪽 배열의 인덱스
        int i = 0, j = 0;
        // 원본 배열 arr의 시작 인덱스
        int k = left;

        // 원본 배열에 정렬
        while (i < n1 && j < n2) {
            if (leftTmp[i] <= rightTmp[j]) {
                A[k] = leftTmp[i];
                i++;
            } else {
                A[k] = rightTmp[j];
                j++;
            }
            k++;
        }

        // 남아 있는 요소 담기
        while (i < n1) {
            A[k] = leftTmp[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = rightTmp[j];
            j++;
            k++;
        }
    }
=======
>>>>>>> 1c5e0268a114b84657a9aeac9bde7202e7ae251b
		
	

}
