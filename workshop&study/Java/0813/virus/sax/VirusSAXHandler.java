package d0813.virus.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class VirusSAXHandler extends DefaultHandler {
	ViursReport report = null;
	String s;
	SDate date;

	public ViursReport getReport() {
		return report;
	}

//	@Override
//	public void startDocument() throws SAXException {
//		System.out.println("startDocument : ");
//	}
//
//	@Override
//	public void endDocument() throws SAXException {
//		System.out.println("endDocument : ");
//	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) { // 각 tag 이름에 따른 동작(startElement => 객체의 생성)
		case "virus-report":
			report = new ViursReport(); // 객체 생성
			break;
		case "date":
			date = new SDate();
			break;
		}
		// System.out.println("startElement : " + qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) { // 각 tag 이름에 따른 동작
		case "author":
			report.setAuthor(s);
			break;
		case "about":
			report.setAbout(s);
			break;
		case "year":
			date.setYear(Integer.parseInt(s));
			break;
		case "month":
			date.setMonth(Integer.parseInt(s));
			break;
		case "day":
			date.setDay(Integer.parseInt(s));
			break;
		case "date": // </date> 일때 date객체를 report객체 멤버로 넣기
			report.setDate(date);
			break;
		}

		// System.out.println("endElement : " + qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		s = new String(ch, start, length); // 문자배열을 String(문자열)으로 변경
		// System.out.println("characters : " + s);
	}

}
