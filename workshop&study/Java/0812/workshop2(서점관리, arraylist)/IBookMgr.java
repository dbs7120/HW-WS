package d0810.workshop2;

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
}
