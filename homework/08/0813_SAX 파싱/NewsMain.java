package d0813.homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsMain {

	private Scanner sc = new Scanner(System.in);
	private NewsDASOSAXImpl impl = null;
	private DefaultHandler handler = null;

	public static void main(String[] args) {

		new NewsMain();

	}

	public NewsMain() {
		execute();
		sc.close();

	}

	public void execute() {
		File file = new File("./src/d0813/homework/Section902.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		impl = new NewsDASOSAXImpl();
		handler = impl.new SAXHandler();
		try {
			parser = factory.newSAXParser();
			parser.parse(file, handler);

		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
		while (true) {
			int menu = choiceMenu();
			switch (menu) {
			case 1:
				showList();
				break;
			case 2:
				System.out.print("뉴스번호 : ");
				String newsNum = sc.next();
				detailNews(newsNum);
				break;
			case 0:
				break;
			}
			if (menu == 0)
				break;
		}

	}

	private int choiceMenu() {
		System.out.println("-------------------------");
		System.out.println("뉴스 정보");
		System.out.println("-------------------------");
		System.out.println("1. 뉴스 전체 조회");
		System.out.println("2. 상세 조회");
		System.out.println("0. 종료");
		System.out.println("-------------------------");
		System.out.print("선택 : ");
		int menu = sc.nextInt();
		return menu;
	}

	public void showList() {
		for (News e : impl.getNewsList())
			System.out.println(e.toString());
	}

	private void detailNews(String newsNum) {
		News news = impl.search(newsNum);
		if (news != null) {
			System.out.println("제목: " + news.getTitle());
			System.out.println("내용: " + news.getDesc());
			System.out.println("링크: " + news.getLink());
			System.out.print("뉴스페이지 이동하기 (Y/N) : ");
			char ch = sc.next().charAt(0);
			if (ch == 'Y' || ch == 'y') {
				Runtime exe = Runtime.getRuntime();
				try {
					exe.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + news.getLink());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("존재하지 않는 뉴스번호 입니다.");
		}

	}

}
