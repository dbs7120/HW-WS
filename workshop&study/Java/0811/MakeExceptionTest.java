package d0811;

import java.util.Scanner;

public class MakeExceptionTest {
	public static void main(String[] args) {
		new MakeExceptionTest();

	}

	public MakeExceptionTest() {
		try {
			addJumsu();
		} catch (JumsuException e) {
			System.out.println("error " + e.toString());
		}

	}

	void addJumsu() throws JumsuException {
		Scanner sc = new Scanner(System.in);
		int jumsu = sc.nextInt();

		// 점수는 0점에서 100점 사이만 입력 가능하게
		if (jumsu >= 0 && jumsu <= 100) {
			System.out.println("정상");
		} else {

//			JumsuException e = new JumsuException();
//			throw e;
//			=>
			throw new JumsuException("점수 오류, 점수값: " + jumsu);

		}

		System.out.println("받은 점수 처리" + jumsu);
	}

	class JumsuException extends Exception {
//		String msg;

		JumsuException(String msg) {
			super(msg);
//			this.msg = msg;
		}

	}

}
