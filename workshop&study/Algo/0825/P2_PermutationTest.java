package d0825;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author THKim
 *
 */
// nPr : nPn에서 n을 r로 보면 똑같다.
public class P2_PermutationTest {

	// 1,2,3
	// 3P2 = 3!/1!= 6
	// 1,2,3
	// 3P3 = 3!
	static int N, R;
	static int[] input, numbers;
	static int totalCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0, 0);
		System.out.println("총 경우의 수 : " + totalCount);
	}

	private static void permutation(int cnt, int flag) {
		if (cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; ++i) {
			if ((flag & (1 << i)) != 0)
				continue;
			numbers[cnt] = input[i];

			permutation(cnt + 1, flag | (1 << i)); // flag는 그대로, 메소드 호출시 전달되는 flag가 연산된 결과(flag자체변화X)
		}
	}
}
