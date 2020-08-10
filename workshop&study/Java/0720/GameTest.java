package com.ssafy;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {

		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요.");

		Scanner sc = new Scanner(System.in);
		int inputN = sc.nextInt();
		int win = 0, lose = 0, ai = 0;

		loop: while (true) {
			System.out.print("가위바위보 중 하나 입력:");
			String inputS = sc.next();
			ai = (int) (Math.random() * 3) + 1; // (컴퓨터) 가위:1, 바위:2, 보:3

			switch (inputS) {
			case "가위":
				if (ai == 2) {
					System.out.println("졌습니다!!!");
					lose++;
				} else if (ai == 3) {
					System.out.println("이겼니다!!!");
					win++;
				} else
					System.out.println("비겼습니다!!!");
				break;
			case "바위":
				if (ai == 1) {
					System.out.println("이겼니다!!!");
					win++;
				} else if (ai == 3) {
					System.out.println("졌습니다!!!");
					lose++;
				} else
					System.out.println("비겼습니다!!!");
				break;
			case "보":
				if (ai == 1) {
					System.out.println("졌습니다!!!");
					lose++;
				} else if (ai == 2) {
					System.out.println("이겼니다!!!");
					win++;
				} else
					System.out.println("비겼습니다!!!");
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
			System.out.println("### 사용자 승!!!");
		else
			System.out.println("### 컴퓨터 승!!!");

		sc.close();
	}
}
