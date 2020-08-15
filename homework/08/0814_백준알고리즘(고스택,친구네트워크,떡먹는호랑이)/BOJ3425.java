package d0815;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// ����
// �� ���α׷��� ��ɾ���� ���α׷�����ŭ ���� ������ ��� ����!
public class BOJ3425 {

	static Stack<Integer>[] st; // ����������� ����
	static Queue<String> cmdQ; // ��ɾ� ����� ť
	static int programCnt;
	static int[] startProgram; // ���α׷����۽� ó�� ���� ������
	static boolean[] canProgress; // ���α׷� ����üũ Boolean�� �迭

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		loop: while (true) {

			// ��ɾ� ����ť �ʱ�ȭ
			cmdQ = new LinkedList<>();
			while (true) {
				String input = sc.nextLine();
				if (input.equals("QUIT")) { // ���α׷� ���� üũ
					sc.close();
					break loop;
				}
				if (input.equals("END")) // �� ���� ��ɾ� ���� üũ
					break;
				cmdQ.offer(input);
			}

			programCnt = sc.nextInt();

			// �� �����ҵ� �ʱ�ȭ
			startProgram = new int[programCnt];
			canProgress = new boolean[programCnt];
			st = new Stack[programCnt];
			for (int i = 0; i < programCnt; i++) {
				startProgram[i] = sc.nextInt();
				st[i] = new Stack<>();
				st[i].push(startProgram[i]); // �ʱ� ���� ���尪 �ֱ�
				canProgress[i] = true;
			}

			// �� ��ɾ�鸸ŭ ���α׷�������ŭ ���������� ����ó�� �� ����
			// ����ó���׸� : 0���γ�����, ������ ���밪 10�� ���ϰ��� ����, div,mod�� ���� üũ, ���� isEmpty�� pop ���ɿ���

			for (int i = 0; i < programCnt; i++) {
				while (!cmdQ.isEmpty()) {
					String temp = cmdQ.poll(); // ��ɾ� poll
					if (temp.contains("NUM")) { // NUM ��ɾ��� ��� �߰����ڰ� �־� �߰� �� Ȯ���ʿ���
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
				if (st[j].size() == 1 && canProgress[j]) { // ���� �������
					int temp = st[j].pop();
					System.out.println(temp);
				} else {
					System.out.println("ERROR"); // ���� ��ų� 2�̻��̸� ERROR
				}
			}
			System.out.println();
		}
	}

	// 1��: ���� �ֻ�� ��, 2��: 1�� ���� ��

	// NUM : value �� �ֱ�
	private static void num(String temp) {
		// NUM ��ɾ� ���� : NUM value
		int pushNum = Integer.parseInt(temp.substring(4, temp.length())); // ��ɾ�� ���� ����
		for (int i = 0; i < programCnt; i++) {
			if (canProgress[i])
				st[i].push(pushNum);
		}
	}

	// POP : 1�� ����
	private static void pop() {
		for (int i = 0; i < programCnt; i++) {
			if (!st[i].isEmpty() && canProgress[i])
				st[i].pop();
			else
				canProgress[i] = false;
		}
	}

	// INV : 1���� ��ȣ ����
	private static void inv() {
		for (int i = 0; i < programCnt; i++) {
			if (!st[i].isEmpty() && canProgress[i]) {
				int invNum = st[i].pop();
				st[i].push(-invNum);
			} else
				canProgress[i] = false;
		}
	}

	// DUP : 1���� �����Ͽ� �ٽóֱ�
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

	// SWP : 1���� 2�� �� ��ȯ
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

	// ADD : 1���� 2�� ���ϱ� (������ ���밪 10�� ���ϰ��� ����)
	private static void add() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				long add = (long) x + (long) y;
				if (Math.abs(add) > 1000000000) // ���� ����� ���밪 10�� ���ϸ� ����
					canProgress[i] = false;
				else
					st[i].push(x + y);
			} else
				canProgress[i] = false;
		}
	}

	// SUB : 2�� - 1�� (������ ���밪 10�� ���ϰ��� ����)
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

	// MUL : 1�� X 2�� (������ ���밪 10�� ���ϰ��� ����)
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

	// DIV : 1�� / 2��
	private static void div() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				if (y == 0) { // div by 0 ���� üũ
					canProgress[i] = false;
				} else {
					int div = Math.abs(x) / Math.abs(y);
					if ((x < 0 && y > 0) || (x > 0 && y < 0)) // ������ ���� ��Ģ
						div = -div;
					st[i].push(div);
				}
			} else
				canProgress[i] = false;
		}
	}

	// MOD : 1�� % 2��
	private static void mod() {
		for (int i = 0; i < programCnt; i++) {
			if (st[i].size() >= 2 && canProgress[i]) {
				int y = st[i].pop();
				int x = st[i].pop();
				if (y == 0) { // div by 0 ���� üũ
					canProgress[i] = false;
				} else {
					int mod = Math.abs(x) % Math.abs(y);
					if (x < 0) // ���� ���� ��Ģ
						mod = -mod;
					st[i].push(mod);
				}
			} else
				canProgress[i] = false;
		}
	}

}
