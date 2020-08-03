package d0803;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 사칙연산 유효성 검사
public class workshop2 {

	// 리프노드로만 판단, 수식일경우 false
	// 리프노드의 범위: 2^(log2 (노드수) ) ~ N

	static char[] tree; // 트리는 완전 이진 트리로 주어짐
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		for (int t = 1; t <= 10; ++t) {
			N = Integer.parseInt(br.readLine()); // 노드수
			tree = new char[N + 1]; // 0인덱스 사용X

			for (int i = 1; i <= N; ++i) {
				String str = br.readLine(); // 1 - 2 3 (node 번호, node 값, 연결 노드)
				String[] temp = str.split(" "); // 임시배열 => temp[0] = "1", temp[1] = "-" (사용할 값), 뒷값은 무시
				tree[i] = temp[1].charAt(0);
			}

			boolean check = false; // 리프노드의 유효성 검사
			for (int i = 1; i <= N; ++i) {
				if ((leaf(N) <= i && i <= N)) {
					if ('0' <= tree[i] && tree[i] <= '9') {
						check = true;
					} else {
						check = false;
						break;
					}
				}
			}
			if (check) // 결과출력
				bw.write("#" + t + " 1\n");
			else
				bw.write("#" + t + " 0\n");

		}
		bw.flush();
		bw.close();
	}

	static int leaf(int N) { // 리프 노드 시작 인덱스 반환 ( 2^log2(노드수) )
		int temp = (int) (Math.log(N) / Math.log(2));
		temp = (int) Math.pow(2, temp);
		return temp;
	}
}
