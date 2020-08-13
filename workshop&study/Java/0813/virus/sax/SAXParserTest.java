package d0813.virus.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXParserTest {

	public static void main(String[] args) {
		new SAXParserTest();
	}

	public SAXParserTest() {
		// 자바에서 현재경로는 프로젝트최상단 에서 시작
		File file = new File("./src/d0813/virus/sax/virus-report.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;

		// 추가된 메소드를 받기위해(getReport()) 부모객체 변수로 사용 X
		VirusSAXHandler dh = new VirusSAXHandler();
		ViursReport report = null;
		try {
			parser = factory.newSAXParser();
			parser.parse(file, dh);
			report = dh.getReport();

		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}

		System.out.println(report);

		System.out.println("end");

	}

}
