import java.util.Scanner;

public class workshop2 {
	static int[] dy = { 0, 0, -1, 1 }; // 상하 좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[][] input;	// 입력배열
	static int[][] result;	// 입력의 수치계산결과 저장배열 
	static int N;
	static int count;
	static int MAX;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			MAX = 0;
			int minResult = Integer.MAX_VALUE;

			input = new int[N][N];
			result = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					input[i][j] = sc.nextInt();
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 0;
					checkR(i, j, input[i][j]);
					result[i][j] = count;
				}
			}
			
//			for (int[] e : result) {		// 결과배열 확인용
//			for (int f : e) {
//				System.out.print(f + " ");
//			}
//			System.out.println();
//			}		

			for (int i = 0; i < N; i++) {	// MAX값 중 input배열에서 최소값 찾기
				for (int j = 0; j < N; j++) {
					if (result[i][j] == MAX) {
						if (minResult > input[i][j])
							minResult = input[i][j];
					}
				}
			}

			System.out.println("#" + t + " " + minResult + " " + (MAX + 1)); // 본인방 포함(+1) 출력			
		}
		sc.close();
	}

	static void checkR(int y, int x, int inputValue) { // y 좌표, x좌표, input[y][x]의 값

		for (int d = 0; d < 4; d++) {

			int ny = y + dy[d];
			int nx = x + dx[d];

			if (!(nx < 0 || nx >= N || ny < 0 || ny >= N)) { // 외곽판단의 not => 내부일경우 체크
				if (input[ny][nx] == input[y][x] + 1) { // 현재값+1과 인접값 비교
					count++;
					checkR(ny, nx, inputValue); // 재귀호출(다음값으로 내부판단, +1값인지 판단 후 계속진행)
				}
			}
		}

		if (MAX < count) {	// 최대값 저장해놓기
			MAX = count;
		}

	}
}
