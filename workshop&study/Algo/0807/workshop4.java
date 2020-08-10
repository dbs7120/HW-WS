package d0807;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class workshop4 {

	static int N, K;
	static int result = 0;
	static boolean[] visitied = new boolean[100001];
	static int[] distance = new int[100001];

	// start:N => N*2 || N+1 || N-1
	// 1.N*2 => N*2*2 || N*2+1 || N*2-1
	// 2.N+1 => N+1*2 || N+1+1 || N+1-1
	// 3.N-1 => N-1*2 || N-1+1 || N-1-1
	// 1.1 N*2*2...
	// 1.2 N*2+1...
	// 1.3 ...
	// 2.1 => 2.2 => 2.3 => 3.1 => 3.2 => 3.3 => 4.1 => 4.2=> ...
	// visitied를 통해 방문체크

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (N > K) {
			System.out.println(N - K);
			return;
		}

		bfs();

		// System.out.println();
		System.out.println(result);

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		visitied[N] = true;
		distance[N] = 0;

		while (!q.isEmpty()) {

			int temp = q.poll();
			if (temp == K) {
				result = distance[temp];
				break;
			}
			// System.out.println(temp);

			if (temp * 2 < 100001) {
				if (!visitied[temp * 2]) {
					q.offer(temp * 2);
					visitied[temp * 2] = true;
					distance[temp * 2] = distance[temp] + 1;
					// System.out.println(distance[temp * 2]);
				}

			}
			if (temp + 1 < 100001) {
				if (!visitied[temp + 1]) {
					q.offer(temp + 1);
					visitied[temp + 1] = true;
					distance[temp + 1] = distance[temp] + 1;
					// System.out.println(distance[temp + 1]);

				}
			}
			if (temp - 1 >= 0) {
				if (!visitied[temp - 1]) {
					q.offer(temp - 1);
					visitied[temp - 1] = true;
					distance[temp - 1] = distance[temp] + 1;
					// System.out.println(distance[temp - 1]);
				}
			}

		}

	}
}
