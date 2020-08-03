package d0803;

import java.util.Scanner;

// 한빈이와 Spot Mart
public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 과자 봉지수
			int M = sc.nextInt(); // 무게 합 제한
			int[] weight = new int[N]; // 과자봉지 무게들 저장

			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			}

			int maxWeight = -1;
			int sum = 0;
			for (int i = 0; i < N; i++) { // 두 봉지만 삼
				for (int j = 0; j < N; j++) {
					if (i == j) { // 같은 봉지 방지
						continue;
					}
					sum = weight[i] + weight[j];
					if (sum <= M && maxWeight <= sum) { // 무게합 제한 이내에서 최대값으로
						maxWeight = sum;
					}

				}
			}
			System.out.println("#" + t + " " + maxWeight);
		}

		sc.close();

	}

}
