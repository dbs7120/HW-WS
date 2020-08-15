package d0815;

import java.util.HashMap;
import java.util.Scanner;

// 친구 네트워크
// 친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하기
public class BOJ4195 {
	static int p[];
	static int result[];
	static int N;
	static int E;
	// 이름을 유일키(hash key)로 중복 배제 , 관계성을 value 값으로
	static HashMap<String, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			E = sc.nextInt();
			N = E * 2; // 친구수 최대가 될 수 있는경우: 관계 X 2 ( 한쌍식 관계만큼)

			// 각 저장요소들 초기화
			map = new HashMap<>();
			p = new int[N + 1];
			result = new int[N + 1];
			makeSet();
			int index = 1; // 관계저장 배열 첨자용
			for (int i = 0; i < E; i++) {
				String start = sc.next();
				String end = sc.next();
				if (!map.containsKey(start)) { // 이름(키값) 중복검사
					map.put(start, index); // map["이름"] = index
					index++;
				}
				if (!map.containsKey(end)) {
					map.put(end, index);
					index++;
				}
				unionSet(map.get(start), map.get(end));
			}

//			// 결과 체크용
//			System.out.println("결과");
//			for (int e : result) {
//				if (e != 1 && e != 0)
//					System.out.print(e + " ");
//			}

		}
		sc.close();
	}

	public static void unionSet(int start, int end) {
		start = findSet(start);
		end = findSet(end);
		if (start != end) {
			p[start] = end;
			result[end] += result[start]; // 관계수를 구해야하기 때문에 결과에 크기도 더해주기
		}
		System.out.println(result[end]); // unionSet 될때마다 네트워크 관계수 출력
	}

	public static int findSet(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	public static void makeSet() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
			result[i] = 1; // 결과배열(관계수)은 1로 초기화
		}
	}
}
