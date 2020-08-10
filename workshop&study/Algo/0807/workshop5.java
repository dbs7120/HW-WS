package d0807;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class workshop5 {

	static class Location {
		int y;
		int x;

		public Location(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static int N;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int safeZone = 1; // 물의 높이가 0인경우가 존재함=> 최소 한구역 이상존재
		int minH = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (minH > map[i][j]) // 입력값중 최소 건물
					minH = map[i][j];
				if (maxH < map[i][j]) // 입력값중 최대 건물
					maxH = map[i][j];
			}
		}

		// 가장낮은영역 ~ 가장큰영역 반복(입력값최대값 이상값은 무조건 0)
		for (int h = minH; h < maxH; h++) {

			visited = new boolean[N][N]; // 물 차오를때 마다 방문은 새로생성
			int count = 0; // 물보다 높은 지점 높이 갯수 카운팅

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) { // BFS시작 조건: 방문X && 해당 지점 물보다 높아야함
						// bfs(i, j, h);
						dfs(i, j, h);
						count++;
					}

				}
			}

			if (count > safeZone) {
				safeZone = count;
			}

		}
		System.out.println(safeZone);
		sc.close();

	}

	private static void dfs(int startY, int startX, int startH) {
		if (visited[startY][startX]) {
			return;
		}

		visited[startY][startX] = true;

		for (int d = 0; d < 4; d++) {
			int ny = startY + dy[d];
			int nx = startX + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				continue;
			}
			if (map[ny][nx] > startH && !visited[ny][nx]) {
				dfs(ny, nx, startH);
			}

		}

	}

	private static void bfs(int startY, int startX, int startH) {
		Queue<Location> q = new LinkedList<Location>();
		q.offer(new Location(startY, startX));
		visited[startY][startX] = true;

		while (!q.isEmpty()) {
			Location temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					continue;
				}

				if (visited[ny][nx])
					continue;

				if (map[ny][nx] > startH) {
					q.offer(new Location(ny, nx));
					visited[ny][nx] = true;

				}

			}

		}

	}

}
