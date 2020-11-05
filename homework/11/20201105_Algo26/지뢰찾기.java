import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 지뢰찾기 {

	static int N, map[][];
	static int dy[] = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int dx[] = { 0, 0, -1, 1, 1, -1, -1, 1 };
	static boolean visited[][];
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			visited = new boolean[N][N];
			cnt = 0;

			for (int i = 0; i < N; i++) {
				String st = br.readLine();
				for (int j = 0; j < N; j++) {
					char temp = st.charAt(j);
					if (temp == '*') {
						map[i][j] = -1;
					} else
						map[i][j] = 0;
				}
			}

			fill();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0 && !visited[i][j]) {
						cnt++;
						visited[i][j] = true;
						DFS(i, j); // 0 일때 주변 0탐색
					}
				}
			}

//			for(boolean[] e : visited) {
//				for(boolean f : e) {
//					System.out.print(f + " ");
//				}
//				System.out.println();
//			}

			count(); // 남은 숫자 찾기

			System.out.println("#" + t + " " + (cnt));

		}
	}

	public static void DFS(int y, int x) {
		for (int d = 0; d < 8; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])
				continue;

			if (map[ny][nx] == -1)
				continue;
			visited[ny][nx] = true;
			if (map[ny][nx] == 0)
				DFS(ny, nx);
		}

	}

	// 주변 지뢰 8방위로 탐색해 맵에 채우기
	public static void fill() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {
					visited[i][j] = true;
					continue;
				}
				int num = 0;
				for (int d = 0; d < 8; d++) {

					int ny = dy[d] + i;
					int nx = dx[d] + j;
					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;
					if (map[ny][nx] == -1)
						num++;
				}
				map[i][j] = num;

			}
		}
	}

	public static void count() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//System.out.print(map[i][j] + " ");
//				if(map[i][j]>0)
//					cnt++;

				if (!visited[i][j]) // 미방문이면 남은(눌러야하는) 공간
					cnt++;
			}
			//System.out.println();
		}

	}

}
