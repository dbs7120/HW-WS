import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서_DFS {
	static int N, M, map[][], rmap[][]; // 학생수, 관계수, 관계인접행렬, rotate-관계인접행렬
	static int cnt;
	static int result;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			map = new int[N + 1][N + 1];
			rmap = new int[N + 1][N + 1];

			result = 0;

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				rmap[end][start] = map[start][end] = 1;
			}
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				DFS(i, map, new boolean[N + 1]); // 정방향 관계 인접행렬
				DFS(i, rmap, new boolean[N + 1]);// 회전된 관계인접행렬 (반대방향 관계)

				if (cnt == N - 1)
					result++;
			}

			System.out.println("#" + t + " " + result);
		}

	}

	public static void DFS(int k, int[][] map, boolean[] visited) {
		visited[k] = true;
		for (int i = 1; i <= N; i++) {
			if (map[k][i] == 1 && !visited[i]) {
				cnt++;
				DFS(i, map, visited);
			}
		}
	}

}
