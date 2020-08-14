package d0813.homework;

public class News {
	private String title;
	private String desc;
	private String link;
	private String guid;

	public News() {
		super();
	}

	public News(String title, String desc, String link, String guid) {
		super();
		this.title = title;
		this.desc = desc;
		this.link = link;
		this.guid = guid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "News [guid=" + guid + ", title=" + title + ", link=" + link + ", desc=" + desc + "]";
	}

}
