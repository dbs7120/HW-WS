package d0812.workshop3;

public class Magazine extends Book {

	private int year;
	private int month;

	public Magazine(int isbn, String title, String author, String publisher, int price, String desc, int year,
			int month, int quantity) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "ISBN: " + getIsbn() + " | 잡지 제목: " + getTitle() + " | 제품가격: " + String.format("%,d원", getPrice())
				+ " | 작가: " + getAuthor() + " | 출판사: " + getPublisher() + " | 책설명: " + getDesc() + " | 출판일: " + year
				+ "년" + month + "월 | 보유수량: " + getQuantity();
	}

}
