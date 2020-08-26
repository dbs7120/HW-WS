package d0826;

import java.util.Scanner;

public class Main {

	static int[][] map = new int[19][19]; // 1: 흑 / 2: 백 / 0 : 빈공간
	static int[] dy = { 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 0) // 빈공간 스킵
					continue;
				for (int d = 0; d < 4; d++) {

					int py = i - dy[d]; // previous y
					int px = j - dx[d]; // previous x

					if (!(py < 0 || px < 0 || py >= 19 || px >= 19)) { // 경계체킹(범위넘어서지않을시)
						if (map[py][px] == map[i][j]) // 현재값과 그전값(previous) 비교시 같다면 스킵(6목 방지)
							continue;
					}

					int ny = i;
					int nx = j;
					int cnt = 1; // 카운터 1로시작(자신포함)

					while (true) {
						ny += dy[d];
						nx += dx[d];
						if (ny < 0 || nx < 0 || ny >= 19 || nx >= 19)
							break;
						if (map[ny][nx] != map[i][j]) // 현재값 다음값 비교하여 같은값 아니면 루프 종료
							break;
						cnt++;
					}

					if (cnt == 5) {
						System.out.println(map[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						sc.close();
						return; // main 종료
					}

				}
			}
		}

		System.out.println(0); // 5목 X

		sc.close();

	}

}
