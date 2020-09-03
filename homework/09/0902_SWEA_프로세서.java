package d0902;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HomeWork {
	static int map[][], N, max, min, totalCnt;
	static ArrayList<Loc> list;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	static class Loc {
		int y;
		int x;

		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			list = new ArrayList<Loc>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if ((i == 0 || j == 0 || i == N - 1 || j == N - 1) && map[i][j] == 1) {
						continue;
					}
					if (map[i][j] == 1) {
						list.add(new Loc(i, j));
						totalCnt++;
					}
				}
			}
			powerSet(0, 0, 0);
			bw.write("#" + t + " " + min + "\n");

		}
		bw.flush();
		bw.close();
	}

	private static void powerSet(int index, int coreCnt, int len) {

		// 현재까지 연결된 코어수 + 앞으로 처리해야할 남은 코어수 = 기대할 수 있는 최대 코어 수
		// 기대할 수 있는 최대코어수가 임시해보다 작다면 진행이 의미 없음
		if (coreCnt + (totalCnt - index) < max) // 가지치기
			return;

		if (index == totalCnt) {
			if (max < coreCnt) {
				max = coreCnt;
				min = len;
			} else if (max == coreCnt) {
				if (min > len) {
					min = len;
				}
			}

			return;
		}

		Loc cur = list.get(index);
		int y = cur.y;
		int x = cur.x;

		for (int d = 0; d < 4; d++) {

			if (isAvailable(y, x, d)) {

				int curLen = setStatus(y, x, d, 2);
				powerSet(index + 1, coreCnt + 1, len + curLen);

				setStatus(y, x, d, 0);

			}

		}

		powerSet(index + 1, coreCnt, len);
	}

	private static boolean isAvailable(int y, int x, int d) {
		int ny = y, nx = x;

		while (true) {
			ny += dy[d];
			nx += dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) // 가장자리까지 전선을 놓을 수 있는 상황
				break;
			if (map[ny][nx] >= 1) { // 1:코어 , 2:전선 을 만나는 상황
				return false;
			}
		}
		return true;
	}

	private static int setStatus(int y, int x, int d, int status) {
		int ny = y, nx = x;
		int cnt = 0;

		while (true) {
			ny += dy[d];
			nx += dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) // 가장자리까지 전선을 놓을 수 있는 상황
				break;
			map[ny][nx] = status;
			cnt++;
		}
		return cnt;
	}

}
