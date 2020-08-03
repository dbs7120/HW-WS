import java.util.Scanner;
import java.util.Stack;

public class Solution {
	// 연산자 *, + 두가지만 생각, 괄호X
	// 연산자 우선순위 : * > +

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String str = sc.next();
			// System.out.println(toPostFix(str));
			System.out.println("#" + t + " " + calc(toPostFix(str)));
		}
		sc.close();

	}

	static int calc(String str) { // 후위식 계산
		Stack<Integer> cal = new Stack<>();
		int op1, op2;
		for (int i = 0; i < str.length(); i++) {

			char temp = str.charAt(i);

			if ('1' <= temp && temp <= '9') {
				cal.push(temp - '0');
			} else {
				op2 = cal.pop();
				op1 = cal.pop();
				if (temp == '*') {
					cal.push(op1 * op2);
				} else if (temp == '+') {
					cal.push(op1 + op2);
				}
			}
		}
		return cal.pop();

	}

	static int checkOper(char op) { // 연산자 우선순위 확인용
		return op == '*' ? 1 : 0; // * : return 1 // + : return 0
	}

	static String toPostFix(String str) { // 중위표기 => 후위표기
		String post = "";
		Stack<Character> st = new Stack<>();
		char temp;
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if ('1' <= temp && temp <= '9') {
				post += temp;
			}
			if (temp == '+' || temp == '*') {
				while (!st.isEmpty() && checkOper(temp) <= checkOper(st.peek())) {
					post += st.pop();
				}
				st.push(temp);
			}
		}

		while (!st.isEmpty()) {
			post += st.pop();
		}
		return post;
	}

}
