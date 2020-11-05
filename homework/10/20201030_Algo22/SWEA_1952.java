package d1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수영장
// 4달차의 경우
// 1. month[1] + month[2] + month[3] + month[4]
// 2. (1,2,3)3달권 + month[4]
// 3. month[1] + (2,3,4)3달권
// =>
// dp[n] = min(dp[n-1] + month[n], dp[n-3] + 3달권)
public class SWEA_1952 {

	static int input[], monthValue[], dp[]; // 입력, 한달기준 싼가격배열, dp테이블
	static int day, month, month3, year;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			month3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			// 1<=i<=12
			input = new int[13];
			monthValue = new int[13];
			dp = new int[13];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++)
				input[i] = Integer.parseInt(st.nextToken());

			// 각달의 1일권과 1달권중 싼 가격 저장
			for (int i = 1; i <= 12; i++)
				monthValue[i] = Math.min(input[i] * day, month);

			// dp2[n] = n 번째 날의 누적된 최소값
			for (int i = 1; i <= 12; i++) {
				dp[i] = dp[i - 1] + monthValue[i]; // 해당 달까지의 최소비용 + 1달권 가격
				if (i - 3 >= 0) // 3달넘는 경우 3달권과 비교
					dp[i] = Math.min(dp[i], dp[i - 3] + month3);
			}

			// 1년권 비교
			if (dp[12] > year)
				dp[12] = year;

//			for (int e : dp)
//				System.out.print(e + " ");
//			System.out.println();

			System.out.println("#" + t + " " + dp[12]);

		}

	}

}
