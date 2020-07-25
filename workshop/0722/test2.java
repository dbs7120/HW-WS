package com.ssafy;

public class test2 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 9, 4, 10 };

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
			if (min > arr[i])
				min = arr[i];
		}

		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}

}
