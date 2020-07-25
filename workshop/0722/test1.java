package com.ssafy;

public class test1 {

	public static void main(String[] args) {
		int N = 3;
		int[][] map = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] dy = { 0, 0, -1, 1 };
		int[] dx = { -1, 1, 0, 0 };

		// 대각선 포함
		//int[] dy = { -1, -1, 1, 1, 0, 0, -1, 1 };
		//int[] dx = { -1, 1, -1, 1 - 1, 1, 0, 0 };

		// 중앙점
		int x = 1;
		int y = 1;

//		// 상하좌우의 합 구하기
//		int left = map[y][x-1];		// map[y + 0][x - 1];
//		int right = map[y][x+1];	// map[y + 0][x + 1];
//		int up = map[y-1][x];		// map[y - 1][x + 0];
//		int down = map[y+1][x];		// map[y + 1][x + 0];
//
//		int sum = left + right + up + down;
//		System.out.println(sum);

//		==>

		int sum = 0;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 새로운 좌표가 범위를 벗어나면 무시하기 (0<= x <N)
				continue;
			}
			sum += map[ny][nx];

		}
		System.out.println(sum);

	}

}
