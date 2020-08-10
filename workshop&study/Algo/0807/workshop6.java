package d0807;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class workshop6 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] input = new int[N][2]; // 시작/종료
		for (int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}

		Arrays.sort(input, new Comparator<int[]>() { // 종료기준 정렬
			@Override
			public int compare(int[] start, int[] end) {
				if (start[1] == end[1]) { // 종료기준 같은값일때
					return start[0] - end[0]; // 시작기준정렬
				}
				return start[1] - end[1];
			}
		});

		//System.out.println(Arrays.deepToString(input));

		int count = 1;
		int end = input[0][1]; // 끝나는 임시 시간값 (현재 첫번째)
		for (int i = 0; i < N; i++) {
			if (input[i][0] <= end) {	// 첫번째 끝나는시간, 다음 끝나는시간 비교
				if (input[i][1] <= end) { // 두값중 더 빠른 끝나는 시간으로 갱신
					end = input[i][1];
				}
				continue;

			} else {
				end = input[i][1];	// 임시 값 끝나는 시간 갱신
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
}