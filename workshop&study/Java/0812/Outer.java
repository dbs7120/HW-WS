package d0812.com.ssafy.sam;

public class Outer {
	int a;

	void b() {
		Inner a = new Inner();
		a.c();
	}

	void bbb() { // method 내부 innder class, method 내부에서만 사용가능(지역화)
		
		//LocalInner aaa = new LocalInner(); // 클래스가 선언된 이후에만 사용가능
		class LocalInner { // (Outer$1LocalInner.class)

		}
		LocalInner aaa = new LocalInner();
		
	}

	class Inner { // (Outer$Inner.class)
		void c() {
			System.out.println("test1");
		}

	}

	static class Inner2 { // static inner class // (Outer$Inner2.class)
		void d() {
			System.out.println("test2");
		}

	}

}

