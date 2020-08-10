package d0807;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class workshop3 {

	static int N;
	static int[][] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 화학 물질수
		input = new int[N][2];

		for (int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt(); // 최저
			input[i][1] = sc.nextInt(); // 최고온도
		}

		Arrays.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] first, int[] second) {
				if (first[1] == second[1]) {
					return new Integer(first[0]).compareTo(second[0]);
				}
				return new Integer(first[1]).compareTo(second[1]);
			}

		});

		int count = 1;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			if (temp >= input[i][0]) {
				if (temp >= input[i][1]) {
					temp = input[i][1];
				}

			} else {
				temp = input[i][1];
				count++;
			}

		}
		System.out.println(count);

		sc.close();

	}

}
