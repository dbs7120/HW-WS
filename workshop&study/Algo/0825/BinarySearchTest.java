package d0825;

import java.util.Arrays;

public class BinarySearchTest {
	static int[] arr = { 1, 4, 7, 3, 8, 6, 9, 3, 5 };

	public static void main(String[] args) {

		int key = 1;
		// 이진탐색의 전재 조건 => 탐색할 대상이 순차 정렬되어 있어야함.

		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		int idx = binarySearch(key);
		System.out.println(idx == -1 ? "Not Found" : idx);
		System.out.println("============");
		int idx2 = binarySearchRecur(key, 0, arr.length - 1);
		System.out.println(idx2 == -1 ? "Not Found" : idx);
	}

	// 이진탐색 반복문 구현
	private static int binarySearch(int key) {
		int mid, low = 0, high = arr.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	// 이진탐색 재귀 구현
	private static int binarySearchRecur(int key, int low, int high) {
		if (low > high)
			return -1;

		int mid = (low + high) / 2;

		if (arr[mid] == key)
			return mid;
		if (arr[mid] > key)
			return binarySearchRecur(key, low, mid - 1);
		else
			return binarySearchRecur(key, mid + 1, high);

	}

}
