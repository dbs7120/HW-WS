package d0825;

import java.util.Scanner;


// nCr
public class C1_NextCombination {

	static int N, R;
	static int[] input, p; // input : 입력 배열 / p : 실제 조합 배열
	static int totalC = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		p = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		int cnt = 1;

		while (cnt <= R) { // np 수행하는 배열을 가장 작은 순열형태로 만듦
			p[N - cnt] = 1;
			cnt++;
		}

		do {
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					System.out.print(input[i] + " ");
				}
			}
			totalC++;
			System.out.println();

		} while (nextPermutation(p));

		System.out.println("총 조합의 수 : " + totalC);
		sc.close();
	}

	private static boolean nextPermutation(int[] numbers) {

		// step1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			i--;
		}
		if (i == 0) // 전체 내림차순 => 마지막 => np 없음
			return false;

		// step2. i-1 위치와 교환할 다음단계 큰 수 뒷쪽에서 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) {
			j--;
		}

		// step3. i-1위치값과 j 위치값 교환
		swap(numbers, i - 1, j);

		// step4. i위치부터 맨 뒤 까지 오름차순 정렬 (내림->오름 (reverse))
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}
		return true;
	}

	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
