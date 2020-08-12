package d0812.workshop3;

public interface IBookMgr {
	void add(Book book);

	void showAll();

	Book searchByIsbn(int isbn);

	Book[] searchByTitle(String title);

	void searchBooks();

	void searchMagazine();

	void searchMagazineYear(int year);

	Book[] searchByPublisher(String publisher);

	Book[] searchUnderPrice(int price);

	int getTotalPrice();

	int getAveragePrice();

	void sell(int isbn, int quantity) throws QuantityException, ISBNNotFoundException;

	void buy(int isbn, int quantity) throws ISBNNotFoundException;

}
