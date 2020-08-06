package d0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

==>10
----------------------------------

7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14

==>31

 */

public class MST_KruskalTest {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) { // 오름차순 정렬
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		V++;
		edgeList = new Edge[E];

		parents = new int[V];

		int from, to, weight;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgeList);
		makeSet();
		int count = 0, result = 0;
		for (Edge edge : edgeList) {
			if (unionSet(edge.from, edge.to)) { // 싸이클이 형성되지 않았다면
				count++;
				result += edge.weight;
				if (count == V - 1) {
					break;
				}

			}
		}
		System.out.println(result);

	}

	static void makeSet() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;

		return parents[a] = findSet(parents[a]);
	}

	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) // 같은 부모면 false
			return false;

		parents[bRoot] = aRoot; // 합집합성공 true

		return true;
	}

}
