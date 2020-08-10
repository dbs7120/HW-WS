package lab.ssafy.corona.virus;

public class TypeTest {
	public static void main(String[] args) {
		A a = new D();
//		// pr(new A());
//		pr(new B()); // 상속관계를통해 pr
//		// pr(new C()); // ClassCastError => instance of 연산자 활용
//		pr(new D());

		pr(new A());
		pr(new B());
		pr(new C());
		pr(new D());

	}

	static void pr(A o) {
		if (o instanceof C)
			System.out.println(((C) o).numC);
		else if (o instanceof B)
			System.out.println(((B) o).numB);
		else if (o instanceof D)
			System.out.println(((D) o).numD);
		else
			System.out.println(o.numA);
	}

	static class A {
		int numA = 10;
	}

	static class B extends A {
		int numB = 4;
	}

	static class C extends A {
		int numC = 5;
	}

	static class D extends A {
		int numD = 6;
	}

}
