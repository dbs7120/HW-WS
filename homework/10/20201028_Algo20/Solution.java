package d1028;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 활주로 건설
public class Solution {
	static int N, X, map[][];
	static boolean check[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bw.append("#" + t + " " + String.valueOf(garo() + sero()) + "\n");
		}
		bw.flush();
		bw.close();

	}

	// 가로방향
	public static int garo() {

		int num = 0;
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < N - 1; j++) {
				int diff = map[i][j] - map[i][j + 1];
				if (diff == 0) // 같은높이 pass
					continue;

				if (Math.abs(diff) > 1) { // 높이차가 1이면 건설불가 라인
					flag = false;
					break;
				}

				if (diff > 0) { // 앞뒤의 차이가 앞이 더클때
					if (j + X >= N) { // 범위 넘어가면 건설 X
						flag = false;
						break;
					}

					for (int k = j + 1; k < j + X; k++) { // 높이차이 체크
						if (map[i][k] != map[i][k + 1]) {
							flag = false;
							break;
						}
					}

					for (int k = j + 1; k < j + 1 + X; k++) { // 방문 체크
						if (check[i][k]) {
							flag = false;
							break;
						} else
							check[i][k] = true;
					}

				} else { // 뒤가 더클때
					if (j + 1 - X < 0) {// 범위 넘어가면 건설 X
						flag = false;
						break;
					}

					for (int k = j; k > j + 1 - X; k--) { // 높이차이 체크
						if (map[i][k] != map[i][k - 1]) {
							flag = false;
							break;
						}
					}

					for (int k = j; k > j - X; k--) { // 방문 체크
						if (check[i][k]) {
							flag = false;
							break;
						} else
							check[i][k] = true;
					}
				}
				if (!flag)
					break;
			}
			if (flag)
				num++;
		}
		return num;
	}

	public static int sero() {
		int num = 0;
		// 세로방향

		check = new boolean[N][N];
		for (int j = 0; j < N; j++) {
			boolean flag = true;
			for (int i = 0; i < N - 1; i++) {
				int diff = map[i][j] - map[i + 1][j];

				if (diff == 0) // 같은높이 pass
					continue;

				if (Math.abs(diff) > 1) { // 높이차가 1이면 건설불가 라인
					flag = false;
					break;
				}

				if (diff > 0) { // 앞뒤의 차이가 앞이 더클때
					if (i + X >= N) { // 범위 넘어가면 건설 X
						flag = false;
						break;
					}

					for (int k = i + 1; k < i + X; k++) { // 높이차이 체크
						if (map[k][j] != map[k + 1][j]) {
							flag = false;
							break;
						}
					}

					for (int k = i + 1; k <= i + X; k++) { // 방문 체크
						if (check[k][j]) {
							flag = false;
							break;
						} else
							check[k][j] = true;
					}

				} else { // 뒤가 더클때
					if (i + 1 - X < 0) { // 범위 넘어가면 건설 X
						flag = false;
						break;
					}
					for (int k = i - 1; k > i - X; k--) { // 높이차이 체크
						if (map[i][j] != map[k][j]) {
							flag = false;
							break;
						}
					}

					for (int k = i - 1; k > i - X; k--) { // 방문 체크
						if (check[k][j]) {
							flag = false;
							break;
						} else
							check[k][j] = true;
					}

				}
				if (!flag)
					break;
			}
			if (flag)
				num++;
		}
		return num;
	}

}