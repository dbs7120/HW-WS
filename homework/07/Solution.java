import java.util.Scanner;

// N=4;				입력최종값 : N*N
// 1 2 3 4	size--  우측(x++)
// 5 6 7			하단(y++)
// 8 9 10	size--  좌측(x--)
// 11 12			상단(y--)
// 13 14	size--	우측(x++)
// 15				하단(y++)
// 16				좌측(y--)
public class Solution {
	static int N;
	static int[][] snail;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			snail = new int[N][N];
			int number = 1, size = N, x = -1, y = 0;

			while (number != (N * N + 1)) { // number가 N^2될때까지 반복

				for (int i = 0; i < size; i++) { // 우
					x++;
					snail[y][x] = number;
					number++;
				}
				size--;

				for (int i = 0; i < size; i++) { // 하
					y++;
					snail[y][x] = number;
					number++;
				}

				for (int i = 0; i < size; i++) { // 좌
					x--;
					snail[y][x] = number;
					number++;
				}
				size--;

				for (int i = 0; i < size; i++) { // 상
					y--;
					snail[y][x] = number;
					number++;
				}
			}

			System.out.println("#" + t + " ");

			for (int[] e : snail) {
				for (int f : e) {
					System.out.print(f + " ");
				}
				System.out.println();
			}
		}
		sc.close();

	}

}
