package d0825;

import java.util.Scanner;

// BOJ1074 Z

public class homework {

	static int N, R, C;
	static int count = 0;
	static int length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		length = 1 << N; // 찾게되는 배열의 크기는 2^N

		recur(0, 0, length);

//
//		int[][] map = new int[length][length];
//		for (int i = 0; i < length; i++) {
//			for (int j = 0; j < length; j++) {
//				if (j % 2 == 0 && i % 2 == 0)
//					map[i][j] = 4 * i + 2 * j;
//				else if (j % 2 == 1 && i % 2 == 0)
//					map[i][j] = 4 * i + 2 * j - 1;
//				else if (j % 2 == 0 && i % 2 == 1) {
//					map[i][j] = 4 * i - 1 + 2 * j - 1;
//				} else {
//					map[i][j] = (4 * i - 1) + (2 * j - 2);
//				}
//			}
//		}
//		for (int[] e : map) {
//			for (int f : e) {
//				System.out.print(f + " ");
//			}
//			System.out.println();
//		}

		sc.close();

	}

	public static void recur(int x, int y, int size) {

		if (size == 1) {
			if (x == R && y == C) {
				System.out.println(count); // 종료조건 체크
			}
			count++;
			return;
		}

		// 2*2 모양으로 계속 분할
		recur(x, y, size / 2); // 1사분면 방향 진행
		recur(x, y + size / 2, size / 2); // 2사분면 방향 진행
		recur(x + size / 2, y, size / 2); // 3사분면 방향 진행
		recur(x + size / 2, y + size / 2, size / 2); // 4사분면 방향 진행
	}

}