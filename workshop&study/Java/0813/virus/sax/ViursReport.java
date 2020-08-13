package d0813.virus.sax;

//<virus-report>
//<author>SSAFY</author>
//<about>COVID-19</about>
//<date>
//	<year>2020</year>
//	<month>03</month>
//	<day>26</day>
//</date>
//</virus-report>

public class ViursReport {
	private String author;
	private String about;
	private SDate date;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public SDate getDate() {
		return date;
	}

	public void setDate(SDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ViursReport [author=" + author + ", about=" + about + ", date=" + date + "]";
	}

}
