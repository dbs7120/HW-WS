package d0728;

import java.util.Scanner;
import java.io.FileInputStream;

public class d0728_Flatten {

	static int[] input = new int[100];

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			int max, min;

			for (int i = 0; i < 100; i++) {
				input[i] = sc.nextInt();
			}

			while (dump != 0) {
				max = 0;
				min = 101;
				for (int i = 0; i < 100; i++) {
					if (input[i] > max) {
						max = input[i];
					}
					if (input[i] < min) {
						min = input[i];
					}
				}
				for (int i = 0; i < 100; i++) {
					if (input[i] == max) {
						input[i]--;
						break;
					}
				}
				for (int i = 0; i < 100; i++) {
					if (input[i] == min) {
						input[i]++;
						break;
					}
				}
				dump--;
			}
			max = 0;
			min = 101;

			for (int i = 0; i < 100; i++) {
				if (input[i] > max) {
					max = input[i];
				}
				if (input[i] < min) {
					min = input[i];
				}
			}
			System.out.println("#" + t + " " + (max - min));
		}
		sc.close();
	}
}
