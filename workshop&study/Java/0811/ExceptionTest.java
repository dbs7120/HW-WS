package d0811;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) {
		new ExceptionTest();
	}

	ExceptionTest() {
		aa();
	}

	void aa() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("aaa.txt")); // FileNotFoundException 발생가능
			int cnt = Integer.parseInt(reader.readLine()); // IOException 발생가능
		} catch (FileNotFoundException e) { // FileNotFoundException의 부모인 IOException, 그부모인 Exception으로 도 처리가능 하지만 CPU부하(시간)이 큼
			System.out.println("file 없음");
		} catch (IOException e) {	// 예외처리가 상속관계가 있다면 자식먼저 catch 이후 부모예외 catch하기
			System.out.println("읽기 오류");
		} catch (NullPointerException e) {
			System.out.println("null");
		}
	}

}
