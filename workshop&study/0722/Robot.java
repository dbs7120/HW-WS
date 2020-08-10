package com.ssafy;

import java.util.Scanner;

public class Robot {
	public static void main(String[] args) {
		// A: right
		// B: right, left
		// C: right, left, up, down

		Scanner sc = new Scanner(System.in);

		int T, N; // T: testcase, N: testsize
		char[][] map;
		int count;

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new char[N][N];
			count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					switch (map[i][j]) {

					case 'A':

						// right check
						for (int k = j + 1; k < N; k++) {
							if (j + 1 > N)
								continue;
							if (map[i][k] == 'W' || map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C')
								break;
							else {
								count++;
							}

						}
						break;

					case 'B':

						// right check

						for (int k = j + 1; k < N; k++) {
							if (j + 1 > N)
								continue;
							if (map[i][k] == 'W' || map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C')
								break;
							else {
								count++;
							}
						}

						// left check

						for (int k = j - 1; k >= 0; k--) {
							if (j - 1 < 0)
								continue;
							if (map[i][k] == 'W' || map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C')
								break;
							else {
								count++;
							}
						}

						break;

					case 'C':

						// right check

						for (int k = j + 1; k < N; k++) {
							if (j + 1 > N)
								continue;
							if (map[i][k] == 'W' || map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C')
								break;
							else {
								count++;
							}
						}

						// left check

						for (int k = j - 1; k >= 0; k--) {
							if (j - 1 < 0)
								continue;
							if (map[i][k] == 'W' || map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C')
								break;
							else {
								count++;
							}
						}

						// down check

						for (int k = i + 1; k < N; k++) {
							if (i + 1 > N)
								continue;
							if (map[k][j] == 'W' || map[k][j] == 'A' || map[k][j] == 'B' || map[k][j] == 'C')
								break;
							else {
								count++;
							}
						}

						// up check

						for (int k = i - 1; k >= 0; k--) {
							if (i - 1 < 0)
								continue;
							if (map[k][j] == 'W' || map[k][j] == 'A' || map[k][j] == 'B' || map[k][j] == 'C')
								break;
							else {
								count++;
							}
						}

						break;

					default:
						break;

					}

				}
			}
			System.out.println("#" + t + " " + count);
		}
	}

}
