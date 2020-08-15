package d0815;

import java.util.HashMap;
import java.util.Scanner;

// ģ�� ��Ʈ��ũ
// ģ�� ���谡 ���� ������, �� ����� ģ�� ��Ʈ��ũ�� �� ���� �ִ��� ���ϱ�
public class BOJ4195 {
	static int p[];
	static int result[];
	static int N;
	static int E;
	// �̸��� ����Ű(hash key)�� �ߺ� ���� , ���輺�� value ������
	static HashMap<String, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			E = sc.nextInt();
			N = E * 2; // ģ���� �ִ밡 �� �� �ִ°��: ���� X 2 ( �ѽֽ� ���踸ŭ)

			// �� �����ҵ� �ʱ�ȭ
			map = new HashMap<>();
			p = new int[N + 1];
			result = new int[N + 1];
			makeSet();
			int index = 1; // �������� �迭 ÷�ڿ�
			for (int i = 0; i < E; i++) {
				String start = sc.next();
				String end = sc.next();
				if (!map.containsKey(start)) { // �̸�(Ű��) �ߺ��˻�
					map.put(start, index); // map["�̸�"] = index
					index++;
				}
				if (!map.containsKey(end)) {
					map.put(end, index);
					index++;
				}
				unionSet(map.get(start), map.get(end));
			}

//			// ��� üũ��
//			System.out.println("���");
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
			result[end] += result[start]; // ������� ���ؾ��ϱ� ������ ����� ũ�⵵ �����ֱ�
		}
		System.out.println(result[end]); // unionSet �ɶ����� ��Ʈ��ũ ����� ���
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
			result[i] = 1; // ����迭(�����)�� 1�� �ʱ�ȭ
		}
	}
}
