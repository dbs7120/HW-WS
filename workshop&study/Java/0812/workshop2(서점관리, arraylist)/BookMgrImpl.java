package d0810.workshop2;

import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {
	// private Book[] books = new Book[200];

	private ArrayList<Book> books = new ArrayList<Book>();

	static BookMgrImpl bookmgr = null;

	private BookMgrImpl() {

	}

	static BookMgrImpl getInstance() {
		if (bookmgr == null) {
			bookmgr = new BookMgrImpl();
		}
		return bookmgr;
	}

	@Override
	public void add(Book book) {
		if (book instanceof Magazine) { // 잡지일경우
			Magazine mag = new Magazine(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(),
					book.getPrice(), book.getDesc(), ((Magazine) book).getYear(), ((Magazine) book).getMonth());
			books.add(mag);
		} else {
			Book bok = new Book(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPrice(),
					book.getDesc());
			books.add(bok);

		}
	}

	@Override
	public void showAll() {
		if (books.isEmpty()) {
			System.out.println("저장된 책이 없습니다.");
			return;
		}
		for (Book e : books) {
			if (e != null) {
				System.out.println(e.toString());
			}
		}
	}

	@Override
	public Book searchByIsbn(int isbn) {
		for (Book e : books) {
			if (e == null)
				break;
			if (e.getIsbn() == isbn)
				return e;
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		Book[] temp = new Book[200];
		int cnt = 0;
		for (Book e : books) {
			if (e == null)
				break;
			if (e.getTitle().contains(title)) {
				temp[cnt] = e;
				cnt++;
			}
		}
		return temp;
	}

	@Override
	public void searchBooks() {
		boolean check = false;
		for (Book e : books) {
			if (!(e instanceof Magazine)) {
				System.out.println(e.toString());
				check = true;
			}
		}
		if (!check)
			System.out.println("책이 존재하지 않습니다.");
	}

	@Override
	public void searchMagazine() {
		boolean check = false;
		for (Book e : books) {
			if (e instanceof Magazine) {
				System.out.println(e.toString());
				check = true;
			}
		}
		if (!check)
			System.out.println("잡지가 존재하지 않습니다.");
	}

	@Override
	public Book[] searchByPublisher(String publisher) {
		Book[] temp = new Book[200];
		int cnt = 0;
		for (Book e : books) {
			if (e == null)
				break;
			if (e.getPublisher() == publisher) {
				temp[cnt] = e;
				cnt++;
			}
		}
		return temp;
	}

	@Override
	public Book[] searchUnderPrice(int price) {
		Book[] temp = new Book[200];
		int cnt = 0;
		for (Book e : books) {
			if (e == null)
				break;
			if (e.getPrice() <= price) {
				temp[cnt] = e;
				cnt++;
			}
		}
		return temp;
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book e : books) {
			if (e == null)
				break;
			total += e.getPrice();
		}
		return total;
	}

	@Override
	public int getAveragePrice() {
		int avg = 0;
		for (Book e : books) {
			if (e == null)
				break;
			avg += e.getPrice();
		}
		return avg / books.size();
	}

	@Override
	public void searchMagazineYear(int year) {
		boolean check = false;
		for (Book e : books) {
			if (e instanceof Magazine && ((Magazine) e).getYear() == year) {
				System.out.println(e.toString());
				check = true;
			}

		}
		if (!check)
			System.out.println("올해의 잡지가 존재하지 않습니다.");
	}

}
