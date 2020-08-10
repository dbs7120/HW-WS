package com.ssafy.AlpaTest2;

public class AlpaTest2 {

	public static void main(String[] args) {
		int ch = 65;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= 5 - i; j++) {
				System.out.print(" ");

			}
			for (int j = 0; j <= i; j++) {
				System.out.printf("%c", ch);
				ch++;
			}
			System.out.println();
		}
	}

}
