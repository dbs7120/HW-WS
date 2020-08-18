package d0818;

public class ThreadPause {

	public static void main(String[] args) {
		new ThreadPause();
	}

	public ThreadPause() {
		MyThread trd = new MyThread();
		trd.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// trd.interrupt();
		trd.onAir = false;
	}

	class MyThread extends Thread {
		boolean onAir = true;

		@Override
		public void run() {
			while (onAir) {
				System.out.println("시작");
				try {
					sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
