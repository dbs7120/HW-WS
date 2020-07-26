package com.ssafy.pratice;

import java.util.Scanner;

public class Strider {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int[][] strider = new int[S][3];
			int[][] map = new int[N][N];
			int answer = 0;
			boolean check = false;

			for (int i = 0; i < strider.length; i++) {
				strider[i][0] = sc.nextInt(); // y
				strider[i][1] = sc.nextInt(); // x
				strider[i][2] = sc.nextInt(); // dir
			}

			for (int i = 0; i < S; i++) {
				int py = strider[i][0];
				int px = strider[i][1];
				int dir = strider[i][2];

				map[py][px] = 1;

				if (dir == 2) { // right(2)
					for (int j = 3; j > 0; j--) {
						px = px + j;
						if (px < N) {
							if (map[py][px] == 1) {
								answer = i;
								check = true;
								break;
							}
							map[py][px - j] = 1;
						}

					}
				} else { // down(1)
					for (int j = 3; j > 0; j--) {
						py = py + j;
						if (py < N) {
							if (map[py][px] == 1) {
								answer = i;
								check = true;
								break;
							}
							map[py - j][px] = 1;
						}
					}

				}
				if (check)	// 찾을경우 해당 테스트 케이스 바로종료
					break;

			}

			if (check) {
				System.out.println("#" + t + " " + (answer + 1));
			} else
				System.out.println("#" + t + " " + answer);

		}
		sc.close();
	}

}
