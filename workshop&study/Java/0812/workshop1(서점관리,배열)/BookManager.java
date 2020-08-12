package d0810.workshop;

public class BookManager {
	private Book[] books = new Book[200];
	private int index = 0;

	static BookManager bookmgr = null;

	private BookManager() {

	}

	static BookManager getInstance() {
		if (bookmgr == null) {
			bookmgr = new BookManager();
		}
		return bookmgr;
	}

	public void add(Book book) {
		if (book instanceof Magazine) { // 잡지일경우
			Magazine mag = new Magazine(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(),
					book.getPrice(), book.getDesc(), ((Magazine) book).getYear(), ((Magazine) book).getMonth());
			books[index] = mag;
			index++;
		} else {
			Book bok = new Book(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPrice(),
					book.getDesc());
			books[index] = bok;
			index++;

		}
	}

	public void showAll() {
		if (index == 0) {
			System.out.println("저장된 책이 없습니다.");

			return;
		}
		for (Book e : books) {
			if (e != null) {
				System.out.println(e.toString());
			}
		}
	}

	public Book searchByIsbn(int isbn) {
		for (Book e : books) {
			if (e == null)
				break;
			if (e.getIsbn() == isbn)
				return e;
		}
		return null;
	}

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

	public int getTotalPrice() {
		int total = 0;
		for (Book e : books) {
			if (e == null)
				break;
			total += e.getPrice();
		}
		return total;
	}

	public int getAveragePrice() {
		int avg = 0;
		for (Book e : books) {
			if (e == null)
				break;
			avg += e.getPrice();
		}
		return avg / index;
	}

}
