package d0825;

import java.util.Scanner;

public class RecPowTest {

	static long X, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		N = sc.nextInt();
		System.out.println(exp(X, N));
		sc.close();

	}

	private static long exp(long x, long n) {
		if (n == 0)
			return 1;
//		if (n == 1)
//			return x;

		long result = exp(x, n / 2);
		result *= result;
		if ((n & 1) != 0) { // n: 홀수
			result *= x;
		}
		return result;
	}

}
