package lab.ssafy.corona.virus;

public class OverridingTest {

	public static void main(String[] args) {
		new OverridingTest();

	}

	enum Day {
		S, M, T, W, F;
	}

	public OverridingTest() {

		System.out.print("1:Parent p1 = new Parent();==>");
		Parent p1 = new Parent();
		p1.pr();

		System.out.print("2:Child c1 = new Child();==>");
		Child c1 = new Child();
		c1.pr();

		System.out.print("3:Parent p2 = new Child();==>");
		Parent p2 = new Child();
		p2.pr();

//		System.out.print("======================");
//		Child c2 = new Parent();	==> 불가능
//		c2.pr();

	}

}

class Parent {
	void pr() {
		System.out.println("부모 pr");
	}

}

class Child extends Parent {
	// 오버라이딩
	void pr() {
		System.out.println("자식 pr");
	}

}
