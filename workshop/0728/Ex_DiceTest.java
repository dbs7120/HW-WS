package d0728;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {

	private static int N, numbers[], totalCnt; // 던진횟수, 기억배열, 총카운트
	private static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		numbers = new int[N];
		isSelected = new boolean[7];
		int mode = sc.nextInt();
		totalCnt = 0;

		switch (mode) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice2(0);
			break;
		case 3:
			dice3(0, 1); // 주사위눈은 1부터 시작
			break;
		case 4:
			dice4(0, 1);
			break;
		}

		System.out.println("총 경우의 수: " + totalCnt);

		sc.close();

	}

	// 중복순열 π
	private static void dice1(int cnt) { // cnt: 현재까지 던진 주사위수
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt + 1);
		}

	}

	// 순열 P
	private static void dice2(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	// 중복 조합 H
	private static void dice3(int cnt, int start) {

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i); // 다음 재귀는 자기자식(i)부터 시작
		}
	}

	// 조합 C
	private static void dice4(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}

}
