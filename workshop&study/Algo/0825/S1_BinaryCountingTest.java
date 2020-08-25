package d0825;

import java.util.Scanner;

public class S1_BinaryCountingTest {

	static int N;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		int caseCount = 1 << N;
		generateSubset(caseCount);

	}

	private static void generateSubset(int caseCount) {
		for (int flag = 0; flag < caseCount; flag++) { // flag 0부터 : 공집합 포함, 1부터 : 공집합 제외
			// flag의 각 비트자리를 확인하여 원소 선택 유/무 판단
			for (int i = 0; i < numbers.length; i++) {
				if ((flag & (1 << i)) != 0) {
					System.out.print(numbers[i] + " ");
				}
			}
			System.out.println();

		}
	}

}
