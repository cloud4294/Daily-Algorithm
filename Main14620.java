import java.util.Scanner;

/*
 *    Baekjoon Online Judge 14620번 - 꽃길
 * 
 * 	  https://www.acmicpc.net/problem/14620
 */


public class Main14620 {

	static int N;
	static int[][] map;
	static int[][] check;
	static int min;

	public static void solve(int depth) {

		if (depth == 3) {
			int count = 0;
			for (int k = 0; k < N; k++) {
				for (int k2 = 0; k2 < N; k2++) {
					if (check[k][k2] == 1) {
						count += map[k][k2];
					}
				}
			}
			
			if (count < min) {
				min = count;
			}

			return;
		}// 꽃잎의 갯수가 3개일때 비용을 검사하여 최소값보다 작으면 최소값을 교체한다.

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (check[i][j] == 0 && check[i][j + 1] == 0 && check[i][j - 1] == 0 && check[i + 1][j] == 0
						&& check[i - 1][j] == 0) {
					check[i][j] = 1;
					check[i][j + 1] = 1;
					check[i][j - 1] = 1;
					check[i + 1][j] = 1;
					check[i - 1][j] = 1;
					solve(depth+1);
					check[i][j] = 0;
					check[i][j + 1] = 0;
					check[i][j - 1] = 0;
					check[i + 1][j] = 0;
					check[i - 1][j] = 0;
				}
			}
		}//꽃잎이 4방향 모두 펼쳐있어야하므로 1부터 N-2까지 탐색을 수행한다. 모든 지점에 대하여 완전탐색을 수행한다.

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		check = new int[N][N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		solve(0);
		
		
		System.out.println(min);

	}

}
