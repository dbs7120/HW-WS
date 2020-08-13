package d0813.virus.sax;

//<date>
//	<year>2020</year>
//	<month>03</month>
//	<day>26</day>
//</date>

public class SDate {
	private int year;
	private int month;
	private int day;

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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "SDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

}
