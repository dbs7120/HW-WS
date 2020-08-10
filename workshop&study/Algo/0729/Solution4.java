package d0729;

import java.util.Scanner;

public class Solution4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(digitNum(12345, 0));

		System.out.println(doStringComma("korea", ""));

		for (int i = 1; i <= 10; i++) {
			System.out.println(fibo(i));
		}

		doMakeBinary(3, "");

		System.out.println(fact(4));

		sc.close();

	}

	// 자연수를 넣어 그 각자리수의 합을 반환하는 재귀
	static int digitNum(int number, int sum) {
		if (number == 0) {
			return sum;
		}

		int a = number / 10;
		int b = number % 10;
		sum = sum + b;

		return digitNum(a, sum);

	}

	// 팩토리얼
	static int fact(int num) {
		if (num == 0) { // 0! 처리
			return 1;
		}
		if (num == 1) {
			return 1;
		}
		return num * fact(num - 1);
	}

	// 문자열 사이 콤마찍기
	static String doStringComma(String str, String result) {
		if (str.length() == 0) {
			result = result.substring(0, result.length() - 1);
			return result;
		}
		return doStringComma(str.substring(1), result + str.charAt(0) + ",");
	}

	// 피보나치수열
	static int fibo(int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		int sum = fibo(num - 2) + fibo(num - 1);

		return sum;
	}

	// 2진법 num자리만큼 모두출력
	static void doMakeBinary(int num, String result) {
		if (num == 0) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < 2; i++) {
			doMakeBinary(num - 1, result + i);
		}

	}

}
