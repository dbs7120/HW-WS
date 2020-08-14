package d0813.homework;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDASOSAXImpl implements INewsDAO {

	private List<News> list = new ArrayList<News>(); // ~list

	public NewsDASOSAXImpl() {

	}

	@Override
	public List<News> getNewsList() {
		return list;
	}

	@Override
	public News search(String word) {
		News temp = null;
		for (News e : list) {
			if (e.getGuid().equals(word))
				temp = e;
		}

		return temp;
	}

	class SAXHandler extends DefaultHandler {
		StringBuilder b;
		boolean flag = false;
		News news = null; // 0...1

		SAXHandler() {
			super();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			switch (qName) {
			case "item":
				news = new News();
				flag = true;
				break;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {

			if (qName.equals("title") && flag) {
				news.setTitle(b.toString());
			} else if (qName.equals("description") && flag) {
				news.setDesc(b.toString());
			} else if (qName.equals("link") && flag) {
				news.setLink(b.toString());
			} else if (qName.equals("guid") && flag) {
				news.setGuid(b.toString());
			} else if (qName.equals("item") && flag) {
				list.add(news);
			}

		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			b = new StringBuilder();
			b.append(new String(ch, start, length));
		}

	}

}
