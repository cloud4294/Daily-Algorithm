import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  Baekjoon Online Judge 14502�� - ������ 
 * 
 *  https://www.acmicpc.net/problem/14502
 * 
 */

public class Main14502 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] copymap;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int max = 0;

	static void build(int count) {

		if (count == 3) { // �� ������ ���������� �����Ͽ� �׻����� ���� �����Ѵ�
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			solve(); // ������ �ʿ� ���� dfs�� �����Ѵ�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = copymap[i][j];
				}
			} // ���� ���� ������ �������´�
			
			
		}else {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						build(count + 1);
						map[i][j] = 0;
						
					}
				}
			}
		}
	}

	static void solve() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					 dfs(i, j);
				} // ���̷����� �ִ� �������� dfs�� �����Ѵ�
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		} // ������� üũ�Ѵ�

		if (count > max) {
			max = count;
		} 

	}

	static void dfs(int i, int j) {

		for (int k = 0; k < 4; k++) {
			if (i + dy[k] < N && i + dy[k] >= 0 && j + dx[k] < M && j + dx[k] >= 0) {
				if (map[i + dy[k]][j + dx[k]] == 0) {
					map[i + dy[k]][j + dx[k]] = 2;
					dfs(i + dy[k], j + dx[k]);

				}
			}
		} //dfs�� ���̷����� �۶߸���


	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copymap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		build(0);

		System.out.println(max);
		
	}

}
