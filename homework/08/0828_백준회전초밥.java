package d0829;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회전초밥
public class BOJ15961 {

	static int N, D, K, C; // 접시수, 초밥종류, 연속으로먹는 접시수, 쿠폰번호
	static int[] belt;
	static int[] sushi; // 인덱스초밥 종류로해서 먹은 초밥 체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		belt = new int[N + K];
		sushi = new int[D + 1];

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int temp = 0;

		for (int i = 0; i < K; i++)
			belt[i + N] = belt[i]; // 원형이므로 K만큼 추가시킴

		//System.out.println(Arrays.toString(belt));

		int left = 0; // 제일 왼쪽 포인팅
		int right = K - 1; // 제일오른쪽 포인팅

		sushi[C]++; // 쿠폰값 방문에 미리넣기
		temp++;
		for (int i = left; i <= right; i++) { // K만큼
			if (sushi[belt[i]] == 0) // 안먹은 초밥
				temp++;
			sushi[belt[i]]++; // 먹은걸로
		}

        int answer = temp;

		for (int i = 0; i < N; i++) { // N-1만큼 진행

			sushi[belt[left]]--; // 왼쪽 안먹은걸로시작

			if (sushi[belt[i]] == 0) // 벨트위치초밥이 먹은초밥이아니면 감소
				temp--;

			left++; // 포인터두개 이동
			right++;

			if (sushi[belt[right]] == 0) // 오른쪽안먹은거면 증가
				temp++;

			sushi[belt[right]]++; // 오른쪽먹은거체크

			answer = Math.max(answer, temp); // 최대값 갱신

		}
		bw.write(answer + "\n");

		bw.flush();
		bw.close();

	}

}
