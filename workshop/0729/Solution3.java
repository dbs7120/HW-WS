package d0729;

import java.util.Scanner;

public class Solution3 {

	// 0 1 1 2 3 5 8 13...
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 30;
		long num = fibo1(N);
		System.out.println(String.format("반복문 피보나치 num : %d", num));

		System.out.println();

		num = fibo2(N);
		System.out.println(String.format("재귀문 피보나치 num : %d", num));

		sc.close();

	}

	// 반복문 피보나치수열
	static long fibo1(int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		long sum = 0;
		long pre1 = 0;
		long pre2 = 1;
		for (int i = 2; i <= num; i++) {
			sum = pre1 + pre2;
			pre1 = pre2;
			pre2 = sum;

		}
		return sum;
	}

	// 재귀문 피보나치
	static long fibo2(int num) {

		// 종료조건
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}

		// 실행 & 재귀호출
		long sum = fibo2(num - 2) + fibo2(num - 1);

		return sum;
	}

}
