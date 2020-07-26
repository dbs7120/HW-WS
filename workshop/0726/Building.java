package com.ssafy.pratice;

import java.util.Scanner;

public class Building {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상,하,좌,우,대각(4)
		int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상,하,좌,우,대각(4)
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];

			int height = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}

			int temp2 = 0;
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {
					int temp = 0;
					if (map[i][j] == 'B') {
						boolean flag = false;
						for (int k = 0; k < 8; k++) {
							int ny = dy[k] + i;
							int nx = dx[k] + j;

							if (nx < 0 || nx >= N || ny < 0 || ny >= N) // 좌표벗어나면무시
								continue;

							if (map[ny][nx] == 'G') {
								flag = true;
								temp2 = 2;
								break;
							}
						}

						if (flag)
							continue;

						for (int k = 0; k < 4; k++) {
							int ny = i;
							int nx = j;
							while (true) {
								ny += dy[k];
								nx += dx[k];
								if (nx < 0 || nx >= N || ny < 0 || ny >= N) // 좌표벗어나면무시
									break;
								if (map[ny][nx] == 'B')
									temp++;
							}
						}
					}

					if (height < temp) // 최대값 저장
						height = temp;

				}
				if (temp2 == 2 && height == 0) { // B가 G에 둘러싸인경우만 있을때 최대 높이는 2
					height = temp2;
				}
			}

			// 전부공원인 케이스제외 자기자신 포함하기
			if (height > 2)
				height++;

			System.out.println("#" + t + " " + height);

		}
		sc.close();

	}

}
