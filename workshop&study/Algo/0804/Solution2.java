import java.util.Arrays;
import java.util.Scanner;

// 정올 종교
/*
 * makeSet(x): 유일한 멤버 x를 포함하는 새로운 집합 생성
 * union(x,y): x,y를 포함하는 두집합을 통합하는 연산
 * findSet(x): x를 포함하는 집합을 찾는 연산 
 */

public class Solution2 {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 쌍의 수
		p = new int[n + 1]; //

		makeSet();

		int x, y;

		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			union(x, y);
		}
		// System.out.println(Arrays.toString(p));

		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (i == p[i])
				count++;
		}
		System.out.println(count);
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
