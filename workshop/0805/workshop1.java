import java.util.Arrays;
import java.util.Scanner;

// SWEA 창용 마을 무리의 개수
public class workshop1 {

	static int p[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 사람수
			int M = sc.nextInt(); // 관계수

			p = new int[N + 1];

			makeSet();

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}

			// System.out.println(Arrays.toString(p));
			int count = 0;
			for (int i = 1; i < N + 1; i++) {
				if (i == p[i])
					count++;
			}
			System.out.println("#" + t + " " + count);
		}
		sc.close();

	}

	private static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (y != x) {
			p[y] = x;

		}

	}

	private static int findSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}

	private static void makeSet() {
		for (int i = 1; i < p.length; i++) {
			p[i] = i;

		}

	}

}
