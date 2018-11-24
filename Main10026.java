import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 *   Baekjoon Online Judge 10026번 - 적록색약
 *   
 *   https://www.acmicpc.net/problem/10026
 * 
 */


public class Main10026 {

	static char[][] map;
	static char[][] map2;
	static int[][] check;
	static int[][] check2;
	static int N;
	static int count =0;

	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };

	static class point {
		int y;
		int x;

		point(int y, int x) {
			this.y = y;
			this.x = x;

		}

	}

	static void bfs(int y, int x) {

		Queue<point> queue = new LinkedList<point>();

		char c = map[y][x];
		check[y][x] = 1;
		queue.offer(new point(y, x));

		while (!queue.isEmpty()) {
			point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				if (now.y + my[i] < 0 || now.y + my[i] >= N || now.x + mx[i] < 0 || now.x + mx[i] >= N)
					continue;

				if (check[now.y + my[i]][now.x + mx[i]] == 0 && map[now.y + my[i]][now.x + mx[i]] == c) {
					check[now.y + my[i]][now.x + mx[i]] = 1;
					queue.offer(new point(now.y + my[i], now.x + mx[i]));
				}
			}

		} // 모든 정점에 대해 방문하지 않았고 같은 문자를 가진 정점만 bfs탐색
		count++;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];	
		check = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(check[i][j] == 0) {
					bfs(i,j);
				}
			}
		}// 모든 정점에 대하여 첫번째 bfs시행
		
		int output1 = count;
		count = 0;
		check = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='G') {
					map[i][j] ='R';
				}
			}
		} // 녹색문자를 적색문자로 바꾸어 적록색약을 가진사람으로 처리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(check[i][j] == 0) {
					bfs(i,j);
				}
			}
		} // 두번째 bfs시행
		
		
		System.out.println(output1+" "+count);
	}

}
