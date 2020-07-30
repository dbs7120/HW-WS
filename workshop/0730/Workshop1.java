package d0730;

import java.util.Scanner;
import java.util.Stack;

public class Workshop1 {

	public static void main(String[] args) {

		int N;
		String input;
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {

			Stack<Character> st = new Stack<>();
			N = sc.nextInt();
			input = sc.next();
			int isTrue = 1;

			// 입력값 홀수거나 길이안맞으면 종료
			if (N % 2 == 1 || input.length() > N) {
				isTrue = 0;
				System.out.println("#" + t + " " + isTrue);
				continue;
			}

			for (int i = 0; i < N; i++) {
				if (input.charAt(i) == '(') {
					st.push(input.charAt(i));
				} else if (input.charAt(i) == '{') {
					st.push(input.charAt(i));
				} else if (input.charAt(i) == '<') {
					st.push(input.charAt(i));
				} else if (input.charAt(i) == '[') {
					st.push(input.charAt(i));
				}

				else if (input.charAt(i) == ')') {
					if (st.pop() != '(') {
						isTrue = 0;
						break;
					}
				} else if (input.charAt(i) == '}') {
					if (st.pop() != '{') {
						isTrue = 0;
						break;
					}
				} else if (input.charAt(i) == '>') {
					if (st.pop() != '<') {
						isTrue = 0;
						break;
					}
				} else if (input.charAt(i) == ']') {
					if (st.pop() != '[') {
						isTrue = 0;
						break;
					}
				}

			}
			System.out.println("#" + t + " " + isTrue);
		}
		sc.close();
	}
}
