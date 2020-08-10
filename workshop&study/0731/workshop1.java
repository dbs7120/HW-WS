import java.util.Scanner;

public class workshop1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int half;
			String[] cardH1 = new String[N]; // 카드 반나눈 앞부분
			String[] cardH2 = new String[N]; // 카드 반나눈 뒤부분

			if (N % 2 == 1) // N이 홀수면 먼저 놓는 쪽에 한장더
				half = N / 2 + 1;
			else
				half = N / 2;

			for (int i = 0; i < N; i++) {
				if (i < half)
					cardH1[i] = sc.next(); // 앞부분 입력받기
				else
					cardH2[i] = sc.next(); // 뒷부분 입력받기
			}
			
			// A B C D E F
			// cardH1 => A B C null null null
			// charH2 => null null null D E F
			int odd = 0, even = half;	// 짝수에 넣을 값은 반 이상부터 실제 입력값

			System.out.print("#" + t + " ");

			for (int i = 1; i <= N; i++) {
				if (i % 2 == 1) { // 출력할때 홀수번째면 cardH1
					System.out.print(cardH1[odd] + " ");
					odd++; // cardH1 개별 첨자
				}

				else { // 출력할때 짝수번째면 cardH2
					System.out.print(cardH2[even] + " ");
					even++; // cardH2 개별 첨자
				}

			}
			System.out.println();

		}
		sc.close();

	}

}
