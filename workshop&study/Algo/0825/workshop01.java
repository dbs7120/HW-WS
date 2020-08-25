package d0825;

import java.util.ArrayList;
import java.util.Scanner;

// BOJ15686 치킨배달
public class workshop01 {

	static int N, M;
	static ArrayList<Pos> chicken = new ArrayList<Pos>();
	static ArrayList<Pos> house = new ArrayList<Pos>();
	static boolean visit[];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt(); // M 폐업시키지 않을 치킨집 최대 M개(존재할 치킨집 M개)

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				if (temp == 2)
					chicken.add(new Pos(i, j));
				if (temp == 1)
					house.add(new Pos(i, j));
			}
		}

		visit = new boolean[chicken.size()];
		calc(0, 0);
		System.out.println(ans);

		sc.close();

	}

	public static void calc(int idx, int cnt) {
		if (cnt == M) {
			int res = 0;

			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (visit[j]) {
						int distance = Math.abs(house.get(i).x - chicken.get(j).x)
								+ Math.abs(house.get(i).y - chicken.get(j).y);
						min = Math.min(min, distance);
					}
				}
				res += min;
			}
			ans = Math.min(ans, res);
			return;
		}
		for (int i = idx; i < chicken.size(); i++) {
			visit[i] = true;
			calc(i + 1, cnt + 1);
			visit[i] = false;

		}
	}

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
