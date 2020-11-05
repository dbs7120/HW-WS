import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_BFS {
	static int N, M, map[][]; // 학생수, 관계수
	static int gtCnt, ltCnt;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			map = new int[N + 1][N + 1];
			result = 0;

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[start][end] = 1;
			}
			for (int i = 1; i <= N; i++) {
				gtCnt = ltCnt = 0;
				gtBFS(i);
				ltBFS(i);
				if (gtCnt + ltCnt == N - 1) {
					result++;
				}
			}

			System.out.println("#" + t + " " + result);
		}

	}

	// 자신보다 큰 학생 탐색
	public static void gtBFS(int start) { // start: 탐색의 출발 학생 번호
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N + 1];
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[cur][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					gtCnt++;
				}
			}
		}
	}

	// 자신보다 작은 학생 탐색
	public static void ltBFS(int start) { // start: 탐색의 출발 학생 번호
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N + 1];
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[i][cur] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					ltCnt++;
				}
			}
		}
	}
}
