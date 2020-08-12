package d0812.com.ssafy.sam;

public class AnonymousTest2 {
	public static void main(String[] args) {
		new AnonymousTest2(); // 익명 객체
	}

	public AnonymousTest2() {
		pr(a2);
		pr(a2);
		pr(a2);
		pr(a2);
		pr(new Action() { // 인터페이스 / 추상클래스의 경우 이클립스 자동완성 가능
			@Override
			public void m1() {
				System.out.println("new action");
			}
		});
		pr(new Action() { 
			@Override
			public void m1() {
				System.out.println("new new action");
			}
		});
		pr(a2);
		pr(a2);
	}

	void pr(Action a) {
		a.m1();
	}

	Action a2 = new Action() {
		@Override
		public void m1() {
			System.out.println("inter action");
		}
	};

	interface Action {
		public void m1();
	}

}
