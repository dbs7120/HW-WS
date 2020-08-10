package lab.ssafy.corona.virus;

public class OverloadingTest {

	public static void main(String[] args) {
		new OverloadingTest();

	}

	public OverloadingTest() {
		int res = sum(3, 4);
		System.out.println(res);
		res = sum(3, 4, 5, 6);
		System.out.println(res);

	}

	int sum(int a, int b) {
		return a + b;
	}

	int sum(int... a) { // 가변인자 매개변수(int[] a), sum메소드 오버로딩
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;

	}

}
