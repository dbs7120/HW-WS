package d0729;

import java.util.Scanner;

// 상호의 배틀필드
public class workshop1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int H = sc.nextInt(); // 높이
			int W = sc.nextInt(); // 너비
			char[][] map = new char[H][W]; // 초기맵

			int y = 0, x = 0;

			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						y = i;
						x = j;
					}
				}
			}

			int N = sc.nextInt(); // 사용자 입력갯수
			char[] input = new char[N]; // 사용자 입력 문자열
			input = sc.next().toCharArray();

			for (int i = 0; i < N; i++) {

				if (input[i] == 'S') { // S입력시

					if (map[y][x] == '^') { // 총알방향 상
						for (int sy = y - 1; sy >= 0; sy--) {
							if (sy == -1 || map[sy][x] == '#')
								break;
							else if (map[sy][x] == '*') {
								map[sy][x] = '.';
								break;
							}
						}
					} else if (map[y][x] == 'v') { // 총알방향 하
						for (int sy = y + 1; sy <= H; sy++) {
							if (sy == H || map[sy][x] == '#')
								break;
							else if (map[sy][x] == '*') {
								map[sy][x] = '.';
								break;
							}
						}
					} else if (map[y][x] == '<') { // 총알방향 좌
						for (int sx = x - 1; sx >= 0; sx--) {
							if (sx == -1 || map[y][sx] == '#')
								break;
							else if (map[y][sx] == '*') {
								map[y][sx] = '.';
								break;
							}
						}
					} else if (map[y][x] == '>') { // 총알방향 우
						for (int sx = x + 1; sx <= W; sx++) {
							if (sx == W || map[y][sx] == '#')
								break;
							else if (map[y][sx] == '*') {
								map[y][sx] = '.';
								break;
							}
						}
					}

				} else if (input[i] == 'U') {
					map[y][x] = '^';
					if (y - 1 < 0)
						continue;
					if (map[y - 1][x] == '.') {
						map[y][x] = '.';
						map[y - 1][x] = '^';
						y--;

					}
				} else if (input[i] == 'D') {
					map[y][x] = 'v';
					if (y + 1 >= H)
						continue;
					if (map[y + 1][x] == '.') {
						map[y][x] = '.';
						map[y + 1][x] = 'v';
						y++;
					}
				} else if (input[i] == 'L') {
					map[y][x] = '<';
					if (x - 1 < 0)
						continue;
					if (map[y][x - 1] == '.') {
						map[y][x] = '.';
						map[y][x - 1] = '<';
						x--;
					}
				} else if (input[i] == 'R') {
					map[y][x] = '>';
					if (x + 1 >= W)
						continue;
					if (map[y][x + 1] == '.') {
						map[y][x] = '.';
						map[y][x + 1] = '>';
						x++;
					}
				}

			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();

	}

}
