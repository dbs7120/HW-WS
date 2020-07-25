package com.ssafy;

import java.util.Scanner;

public class BuildingTest_1 {

	static int result;
	static int N;
	static char[][] map;

	static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			result = 0;
			N = sc.nextInt();
			map = new char[N][N];

			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}

			// 처리

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					if (map[i][j] == 'B') {

					// 주변탐색(8방위탐색)
					boolean flag = false; 								// 외부 판단 플래그
						for (int d = 0; d < 8; d++) {
							int nx = j + dx[d];
							int ny = i + dy[d];

							if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 범위체크
								continue;
							}
							if (map[ny][nx] == 'G') {
								flag = true;
								break;
							}
						}
						if (flag) { // 건축할 수 없다면
							continue;
						}

						// 건축가능일경우 B의개수 카운트 (4방위탐색)
						for (int d = 0; d < 4; d++) {
							int nx = j;
							int ny = i;
							while (true) {
								nx = nx + dx[d];
								ny = ny + dy[d];
								if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
									break;
								}
								if (map[ny][nx] == 'G')
									continue;
								cnt++;
							}
						}
					}
					if (result < cnt) {
						result = cnt;
					}
				}
			}

			// 출력
			System.out.println("#" + t + " " + (result + 1));
		}
	}
}
