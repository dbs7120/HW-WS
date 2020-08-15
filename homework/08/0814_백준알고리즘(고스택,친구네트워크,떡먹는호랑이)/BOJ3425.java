package d0815;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 고스택
// 각 프로그램은 명령어에따라 프로그램수만큼 각각 독립적 결과 가짐!
public class BOJ3425 {

	static Stack<Integer>[] st; // 연산결과저장용 스택
	static Queue<String> cmdQ; // 명령어 저장용 큐
	static int programCnt;
	static int[] startProgram; // 프로그램시작시 처음 넣을 정수값
	static boolean[] canProgress; // 프로그램 종료체크 Boolean형 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		loop: while (true) {

			// 명령어 저장큐 초기화
			cmdQ = new LinkedList<>();
			while (true) {
				String input = sc.nextLine();
				if (input.equals("QUIT")) { // 프로그램 종료 체크
					sc.close();
					break loop;
				}
				if (input.equals("END")) // 각 문단 명령어 종료 체크
					break;
				cmdQ.offer(input);
			}

			programCnt = sc.nextInt();

			// 각 저장요소들 초기화
			startProgram = new int[programCnt];
			canProgress = new boolean[programCnt];
			st = new Stack[programCnt];
			for (int i = 0; i < programCnt; i++) {
				startProgram[i] = sc.nextInt();
				st[i] = new Stack<>();
				st[i].push(startProgram[i]); // 초기 스택 저장값 넣기
				canProgress[i] = true;
			}

			// 각 명령어들만큼 프로그램갯수만큼 독립적으로 예외처리 및 연산
			// 예외처리항목 : 0으로나누기, 연산결과 절대값 10억 이하값만 가능, div,mod시 음수 체크, 스택 isEmpty및 pop 가능여부

			for (int i = 0; i < programCnt; i++) {
				while (!cmdQ.isEmpty()) {
					String temp = cmdQ.poll(); // 명령어 poll
					if (temp.contains("NUM")) { // NUM 명령어의 경우 추가인자가 있어 추가 값 확인필요함
						num(temp);
					} else {
						switch (temp) {
						case "POP":
							pop();
							break;
						case "INV":
							inv();
							break;
						case "DUP":
							dup();
							break;
						case "SWP":
							swp();
							break;
						case "ADD":
							add();
							break;
						case "SUB":
							sub();
							break;
						case "MUL":
							mul();
							break;
						case "DIV":
							div();
							break;
						case "MOD":
							mod();
							break;
						}
					}
				}
			}

			for (int j = 0; j < programCnt; j++) {
				if (st[j].size() == 1 && canProgress[j]) { // 정상 결과조건
					int temp = st[j].pop();
					System.out.println(temp);
				} else {
					System.out.println("ERROR"); // 스택 비거나 2이상이면 ERROR
				}
			}
			System.out.println();
		}
	}

	// 1번: 스택 최상단 값, 2번: 1번 다음 값

	// NUM : value 값 넣기
	private static void num(String temp) {
		// NUM 명령어 형식 : NUM value
		int pushNum = Integer.parseInt(temp.substring(4, temp.length())); // 명령어에서 숫자 추출
		for (int i = 0; i < programCnt; i++) {
			if (canProgress[i])
				st[i].push(pushNum);
		}
	}

	// POP : 1번 빼기
	private static void pop() {
		for (int i = 0; i < programCnt; i++) {
			if (!st[i].isEmpty() && canProgress[i])
				st[i].pop();
			else
				canProgress[i] = false;
		}
	}

	// INV : 1번의 부호 변경
	private static void inv() {
		for (int i = 0; i < programCnt; i++) {
			if (!st[i].isEmpty() && canProgress[i]) {
				int invNum = st[i].pop();
				st[i].push(-invNum);
			} else
				canProgress[i] = false;
		}
	}

	// DUP : 1번을 복제하여 다시넣기
	private static void dup() {
		for (int i = 0; i < programCnt; i++) {
			if (!st[i].isEmpty() && canProgress[i]) {
				int dupNum = st[i].peek();
				st[i].push(dupNum);
			} else {
				canProgress[i] = false;
			}
		}
	}

	// SWP : 1번과 2번 값 교환
	private static void swp() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				st[i].push(y);
				st[i].push(x);
			} else
				canProgress[i] = false;
		}
	}

	// ADD : 1번과 2번 더하기 (연산결과 절대값 10억 이하값만 정상값)
	private static void add() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				long add = (long) x + (long) y;
				if (Math.abs(add) > 1000000000) // 연산 결과는 절대값 10억 이하만 정상
					canProgress[i] = false;
				else
					st[i].push(x + y);
			} else
				canProgress[i] = false;
		}
	}

	// SUB : 2번 - 1번 (연산결과 절대값 10억 이하값만 정상값)
	private static void sub() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				long sub = (long) x - (long) y;
				if (Math.abs(sub) > 1000000000)
					canProgress[i] = false;
				else
					st[i].push(x - y);
			} else
				canProgress[i] = false;
		}
	}

	// MUL : 1번 X 2번 (연산결과 절대값 10억 이하값만 정상값)
	private static void mul() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				long multiply = (long) x * (long) y;
				if (Math.abs(multiply) > 1000000000)
					canProgress[i] = false;
				else
					st[i].push(x * y);
			} else
				canProgress[i] = false;
		}
	}

	// DIV : 1번 / 2번
	private static void div() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				if (y == 0) { // div by 0 오류 체크
					canProgress[i] = false;
				} else {
					int div = Math.abs(x) / Math.abs(y);
					if ((x < 0 && y > 0) || (x > 0 && y < 0)) // 나누기 음수 규칙
						div = -div;
					st[i].push(div);
				}
			} else
				canProgress[i] = false;
		}
	}

	// MOD : 1번 % 2번
	private static void mod() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				if (y == 0) { // div by 0 오류 체크
					canProgress[i] = false;
				} else {
					int mod = Math.abs(x) % Math.abs(y);
					if (x < 0) // 모듈로 음수 규칙
						mod = -mod;
					st[i].push(mod);
				}
			} else
				canProgress[i] = false;
		}
	}

}
