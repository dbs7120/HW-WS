package d0810.workshop2;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		BookMgrImpl mgr = BookMgrImpl.getInstance();
		Scanner sc = new Scanner(System.in);
		int menu;

		// init sample
		mgr.add(new Book(5675, "나미야잡화점의기적", "히가시노게이고", "Ssafy1", 20000, "베스트셀러"));
		mgr.add(new Magazine(7894, "월간과학지", "NASA출판사", "NASA", 5000, "7월호", 2020, 7));

		int isbn;
		String title;
		String author;
		String publisher;
		int price;
		String desc;

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
					System.out.println("6. 출판사로 검색");
					System.out.println("7. 가격으로 검색");
					System.out.println("8. 보유중인 도서 금액 합계");
					System.out.println("9. 보유중인 도서 금액 평균");
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
						System.out.println(">출판사로 검색");
						System.out.print(">출판사: ");
						publisher = sc.nextLine();
						for (Book e : mgr.searchByPublisher(publisher)) {
							if (e != null) {
								System.out.println(e);
							}
						}
						break;
					case 7:
						System.out.println(">가격으로 검색");
						System.out.print(">가격: ");
						price = sc.nextInt();
						sc.nextLine();
						System.out.println(String.format(">%,d원이하 모든책", price));
						mgr.searchUnderPrice(price);
						break;
					case 8:
						System.out.println(">보유중인 도서 금액 합계");
						System.out.println(String.format(">%,d원", mgr.getTotalPrice()));
						break;
					case 9:
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
