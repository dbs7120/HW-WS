package d0803;

import java.util.ArrayList;
import java.util.Scanner;

// 암호문 1
public class workshop1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			ArrayList<Integer> password = new ArrayList<Integer>();

			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				password.add(sc.nextInt());
			}

			int I = sc.nextInt(); // 명령어 갯수
			for (int i = 0; i < I; i++) {
				char temp = sc.next().charAt(0);
				int start = sc.nextInt(); // x: 앞에서부터 위치
				int appendCnt = sc.nextInt(); // y: 삽입 숫자수
				for (int j = 0; j < appendCnt; j++) {
					password.add(j + start, sc.nextInt());
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(password.get(i) + " ");
			}
			System.out.println();
		}
		sc.close();

	}

}
