package d0806;

import java.util.Scanner;

// 백준 2961 도영이가 만든 맛있는 음식
public class homework {
	static int N;
	static int[][] taste = new int[11][2]; // 맛배열 [N][0]: 신맛 [N][1]: 쓴맛
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			taste[i][0] = sc.nextInt();
			taste[i][1] = sc.nextInt();
		}

		visited = new boolean[N + 1];
		combination(0, 1, 0);
		System.out.println(min);
		sc.close();

	}

	// 경우의 수 최대 nC1 + nC2 + ... + nC10
	// visited를 통해 중복된 값 제거하기
	private static void combination(int cnt, int S, int B) {
		if (cnt > 0) {
			int temp = Math.abs(S - B); // 차이의 최소값
			if (temp < min) // 기존값과 비교후 갱신
				min = temp;
		}

		if (cnt > N) // 경우의 수 N 넘어가면 리턴
			return;

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(cnt + 1, S * taste[i][0], B + taste[i][1]);
				visited[i] = false;

			}

		}
	}

}
