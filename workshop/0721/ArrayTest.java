package com.ssafy.ws.step02;

public class ArrayTest {
	static int[] list;

	public static void main(String[] args) {
		list = new int[10];

		for (int i = 0; i < 10; i++) {
			list[i] = (int) (Math.random() * 100) + 1;
		}

		print();
		total();
		average();
		minimum();

	}

	public static void print() {
		for (int e : list)
			System.out.print(e + " ");

		System.out.println();
	}

	public static void total() {
		int sum = 0;
		for (int e : list)
			sum += e;

		System.out.println("배열의 합 :" + sum);
	}

	public static void average() {
		double avg = 0;
		for (int e : list)
			avg += e;

		System.out.printf("배열의 평균 : %.1f\n", avg / list.length);
	}

	public static void minimum() {
		int min = 999;
		for (int e : list) {
			if (min > e)
				min = e;
		}
		System.out.println("배열의 최소값 :" + min);
	}

}
