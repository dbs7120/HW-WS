package d0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정올 해밀턴 순환회로
public class HomeWork {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true; // 자신은 미리 체크하고 시작함
		DFS(0, 1, 0); // 자신의 다음 층(깊이)부터 시작함
		System.out.println(result);

	}

	public static void DFS(int cur, int cnt, int sum) {

		if (cnt == N) { // 모두 순회
			if (map[cur][0] == 0) // 모두순회 했는데 집으로 가능 경로 없을시 종료
				return;
			sum += map[cur][0]; // 경로 누적
			result = Math.min(result, sum); // 재귀로 누적된 sum값의 최솟값일때 갱신
			return;
		}

		for (int i = 0; i < N; i++) {
			if (map[cur][i] == 0 || visited[i]) // 방문, 미연결 은 제외
				continue;
			if (sum + map[cur][i] > result) // 가망성없는곳 미리 제외
				continue;
			visited[i] = true;
			DFS(i, cnt + 1, sum + map[cur][i]);
			visited[i] = false;
		}

	}

}
