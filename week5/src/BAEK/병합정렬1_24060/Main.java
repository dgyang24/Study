package BAEK.병합정렬1_24060;

import java.util.Scanner;

public class Main {
	static int K;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		cnt = 0;
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		merge_sort(A, 0, A.length-1);
		System.out.println(cnt);

	}
	static void merge_sort(int[] A, int left, int right) {
		int mid = (left + right) /2;
		if(cnt == K) cnt = A[right];
		if(left == right) return;
		
		//왼쪽 정렬
		merge_sort(A, left, mid);
		//오른쪽 정렬
		merge_sort(A, mid+1, right);
		
		//배열 병합
		merge(A,left,mid,right);
		
	}
	static void merge(int[] A, int left, int mid, int right) {
		cnt++;
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
		
	

}
