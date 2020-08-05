import java.util.Scanner;

//서로소 집합

/*
 * makeSet(x): 유일한 멤버 x를 포함하는 새로운 집합 생성
 * union(x,y): x,y를 포함하는 두집합을 통합하는 연산
 * findSet(x): x를 포함하는 집합을 찾는 연산 
 */

public class Solution1 {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String result = "";
		for (int t = 1; t <= T; t++) {
			result = "";

			int n = sc.nextInt(); // 정점의 개수
			int m = sc.nextInt(); // 연산의 개수
			p = new int[n + 1]; //

			makeSet();

			int type, x, y; // 0: 합집합, 1: 체크

			for (int i = 0; i < m; i++) {

				type = sc.nextInt();
				x = sc.nextInt();
				y = sc.nextInt();

				switch (type) {
				case 0:
					union(x, y);
					break;

				case 1:
					x = findSet(x);
					y = findSet(y);
					if (x == y) {
						result += "1";
					} else {
						result += "0";
					}
					break;
				}
			}

			System.out.println("#" + t + " " + result);

		}

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

//		int temp = findSet(p[x]);
//		p[x] = temp;	// 부모에 넣어놓고 오기
//		return temp;
//		==>		
		return p[x] = findSet(p[x]);
	}

	private static void makeSet() {
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}

	}

}
