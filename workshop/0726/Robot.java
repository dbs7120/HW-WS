package com.ssafy.pratice;

import java.util.Scanner;

public class Robot {

	public static void main(String[] args) {

		// A: right, B: right, left , C: right, left, down, up
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int count = 0;
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 'A') {
						// right
						for (int k = j + 1; k < map.length; k++) {
							if (map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C' || map[i][k] == 'W')
								break;
							else
								count++;
						}

					}
					if (map[i][j] == 'B') {
						// right
						for (int k = j + 1; k < map.length; k++) {
							if (map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C' || map[i][k] == 'W')
								break;
							else
								count++;
						}
						// left
						for (int k = j - 1; k >= 0; k--) {
							if (map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C' || map[i][k] == 'W')
								break;
							else
								count++;
						}
					}

					if (map[i][j] == 'C') {
						// right
						for (int k = j + 1; k < map.length; k++) {
							if (map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C' || map[i][k] == 'W')
								break;
							else
								count++;
						}
						// left
						for (int k = j - 1; k >= 0; k--) {
							if (map[i][k] == 'A' || map[i][k] == 'B' || map[i][k] == 'C' || map[i][k] == 'W')
								break;
							else
								count++;
						}
						// up
						for (int k = i - 1; k >= 0; k--) {
							if (map[k][j] == 'A' || map[k][j] == 'B' || map[k][j] == 'C' || map[k][j] == 'W')
								break;
							else
								count++;
						}
						// down
						for (int k = i + 1; k < map.length; k++) {
							if (map[k][j] == 'A' || map[k][j] == 'B' || map[k][j] == 'C' || map[k][j] == 'W')
								break;
							else
								count++;
						}
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}
		sc.close();
	}
}
