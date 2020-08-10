package lab.ssafy.corona.virus;

public class InterfaceTest {

	public static void main(String[] args) {
		MyClass my1 = new MyClass();
		Sam my2 = new MyClass(); // 부모 클래스로 접근
		Inter1 my3 = new MyClass(); // 인터페이스로 접근
		Inter2 my4 = new MyClass(); // 인터페이스로 접근

		my1.aa();
		my1.print();
		my1.printDefault();
		my2.aa();
		//my2.print(); X

		my3.print();
		my3.printDefault();
		System.out.println(my3.pi);
		//my3.pi = 3; X 인터페이스 내부 변수는 상수(final)




	}

	// 자바는 단일상속만 가능, 다중인터페이스 구현 가능, 인터페이스 또한 extends 키워드 사용 가능
	static class MyClass extends Sam implements Inter1, Inter2 {

		@Override
		public void print() {	// implements 했으면 인터페이스 내부 요소 반드시 구현해야함
			System.out.println("인터페이스 구현");

		}
	}

	static class Sam {
		public final void aa() {
			System.out.println("변경 불가");

		}
	}

	final class Sam2{	// final class 은 상속불가능 하게함

	}

	static interface Inter1 {
		double pi = 3.14;
		void print();	// 몸체X, 구현해야할 형식만
		default void printDefault() {
			System.out.println("인터페이스 디폴트 메소드");
		}

	}

	static interface Inter2 {

	}

}
