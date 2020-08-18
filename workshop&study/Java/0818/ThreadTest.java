package d0818;

// Thread각각은 서로 경쟁상태로들어가기 때문에 출력결과순서 알수 없음
public class ThreadTest {
	public static void main(String[] args) {
		Thread a = new A();
		System.out.println("start:extends Start");
		a.start();
		System.out.println("end:extends Thread"); // main thread 와 A thread 내부의 출력실행순서가 불명확해짐

		B b = new B();
		Thread t = new Thread(b); // Runnable : 쓰래드로 바꿀수 있는 객체
		System.out.println("start:implements Runnable");
		t.start();
		System.out.println("end:implements Runnable");

		// Runnable 익명호출
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start:Annomy");
				try {
					System.out.println("A");
					Thread.sleep(1000);
					System.out.println("B");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end:Annomy");

			}
		});
		t2.start();

		// ==> 람다
		new Thread(() -> {
			System.out.println("start:Lamda");
			try {
				System.out.println("A");
				Thread.sleep(1000);
				System.out.println("B");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end:Lamda");
		}).start();

	}

	static class A extends Thread { // White Box (비권장, 추가상속의 불가, 추가메소드 모두접근가능해짐(sleep))

		@Override
		public void run() {
			try {
				System.out.println("A");
				sleep(1000);	// ms단위 휴식
				System.out.println("B");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	static class B implements Runnable { // Black Box (인터페이스 implements로 인해 추가상속가능)

		@Override
		public void run() {
			try {
				System.out.println("A");
				System.out.println("B");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
