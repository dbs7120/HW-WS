package d0729;

import java.util.Scanner;

public class workshop2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N]; // 농장 구역 가치 map
			String temp;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				temp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}

			// 4부분 나누기

			for (int i = 0; i < N / 2; i++) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					sum1 += map[i][j];
				}
			}

			for (int i = N / 2; i >= 0; i--) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					sum2 += map[N - i - 1][j];
				}
			}

			System.out.println("#" + t + " " + sum);
		}

		sc.close();

	}

}
