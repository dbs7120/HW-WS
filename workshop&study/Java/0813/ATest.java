package d0813;

import java.io.FileWriter;
import java.io.IOException;
public class ATest {
	public static void main(String[] args) {
		FileWriter fw = null; // 파일로 저장
		try {
			fw = new FileWriter("sam.txt", true);
			System.out.println("성공");
		} catch (IOException e) {
			System.out.println("오류: " + e);
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("");
				}
			}
		}
		System.out.println("end");
	}
}
