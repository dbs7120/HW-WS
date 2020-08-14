package com.ssafy.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDao {

	private List<News> list = new ArrayList<News>();

	@Override
	public List<News> getNewsList(String url) {

		connectNews(url);
		for (News e : list)
			System.out.println(e.getTitle());

		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private void connectNews(String url) {
		DefaultHandler handler = new SAXHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;

		try {
			parser = factory.newSAXParser();
			parser.parse(url, handler);

		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}

	}

	public class SAXHandler extends DefaultHandler {
		StringBuilder b;
		boolean flag = false;
		News n = null; // 0...1

		SAXHandler() {
			super();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			switch (qName) {
			case "item":
				n = new News();
				flag = true;
				break;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {

			if (qName.equals("title") && flag) {
				n.setTitle(b.toString());
			} else if (qName.equals("description") && flag) {
				n.setDesc(b.toString());
			} else if (qName.equals("link") && flag) {
				n.setLink(b.toString());
				list.add(n);
			}

		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			b = new StringBuilder();
			b.append(new String(ch, start, length));
		}

	}

}
