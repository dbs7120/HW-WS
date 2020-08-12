package d0812.com.ssafy.sam;

public class AnonymousTest {
	public static void main(String[] args) {
		new AnonymousTest(); // 익명 객체
	}

	public AnonymousTest() {
		Action a = new Action();
		pr(a);
		
		// 익명 클래스 (AnonymousTest$1.class)
		pr(new Action() { 

			@Override
			public void m1() {
				System.out.println("change");
			}

		});
	}

	void pr(Action a) {
		a.m1();
	}

	class Action {
		public void m1() {
			System.out.println("m1");
		}
	}

}

