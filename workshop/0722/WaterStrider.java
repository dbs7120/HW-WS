package com.ssafy;

import java.util.Scanner;

public class Sam2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T, N; // T: testcase, N: testsize
		int[][] map;
		int bugs;
		int answer = 0;

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			map = new int[N][N];
			bugs = sc.nextInt();
			answer = 0;

			int[][] bug = new int[bugs][3];

			for (int k = 0; k < bugs; k++) {
				bug[k][0] = sc.nextInt();
				bug[k][1] = sc.nextInt();
				bug[k][2] = sc.nextInt();
			}

			int k = 0;

			for (k = 0; k < bugs; k++) {
				int pi = bug[k][0];
				int pj = bug[k][1];
				int way = bug[k][2];

				if (pi >= 0 && pi < N && pj >= 0 && pj < N) { // 범위체크

					if (map[pi][pj] == 1)
						break;

					map[pi][pj] = 1;

					if (way == 1) {

						boolean isBreak = false;
						for (int x = 3; x >= 1; x--) {
							pi = pi + x;
							if (pi < N) {
								if (map[pi][pj] == 1) {
									isBreak = true;
									break;
								}
								map[pi][pj] = 1;
							}
						}
						if (isBreak)
							break;

					} else {

						boolean isBreak = false;
						for (int x = 3; x >= 1; x--) {
							pj = pj + x;
							if (pj < N) {
								if (map[pi][pj] == 1) {
									isBreak = true;
									break;
								}
								map[pi][pj] = 1;
							}
						}

						if (isBreak)
							break;
					}
				}
			}

			if (k < bugs)
				answer = k + 1;

			System.out.println("#" + t + " " + answer);

		}

	}

}
