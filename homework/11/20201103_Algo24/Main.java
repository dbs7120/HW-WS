package d1103;

import java.awt.Point; // pair
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경비원 {
	static int X, Y, cnt; // 가로 세로 상점수
	static Point[] store; // 상점

	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(br.readLine().trim());
		store = new Point[cnt];
		int dir, len;

		// 상점들 방향/위치 입력
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dir = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			store[i] = new Point(dir, len);
		}

		// 동근이 방향/위치 입력
		st = new StringTokenizer(br.readLine(), " ");
		int dgdir = Integer.parseInt(st.nextToken());
		int dglen = Integer.parseInt(st.nextToken());

		for (int i = 0; i < cnt; i++) {
			dir = store[i].x;
			len = store[i].y;

			switch (dgdir) { // 동근이 방향에 따른 분기

			case 1: // 북동근
				switch (dir) { // 상점 방향에 따른 분기
				case 1: // 동일선상
					result += Math.abs(dglen - len);
					break;
				case 2: // 마주보는경우
					result += Y + Math.min(dglen + len, X - dglen + X - len);
					break;
				case 3: // ┌ 형태
					result += dglen + len;
					break;
				case 4: // ┐ 형태
					result += X - dglen + len;
					break;
				}
				break;

			case 2: // 남동근
				switch (dir) {
				case 1: // 마주보는경우
					result += Y + Math.min(dglen + len, X - dglen + X - len);
					break;
				case 2: // 동일선상
					result += Math.abs(dglen - len);
					break;
				case 3: // └ 형태
					result += dglen + Y - len;
					break;
				case 4: // ┘ 형태
					result += X - dglen + Y - len;
					break;
				}
				break;

			case 3: // 서동근
				switch (dir) {
				case 1: // ┌ 형태
					result += dglen + len;
					break;
				case 2: // └ 형태
					result += Y - dglen + len;
					break;
				case 3: // 동일선상
					result += Math.abs(dglen - len);
					break;
				case 4: // 마주보는경우
					result += X + Math.min(dglen + len, Y - dglen + Y - len);
					break;
				}
				break;

			case 4: // 동동근
				switch (dir) {
				case 1: // ┐ 형태
					result += dglen + X - len;
					break;
				case 2: // ┘ 형태
					result += Y - dglen + X - len;
					break;
				case 3: // 마주보는경우
					result += X + Math.min(dglen + len, Y - dglen + Y - len);
					break;
				case 4: // 동일선상
					result += Math.abs(dglen - len);
					break;
				}
				break;

			} // end outter switch
		} // end for
		System.out.println(result);

	}

}