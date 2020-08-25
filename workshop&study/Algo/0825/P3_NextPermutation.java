package d0825;

import java.util.Arrays;
import java.util.Scanner;

public class P3_NextPermutation {

	static int N;
	static int[] input;
	static int totalP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input); // np전 정렬

		do { // 가장 작은순열 한번 처리해야함 => do while
			System.out.println(Arrays.toString(input));
			totalP++;
		} while (nextPermutation(input));

		System.out.println("총 순열의 수 : " + totalP);
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
