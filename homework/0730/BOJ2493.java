package d0730;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// N:5
// 6 9 5 7 4	입력값, 스택 peek 값 비교진행
// 6 입력										=>  isEmpty로인해 종료, 0출력	=>	push(6,0)
// 9 입력	9 < 6	False, pop					=>	isEmpty로인해 종료, 0출력	=>	push(9,1)
// 5 입력	5 < 9 	True						=> 	9인덱스(1)+1 = 2출력		=>	push(5,2)
// 7 입력	7 < 5 	False, pop => 7 < 9 True	=>	9인덱스(1)+1 = 2출력		=>	push(7,3)
// 4 입력	4 < 7 	True						=>  7인덱스(3)+1 = 4출력		=>	push(4,4)
// 종료


// N:7
// 8 7 6 5 6 7 8	입력값, 스택 peek 값 비교진행
//
// 8 입력																				=>  isEmpty로인해 종료, 0출력	=>	push(8,0)
// 7 입력	7 < 8	True																=>	8인덱스(0)+1 = 1출력		=>	push(7,1)
// 6 입력	6 < 7 	True																=>	7인덱스(1)+1 = 2출력		=>	push(6,2)
// 5 입력	5 < 6 	True																=>	6인덱스(2)+1 = 3출력		=>	push(5,3)
// 6 입력	6 < 5 	False, pop => 6 < 6 False, pop => 6 < 7 True						=> 	7인덱스(1)+1 = 2출력		=>	push(6,4)
// 7 입력	7 < 6 	False, pop => 7 < 5 False, pop => 7 < 7	False, pop => 7 < 8 True	=>  8인덱스(0)+1 = 1출력		=>	push(7,5)
// 8 입력	8 < 8 	False, pop => 7 < 9 False, pop => 8 < 7 False ... 8 < 8 False, pop	=>	isEmpty로인해 종료, 0출력	=>	push(8,6)
// 종료

public class BOJ2493 {

	public static void main(String[] args) throws IOException {
		// I/O
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 탑의 크기, 탑의 첨자 저장하는 정수형 배열(입력값, index) 스택
		Stack<int[]> top = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);

		for (int i = 0; i < N; i++) {

			int input = Integer.parseInt(stk.nextToken());

			while (!top.isEmpty()) {
				if (input < top.peek()[0]) { // 수신 가능한 탑이 있으면
					bw.write((top.peek()[1] + 1) + " "); // index값이 1부터이므로 +1
					break;	// 조건 만족시 바로 break로 반복문 탈출
				}
				top.pop();
			}

			if (top.isEmpty()) // 스택 다나올때까지 입력값보다 큰 값 찾지 못하면
				bw.write(0 + " "); // 0으로

			top.push(new int[] { input, i });	// 입력값, 입력인덱스 배열을 스택에 넣기
		}

		bw.flush();
		bw.close();

	}

}
