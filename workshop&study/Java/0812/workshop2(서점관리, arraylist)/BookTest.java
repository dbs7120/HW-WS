package d0810.workshop2;

import java.util.Calendar;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		IBookMgr mgr = BookMgrImpl.getInstance();
		Scanner sc = new Scanner(System.in);
		int menu;

		// init sample
		mgr.add(new Book(5675, "나미야잡화점의기적", "히가시노게이고", "Ssafy1", 20000, "베스트셀러"));
		mgr.add(new Book(7777, "벚꽃지는 계절에 그대를 그리워하네", "우타노쇼고", "Ssafy1", 18000, "미스테리"));
		mgr.add(new Book(4949, "모방범", "미야베미유키", "Ssafy1", 30000, "미스테리/추리"));
		mgr.add(new Book(3333, "Y의비극", "엘러리 퀸", "Ssafy1", 15000, "미스테리/추리"));

		mgr.add(new Magazine(7893, "월간과학지", "NASA출판사", "NASA", 5000, "7월호", 2020, 7));
		mgr.add(new Magazine(7898, "Time", "time", "time", 6000, "8월호", 2019, 8));
		mgr.add(new Magazine(7899, "Time", "time", "time", 6000, "9월호", 2019, 9));

		int isbn;
		String title;
		String author;
		String publisher;
		int price;
		String desc;
		Calendar cal = Calendar.getInstance();

		// start program
		while (true) {
			System.out.println("<<< 도서관리 프로그램 >>>");
			System.out.println("1. 도서추가");
			System.out.println("2. 도서검색");
			System.out.println("0. 종료");
			menu = sc.nextInt();

			switch (menu) {
			// start Create
			case 1:
				System.out.print(">일반 도서는 1번 잡지는 2번을 입력하세요: ");
				int category = sc.nextInt();
				if (category != 1 && category != 2) {
					System.out.println("입력값 오류!");
					break;
				}
				System.out.print(">ISBN: ");
				isbn = sc.nextInt();
				sc.nextLine();

				System.out.print(">책 제목: ");
				title = sc.nextLine();

				System.out.print(">책 가격: ");
				price = sc.nextInt();
				sc.nextLine();

				System.out.print(">작가: ");
				author = sc.nextLine();

				System.out.print(">출판사: ");
				publisher = sc.nextLine();

				System.out.print(">설명: ");
				desc = sc.nextLine();

				if (category == 1) {

					mgr.add(new Book(isbn, title, author, publisher, price, desc));

				} else {
					int year, month;
					System.out.print(">출판 년도: ");
					year = sc.nextInt();
					sc.nextLine();
					System.out.print(">출판 월: ");
					month = sc.nextInt();
					sc.nextLine();
					mgr.add(new Magazine(isbn, title, author, publisher, price, desc, year, month));
				}

				break;
			// end Create

			// start Read
			case 2:
				while (true) {
					System.out.println("1. 보유 도서 전체 검색");
					System.out.println("2. ISBN으로 검색");
					System.out.println("3. 제목으로 검색");
					System.out.println("4. 보유중인 책확인");
					System.out.println("5. 보유중인 잡지확인");
					System.out.println("6. 보유중인 올해의 잡지확인(" + cal.get(Calendar.YEAR) + "년)");
					System.out.println("5. 출판사로 검색");
					System.out.println("8. 가격으로 검색");
					System.out.println("9. 보유중인 도서 금액 합계");
					System.out.println("10. 보유중인 도서 금액 평균");
					System.out.println("0. 뒤로가기");

					int readMenu = sc.nextInt();
					sc.nextLine();

					switch (readMenu) {
					case 1:
						System.out.println(">보유 도서 전체 출력");
						mgr.showAll();
						break;
					case 2:
						System.out.println(">ISBN으로 검색");
						System.out.print(">ISBN: ");
						isbn = sc.nextInt();
						sc.nextLine();
						System.out.println(mgr.searchByIsbn(isbn));
						break;
					case 3:
						System.out.println(">제목으로 검색");
						System.out.print(">책 제목(부분검색가능): ");
						title = sc.nextLine();
						for (Book e : mgr.searchByTitle(title)) {
							if (e != null) {
								System.out.println(e);
							}
						}
						break;
					case 4:
						System.out.println(">보유중인 책확인");
						mgr.searchBooks();
						break;
					case 5:
						System.out.println(">보유중인 잡지확인");
						mgr.searchMagazine();
						break;

					case 6:

						int year = cal.get(Calendar.YEAR);
						mgr.searchMagazineYear(year);
						break;

					case 7:
						System.out.println(">출판사로 검색");
						System.out.print(">출판사: ");
						publisher = sc.nextLine();
						for (Book e : mgr.searchByPublisher(publisher)) {
							if (e != null) {
								System.out.println(e);
							}
						}
						break;
					case 8:
						System.out.println(">가격으로 검색");
						System.out.print(">가격: ");
						price = sc.nextInt();
						sc.nextLine();
						System.out.println(String.format(">%,d원이하 모든책", price));
						mgr.searchUnderPrice(price);
						break;
					case 9:
						System.out.println(">보유중인 도서 금액 합계");
						System.out.println(String.format(">%,d원", mgr.getTotalPrice()));
						break;
					case 10:
						System.out.println(">보유중인 도서 금액 평균");
						System.out.println(String.format(">%,d원", mgr.getAveragePrice()));
						break;

					case 0:
						break;

					}
					if (readMenu == 0)
						break;
				}

				break;
			// end Read
			case 0:
				break;
			}
			if (menu == 0)
				break;

		} // end program
		sc.close();

	}

}
