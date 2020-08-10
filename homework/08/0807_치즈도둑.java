package d0807;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location { // 위치 좌표
	int y;
	int x;

	public Location(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class homework {

	static int[][] cheese;
	static boolean[][] visited;

	static int[] dy = { -1, 1, 0, 0 }; // 4 방위 y
	static int[] dx = { 0, 0, -1, 1 }; // 4 방위 x
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			cheese = new int[N][N];

			int minVal = Integer.MAX_VALUE;
			int maxVal = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					if (minVal > cheese[i][j])// 입력값중 최소 맛
						minVal = cheese[i][j];

					if (maxVal < cheese[i][j])// 입력값중 최대 맛
						maxVal = cheese[i][j];
				}
			}

			int ans = 1; // 최소덩어리는 1이상

			// 가장낮은영역 ~ 가장큰영역 반복(입력값최대값 이상값은 무조건 0)
			for (int h = minVal; h < maxVal; h++) {
				visited = new boolean[N][N];

				int count = 0; // 남은 지점 카운팅
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && cheese[i][j] > h) {
							bfs(i, j, h); // BFS/DFS 시작 조건: 방문X && 해당 지점 맛보다 높아야함
							// dfs(i, j, h);

							count++;
						}

					}
				}
				if (ans < count)
					ans = count;
			}
			System.out.println("#" + t + " " + ans);

		}

		sc.close();

	}

	// dfs
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
			if (cheese[ny][nx] > startH && !visited[ny][nx]) {
				dfs(ny, nx, startH);
			}

		}

	}

	// bfs
	private static void bfs(int startY, int startX, int height) {

		Queue<Location> q = new LinkedList<Location>();

		if (cheese[startY][startX] > height) {
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
					if (cheese[ny][nx] > height) {
						q.offer(new Location(ny, nx));
						visited[ny][nx] = true;
					}

				}
			}
		}

	}

}
