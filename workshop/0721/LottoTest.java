package com.ssafy.ws.step02;

public class LottoTest {

	public static void main(String[] args) {
		int[] num = new int[6];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j])
					i--;
			}
		}

		for (int e : num)
			System.out.print(e + " ");
	}

}
