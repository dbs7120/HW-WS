package com.ssafy;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {

		System.out.println("���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ������.");
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		System.out.print("��ȣ�� �Է��ϼ���.");

		Scanner sc = new Scanner(System.in);
		int inputN = sc.nextInt();
		int win = 0, lose = 0, ai = 0;

		loop: while (true) {
			System.out.print("���������� �� �ϳ� �Է�:");
			String inputS = sc.next();
			ai = (int) (Math.random() * 3) + 1; // (��ǻ��) ����:1, ����:2, ��:3

			switch (inputS) {
			case "����":
				if (ai == 2) {
					System.out.println("�����ϴ�!!!");
					lose++;
				} else if (ai == 3) {
					System.out.println("�̰�ϴ�!!!");
					win++;
				} else
					System.out.println("�����ϴ�!!!");
				break;
			case "����":
				if (ai == 1) {
					System.out.println("�̰�ϴ�!!!");
					win++;
				} else if (ai == 3) {
					System.out.println("�����ϴ�!!!");
					lose++;
				} else
					System.out.println("�����ϴ�!!!");
				break;
			case "��":
				if (ai == 1) {
					System.out.println("�����ϴ�!!!");
					lose++;
				} else if (ai == 2) {
					System.out.println("�̰�ϴ�!!!");
					win++;
				} else
					System.out.println("�����ϴ�!!!");
				break;
			}

			switch (inputN) {
			case 1:
				if (win >= 3 || lose >= 3)
					break loop;
				break;
			case 2:
				if (win >= 2 || lose >= 2)
					break loop;
				break;
			case 3:
				if (win >= 1 || lose >= 1)
					break loop;
				break;
			}
		}

		if (win > lose)
			System.out.println("### ����� ��!!!");
		else
			System.out.println("### ��ǻ�� ��!!!");

		sc.close();
	}
}
