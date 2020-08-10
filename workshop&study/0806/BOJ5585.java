package d0806;


//거스름돈

import java.util.Scanner;

public class BOJ5585 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] coins = { 500, 100, 50, 10, 5, 1 };
		int count = 0;
		money = 1000 - money;

		for (int coin : coins) {
			if (money >= coin) {
				count += money / coin;
				money %= coin;
			}

		}

		System.out.println(count);
		sc.close();

	}

}
