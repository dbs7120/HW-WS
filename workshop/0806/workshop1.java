package d0806;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class workshop1 {
	static int V, E;
	static int[] parents;
	static Graph[] graphs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			V = sc.nextInt();
			E = sc.nextInt();
			V++; // 첨자 1번부터 사용

			parents = new int[V];
			graphs = new Graph[E];

			int from, to, weight;
			for (int i = 0; i < E; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();
				graphs[i] = new Graph(from, to, weight);
			}

			Arrays.sort(graphs, Comparator.comparingInt(Graph::getWeight));

			makeSet();

			int count = 0;
			long minsum = 0;

			for (Graph g : graphs) {
				if (unionSet(g.from, g.to)) {
					count++;
					minsum += g.getWeight();
				}
				if (count == V - 1) {
					break;
				}

			}
			System.out.println("#" + t + " " + minsum);

		}
		sc.close();

	}

	static void makeSet() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}

	}

	static boolean unionSet(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		if (xRoot == yRoot)
			return false;
		parents[yRoot] = xRoot;
		return true;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;

		return parents[x] = findSet(parents[x]);

	}

	static class Graph {
		int from;
		int to;
		int weight;

		public int getWeight() {
			return weight;
		}

		public Graph(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

}
