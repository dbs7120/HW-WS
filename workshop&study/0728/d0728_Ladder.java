package d0728;

import java.util.Scanner;
import java.io.FileInputStream;

public class d0728_Ladder {
	static int N = 100;
	static int[][] map = new int[N][N];

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();
			int x = 0, y = 0;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) {
						y = i; // 2값 y index
						x = j; // 2값 i index
					}
				}
			}

			while (true) {
				y--; // 사다리 올라가기

				if (y < 0) // 종료조건(꼭대기)
					break;

				if (x > 0 && map[y][x - 1] == 1) { // 왼쪽에 1이 있을때, 제일 좌측일때 체크

					while (true) {
						x--;
						if (x > 0 && map[y][x - 1] == 1) // 왼쪽에 1이나오면 계속 왼쪽으로, 제일 좌측일때 체크
							continue;
						else
							break;

					}
				} else if (x < N-1 && map[y][x + 1] == 1) { // 오른쪽에 1이 있을때, 제일 우측일때 체크
					while (true) {
						x++;
						if (x < N-1 && map[y][x + 1] == 1) // 오른쪽에에 1이나오면 계속 왼쪽으로, 제일 우측일때 체크
							continue;
						else
							break;
					}
				}
			}
			System.out.println("#" + t + " " + x);

		}
		sc.close();

	}

}
