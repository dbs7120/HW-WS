package d0825;

public class BitMaskTest {
	public static void main(String[] args) {
		System.out.println(33 & 1); // <=> n%2==0 (짝수 판단)
		System.out.println(1002 & 1); // <=> n%2==0 (짝수 판단)
		System.out.println("===============================");

		int S = 1;
		S = S | (1 << 3); // S 에 3을 Add

		// Check:: !0: True(포함) / 0: False: (미포함)
		System.out.println("3포함?: " + (S & (1 << 3))); // S에 3이 있는지 Check (!0)
		System.out.println("2포함?: " + (S & (1 << 2))); // S에 2이 있는지 Check (0)

		System.out.println("===============================");
		S = S ^ (1 << 3); // S에 3이 있으면 제거 없으면 추가 Toggle
		System.out.println("3포함?: " + (S & (1 << 3)));
		System.out.println("===============================");

		S = 0; // S 비우기 Empty
		S = (1 << 4) - 1; // S 에 N 자리만큼 모두 채우기 All
		System.out.println(Integer.toBinaryString(S));
		System.out.println("3포함?: " + (S & (1 << 3)));
		System.out.println("2포함?: " + (S & (1 << 2)));
	}
}

