import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 완전탐색 <br>
 * i번째 구슬 모든열에 반복(w번 반복 => "선택지") <br>
 * 한열고정 -> 윗행 시작 모든행 드려다보며 벽돌 찾기 (못찾으면 다음 구슬) <br>
 * 1. * i-1 구슬 까지의 상태로 초기화 <br>
 * 2. 벽돌 깨뜨리기 - 연쇄적으로 주변 벽돌 함께 깨뜨리기 (BFS,DFS) <br>
 * 3. 빈공간 처리(배열내리기)
 * 4. 다음구슬 처리 <br>
 *
 * 연쇄적 터트리기 <br>
 * => BFS <br>
 * 시작벽돌 : 구슬에 맞은 벽돌 <br>
 * 큐준비, 큐에 시작벽돌 넣기 <br>
 * 벽돌 깨뜨리기처리(0: 빈공간으로 바꿈 => 방문처리) <br>
 *   while(q is not empty){ <br>
 *     벽돌 poll <br>
 *     if 벽돌 크기가 1이면 다음으로 <br>
 *     for(d:1=>4){ // 4방위 <br>
 *        벽돌크기 -1 만큼 loop <br>
 *        경계체크, 빈공간 체크 <br>
 *        벽돌 offer <br>
 *        벽돌 깨뜨리기처리(방문체크) <br>
 *     }
 *   }
 */
public class Solution {

	static class Loc {
		int y, x, cnt;

		public Loc(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}

	static int N, W, H, min, map[][];
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			min = 987654321;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			go(0, map);

			System.out.println("#" + t + " " + min);

		}

	}

	// i번째 구슬을 떨어뜨리기
	private static boolean go(int count, int[][] map) { // 던져진 구슬의 개수, 이전 구슬 까지의 2차원 배열

		int result = getRemain(map); // 남아 있는 벽돌 개수 구해서 최소값 갱신
		if (result == 0) { // 남은 벽돌 0이면 처리
			min = 0;
			return true;
		}

		if (count == N) { // end status (구슬을 N번만큼 쓴경우)
			if (min > result)
				min = result;
			return false;
		}

		int newMap[][] = new int[H][W];

		for (int x = 0; x < W; x++) { // 모든 열에 떨어뜨림
			int y = 0;
			while (y < H && map[y][x] == 0)
				y++;
			if (y == H) // 벽돌이 없음
				continue;
			copy(map, newMap); // 이전 구슬 상태로 배열 복사하여 초기화
			boom(newMap, y, x); // 터트리기
			down(newMap); // 벽돌 내리기
			if (go(count + 1, newMap)) { // 다음 구슬 처리
				return true;
			}

		}
		return false; // 기본 리턴값

	}

	private static void boom(int[][] map, int y, int x) {
		Queue<Loc> q = new LinkedList<Loc>();

		if (map[y][x] > 1) // 현값이 1이면 큐 삽입 X
			q.offer(new Loc(y, x, map[y][x]));

		map[y][x] = 0; // 벽돌 제거 처리( 방문 처리)

		while (!q.isEmpty()) {
			Loc cur = q.poll();
			if (cur.cnt == 1) // 현값(map[y][x])이 1이면 다음으로
				continue;
			for (int d = 0; d < 4; d++) {

				int ny = cur.y;
				int nx = cur.x;

				for (int l = 1; l < cur.cnt; l++) {
					ny += dy[d];
					nx += dx[d];
					if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 0)
						continue;
					if (map[ny][nx] > 1)
						q.offer(new Loc(ny, nx, map[ny][nx]));
					map[ny][nx] = 0;

				}
			}
		}

	}

	private static void down(int[][] map) {
		for (int x = 0; x < W; x++) { // 열 고정
			int y = H - 1;
			while (y > 0) {
				if (map[y][x] == 0) {
					int ny = y - 1; // 직전행
					while (ny > 0 && map[ny][x] == 0) // 처음 만나는 벽돌 찾기
						ny--;
					map[y][x] = map[ny][x];
					map[ny][x] = 0;
				}
				y--;
			}

		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int[] e : map) {
			for (int f : e) {
				if (f != 0)
					count++;
			}
		}
		return count;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

}
