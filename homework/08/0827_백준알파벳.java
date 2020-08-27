package d0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {

	static int R, C, result = 1;
	static char[][] map;
	static boolean alphabet[] = new boolean[100]; // 첨자를 아스키코드값 바로적용(실제사용:65~90)
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		alphabet[map[0][0]] = true;
		DFS(0, 0, result);// 자신포함 하므로 카운트 1부터
		System.out.println(result);
	}

	private static void DFS(int y, int x, int cnt) {

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= R || nx >= C)
				continue;

			result = Math.max(cnt, result); // 최대값 갱신

			if (alphabet[map[ny][nx]])
				continue;
			alphabet[map[ny][nx]] = true; // 알파벳 방문체크
			DFS(ny, nx, cnt + 1);
			alphabet[map[ny][nx]] = false;

		}

	}

}
