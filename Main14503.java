import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	 Baekjoon Online Judge 14503번 - 로봇 청소기
 * 
 *   https://www.acmicpc.net/problem/14503
 * 
 */

public class Main14503 {

	static int N;
	static int M;
	static int[][] map;

	static int count;

	static void solve(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			count++;
		}

		if (c - 1 >= 0 && c + 1 < M && r - 1 >= 0 && r + 1 < N) {
			if (map[r][c - 1] != 0 && map[r][c + 1] != 0 && map[r + 1][c] != 0 && map[r - 1][c] != 0) {
				if (d == 0) {
					if (map[r + 1][c] == 1)
						return;
					solve(r + 1, c, 0);
				} else if (d == 1) {
					if (map[r][c - 1] == 1)
						return;

					solve(r, c - 1, 1);
				} else if (d == 2) {
					if (map[r - 1][c] == 1)
						return;

					solve(r - 1, c, 2);
				} else if (d == 3) {
					if (map[r][c + 1] == 1)
						return;

					solve(r, c + 1, 3);
				}
			}
			else if (d == 0) {
				if (c - 1 >= 0 && map[r][c - 1] == 0) {
					solve(r, c - 1, 3);
				} else if (c - 1 >= 0) {
					solve(r, c, 3);
				}
			} else if (d == 1) {
				if (r - 1 >= 0 && map[r - 1][c] == 0) {
					solve(r - 1, c, 0);
				} else if (r - 1 >= 0) {
					solve(r, c, 0);
				}
				
			} else if (d == 2) {
				if (c + 1 < M && map[r][c + 1] == 0) {
					solve(r, c + 1, 1);
				} else if (c + 1 < M) {
					solve(r, c, 1);
				}
			} else if (d == 3) {
				if (r + 1 < N && map[r + 1][c] == 0) {
					solve(r + 1, c, 2);
				} else if (r + 1 < N) {
					solve(r, c, 2);
				}
				
			}
		}

	} // 재귀를 이용한 dfs 구현

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(r, c, d);
		

		System.out.println(count);
	}

}
