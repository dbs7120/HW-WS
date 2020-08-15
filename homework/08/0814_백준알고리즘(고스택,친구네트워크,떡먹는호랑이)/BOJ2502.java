package d0815;
import java.util.Scanner;

// 떡 먹는 호랑이

// 떡의개수(K) = fibo(x)*A + fibo(y)*B
// 41 = 2*X + 7*y
// 2 | 7 | 2+7=9 | 7+9=16 | 9+16=25 | 16+25=41 || 25+41=66
// 1:A 		2
// 2:B 		7
// 3:A+B 	2+7
// 4:A+2B 	1*2+2*7
// 5:2A+3B 	2*2+3*7
// 6:3A+5B 	3*2+5*7
// 7:5A+8B 	5*2+8*7
// ...
// A의 계수(fiboA): 1,0,1,1,2,3,5,8,13,....
// B의 계수(fiboB): 0,1,1,2,3,5,8,13,21,....
// 41 = fiboA(6-1) * 2 + fiboB(6-1) * 7 = 3*2 + 5*7
// K = fiboA(day-1) * A + fiboB(day-1) * B
// 날짜의 입력 최대값 : 30 => 피보나치재귀가능

public class BOJ2502 {

	static int day;
	static int K;
	static int[] fiboArrA;
	static int[] fiboArrB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		day = sc.nextInt(); // 넘어온 날
		K = sc.nextInt(); // day번째날에 호랑이에게 준 떡 수

		fiboArrA = new int[day];
		fiboArrB = new int[day];

		fiboArrA[0] = 1;
		fiboArrA[1] = 0;
		
		for (int i = 2; i < day; i++) 
			fiboArrA[i] = fiboA(i);
		
		for (int i = 1; i < day; i++) 
			fiboArrB[i] = fiboB(i);
		

		int sum = 0;

		loop: for (int i = 1; i * fiboArrA[day - 1] < K; i++) {
			for (int j = 1; j * fiboArrA[day - 1] < K; j++) {
				sum = i * fiboArrA[day - 1] + j * fiboArrB[day - 1];
				if (sum == K) {
					System.out.println(i);
					System.out.println(j);
					break loop;
				}
			}
		}
	}

	public static int fiboA(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else
			return fiboA(n - 1) + fiboA(n - 2);
	}

	public static int fiboB(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fiboB(n - 1) + fiboB(n - 2);
	}

}
