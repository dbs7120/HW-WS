package d1029;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_3190_뱀
public class BOJ3190 {

	static class Loc { // 뱀좌표
		int y;
		int x;

		public Loc(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static class Move { // 이동값(시간, 방향)
		int x;
		int c;

		public Move(int x, int c) {
			this.x = x;
			this.c = c;
		}
	}

	// 빈칸: 0, 사과: 2, 뱀: 1
	static int N, K, L, map[][];
	static boolean end;
	static Move[] moves;

	static int dy[] = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int dx[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		K = Integer.parseInt(br.readLine().trim());

		map = new int[N + 1][N + 1]; // 1행 및 1열 제외

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = 2; // 사과는 2값으로
		}

		L = Integer.parseInt(br.readLine().trim());

		moves = new Move[L];

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			moves[i] = new Move(X, C.charAt(0));
		}

		int dir = 0; // 초기방향: 오른쪽
		int nx = 1, ny = 1;
		int time = 1;
		int idx = 0; // 이동값들의 저장 배열의 인덱스용

		Queue<Loc> snake = new LinkedList<Loc>();
		map[ny][nx] = 1; // 뱀값 1
		snake.offer(new Loc(ny, nx));

		while (true) { // 이동시작

//			System.out.println(time);
//			print();

			// 지정방향으로 한칸씩 진행
			ny += dy[dir];
			nx += dx[dir];

			if (!check(ny, nx) || map[ny][nx] == 1) // 경계 및 뱀자신과 겹치는지 체크
				break;

			if (map[ny][nx] != 2) { // 빈공간이면 큐 배기 및 맵 0으로 변경
 				Loc cur = snake.poll();
				map[cur.y][cur.x] = 0;
			}

			map[ny][nx] = 1; // 움직인 위치 뱀으로(1) 채우고 큐에 넣기
			snake.offer(new Loc(ny, nx));

			if (idx < L && moves[idx].x == time) { // 이동저장 배열 크기체크 및 지정 도달 시간 체크
				dir = rotate(dir, moves[idx].c); // 방향지정
				idx++;
			}
			time++; // 시간증가

		}
		System.out.println(time);

	}

	// 경계체크
	public static boolean check(int ny, int nx) {
		if (ny < 1 || nx < 1 || ny > N || nx > N)
			return false;
		return true;
	}

	// 방향 전환
	public static int rotate(int dir, int C) {
		if (C == 'L') { // 좌회전: 우하좌상(0123) => 상우하좌(3012)
			dir--;
			if (dir == -1)
				dir = 3;
		} else { // 우회전 : 우하좌상(0123) => 하좌상우(1230)
			dir++;
			if (dir == 4)
				dir = 0;
		}
		return dir;
	}

	// 빈칸: 0, 사과: 2, 뱀: 1
	public static void print() { // 진행 과정 확인용
		for (int[] e : map) {
			for (int f : e) {
				System.out.print(f + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
