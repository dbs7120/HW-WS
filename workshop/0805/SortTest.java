import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortTest {

	public static void main(String[] args) {

		/* ========================================================================== */

		Integer[] arr = { 3, 6, 8, 6, 1, 9 };
		System.out.println("Arr 정렬전 : " + Arrays.toString(arr));

		// 1차원 오름차순 정렬
		Arrays.sort(arr);
		System.out.println("Arr 정렬후 : " + Arrays.toString(arr) + "(오름차순)");

		// 내림차순 정렬
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});
		System.out.println("Arr 정렬후 : " + Arrays.toString(arr) + "(내림차순)");
		System.out.println();

		/* ========================================================================== */

		int[][] arr2 = { { 1, 2 }, { 8, 3 }, { 4, 6 }, { 9, 1 }, { 4, 6 } };

		System.out.println("Arr2 정렬전 : " + Arrays.deepToString(arr2));

		// 2차원 배열 앞기준 오름차순 정렬
		Arrays.sort(arr2, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		System.out.println("Arr2 정렬후 : " + Arrays.deepToString(arr2) + "(앞 오름차순)");

		// 2차원 배열 뒷기준 내림차순 정렬
		Arrays.sort(arr2, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return -(o1[1] - o2[1]);
			}
		});
		System.out.println("Arr2 정렬후 : " + Arrays.deepToString(arr2) + "(뒷 내림차순)");
		System.out.println();

		/* ========================================================================== */

		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(3);
		arrlist.add(1);
		arrlist.add(4);
		arrlist.add(5);
		arrlist.add(2);
		arrlist.add(6);

		System.out.println("Arrlist 정렬전 : " + arrlist.toString());

		// 내림차순 정렬
		Collections.sort(arrlist);
		System.out.println("Arrlist 정렬후 : " + arrlist.toString() + "(오름차순)");

		// 오름차순 정렬
		Collections.sort(arrlist, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});
		System.out.println("Arrlist 정렬후 : " + arrlist.toString() + "(내림차순)");
		System.out.println();

		/* ========================================================================== */

		ArrayList<ID> idArrList = new ArrayList<ID>();
		idArrList.add(new ID("윤씨", 23));
		idArrList.add(new ID("최씨", 33));
		idArrList.add(new ID("김씨", 13));
		idArrList.add(new ID("안씨", 12));
		for (ID e : idArrList) {
			System.out.print(e + " ");
		}
		System.out.println();

		Collections.sort(idArrList, new Comparator<ID>() {

			@Override
			public int compare(ID o1, ID o2) {

				return o1.age - o2.age;
			}

		});
		for (ID e : idArrList) {
			System.out.print(e + " ");
		}

	}

}

class ID {
	String name;
	int age;

	public ID(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "ID [name=" + name + ", age=" + age + "]";
	}

}
