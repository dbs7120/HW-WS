import java.util.Arrays;
import java.util.Scanner;

public class workshop5 {

	// 안경이 없어
	// CEFGHIJKLMNSTUVWXYZ => 서로동일(구멍0)
	// ADOPQR ==> 서로동일(구멍1)
	// B ==> 구멍2
	static char[] chars0 = { 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z' };
	static char[] chars1 = { 'A', 'D', 'O', 'P', 'Q', 'R' };

	static char chars2 = 'B';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			String str1 = sc.next();
			String str2 = sc.next();

			int num1[] = new int[str1.length()];
			int num2[] = new int[str2.length()];

			if (str1.length() != str2.length()) {
				System.out.print("#" + t + " ");
				System.out.println("DIFF");
				continue;
			}

			for (int i = 0; i < str1.length(); i++) {
				for (int j = 0; j < chars0.length; j++) {
					if (str1.charAt(i) == chars0[j]) {
						num1[i] = 0;
					}
					if (str2.charAt(i) == chars0[j]) {
						num2[i] = 0;
					}

				}
				for (int j = 0; j < chars1.length; j++) {
					if (str1.charAt(i) == chars1[j]) {
						num1[i] = 1;
					}
					if (str2.charAt(i) == chars1[j]) {
						num2[i] = 1;
					}

				}
				if (str1.charAt(i) == chars2) {
					num1[i] = 2;
				}
				if (str2.charAt(i) == chars2) {
					num2[i] = 2;
				}

			}
			System.out.print("#" + t + " ");
			System.out.print((Arrays.equals(num1, num2) ? "SAME" : "DIFF") + "\n");
		}

		sc.close();

	}
}
