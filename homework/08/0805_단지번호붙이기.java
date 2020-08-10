import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 단지번호붙이기
class Point {
	int y;
	int x;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class BOJ2667 {

	// 1: 집O
	// 0: 집X
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N;
	static ArrayList<Integer> resultCnt = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		sc.nextLine();

		String str = "";
		for (int i = 0; i < N; i++) {
			str = sc.next();
			for (int j = 0; j < N; j++) {
				int temp = str.charAt(j) - '0'; // 문자로 한글자 읽고 -'0' 빼기 (아스키코드값)
				map[i][j] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bfs(i, j);
			}
		}
		System.out.println(resultCnt.size());	// 단지수 출력

		Collections.sort(resultCnt); // 정렬하기

		for (int e : resultCnt) {
			System.out.println(e);
		}

		sc.close();

	}

	private static void bfs(int startY, int startX) {
		Queue<Point> q = new LinkedList<Point>();

		if (map[startY][startX] == 1) {

			map[startY][startX] = 0;
			q.offer(new Point(startY, startX));
			int count = 1;

			while (!q.isEmpty()) {

				Point temp = q.poll();

				for (int d = 0; d < 4; d++) { // 4방위 탐색하기
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;

					if (map[ny][nx] == 1) {
						q.offer(new Point(ny, nx));
						count++;
						map[ny][nx] = 0;

					}

				}

			}
			resultCnt.add(count);
		}

	}

}
