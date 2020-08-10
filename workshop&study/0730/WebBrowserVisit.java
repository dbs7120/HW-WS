package d0730;

import java.util.Stack;

public class WebBrowserVisit {

	static Stack<String> backward = new Stack<>();
	static Stack<String> forward = new Stack<>();
	static String startPage = "http://www.ssafy.com";

	public static void main(String[] args) {

		System.out.println("시작페이지\t" + startPage);
		backward.push(startPage);

		visit("http://www.google.com");
		visit("http://www.naver.com");
		back();
		visit("http://edu.ssafy.com");
		forward();
		back();
		forward();
		back();
		back();
		back();

	}

	public static void visit(String web) {
		System.out.println("페이지 이동");
		backward.push(web);
		System.out.println("현재 페이지\t" + web);
		if (forward.isEmpty() == false)
			forward.pop();
	}

	public static void back() {
		if (backward.peek() == startPage) {
			System.out.println("뒤로 가기 불가");
			return;
		}
		System.out.println("뒤로 가기");

		forward.push(backward.peek());
		backward.pop();

		System.out.println("현재 페이지\t" + backward.peek());

	}

	public static void forward() {
		if (forward.isEmpty()) {
			System.out.println("앞으로 가기 불가");
			return;
		}
		System.out.println("앞으로 가기");

		backward.push(forward.peek());

		System.out.println("현재 페이지\t" + forward.peek());
		forward.pop();
	}

}
