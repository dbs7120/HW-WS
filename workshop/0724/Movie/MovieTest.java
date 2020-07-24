package com.ssafy.Movie;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {

		MovieMgr mgr = MovieMgr.getInstance();

		Scanner sc = new Scanner(System.in);
		int menu;
		while (true) {
			System.out.println("<<<  영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			menu = sc.nextInt();
			sc.nextLine();

			String title, director, genre, summary;
			int grade;
			switch (menu) {
			case 1:
				System.out.print(">영화 제목: ");
				title = sc.nextLine();
				System.out.print(">영화 감독: ");
				director = sc.nextLine();
				System.out.print(">영화 등급: ");
				grade = sc.nextInt();
				sc.nextLine();
				System.out.print(">영화 장르: ");
				genre = sc.nextLine();
				System.out.print(">기타: ");
				summary = sc.nextLine();
				mgr.add(new Movie(title, director, grade, genre, summary));
				break;
			case 2:
				System.out.println(">영화 정보 전체 검색");
				for (Movie m : mgr.search()) {
					if (m != null)
						System.out.println(m);
				}
				break;
			case 3:
				System.out.println(">영화명 검색");
				System.out.print(">영화제목 입력: ");
				title = sc.nextLine();
				for (Movie m : mgr.search(title)) {
					if (m != null) {
						System.out.println(m);
					}
				}
				break;
			case 4:
				System.out.println(">영화 장르별 검색");
				System.out.print(">영화장르 입력: ");
				genre = sc.nextLine();
				for (Movie m : mgr.searchGenre(genre)) {
					if (m != null) {
						System.out.println(m);
					}
				}
				break;
			case 5:
				System.out.println(">영화 정보 삭제");
				System.out.print(">영화제목 입력: ");
				title = sc.nextLine();
				mgr.delete(title);
				break;
			case 0:
				System.out.println("프로그램 종료");
				break;
			}

			if (menu == 0)
				break;

		}

	}

}
