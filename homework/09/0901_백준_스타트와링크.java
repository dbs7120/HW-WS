package d0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// boj 14889 스타트와 링크
public class homework {

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

		DFS(0, 0);

		System.out.println(result);

	}

	private static void DFS(int cnt, int idx) {

		if (idx == N / 2) {

			ArrayList<Integer> startTeam = new ArrayList<Integer>();
			ArrayList<Integer> linkTeam = new ArrayList<Integer>();

			// 팀나누기
			for (int i = 0; i < N; i++) {
				if (visited[i])
					startTeam.add(i);
				else
					linkTeam.add(i);
			}

			// 능력치 계산
			int start = 0, link = 0;
			for (int i = 0; i < startTeam.size(); i++) {
				for (int j = i; j < linkTeam.size(); j++) {
					start += map[startTeam.get(i)][startTeam.get(j)] + map[startTeam.get(j)][startTeam.get(i)];
					link += map[linkTeam.get(i)][linkTeam.get(j)] + map[linkTeam.get(j)][linkTeam.get(i)];
				}
			}

			// 최소갱신
			result = Math.min(result, Math.abs(start - link));
			return;
		}

		// 조합
		for (int i = cnt; i < N; i++) {
			visited[i] = true;
			DFS(i + 1, idx + 1);
			visited[i] = false;
		}
	}

}
