import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 		Baekjoon Online Judge 3187�� - ��ġ�� ��
 * 
 * 		https://www.acmicpc.net/problem/3187
 */


public class Main3187 {

	static char[][] map;
	static boolean[][] checked;
	static int R, C, V, K;
	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };

	static class point {
		int y;
		int x;

		point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	} // ��ǥ Ŭ���� 

	public static void bfs(int i, int j) {
		int countV = 0;
		int countK = 0;

		Queue<point> queue = new LinkedList<point>();

		point start = new point(i, j);
		queue.offer(start);
		checked[i][j] = true;
		if (map[i][j] == 'v')
			countV++;
		if (map[i][j] == 'k')
			countK++;

		while (!queue.isEmpty()) {
			
			point now = queue.poll();
			int y = now.y;
			int x = now.x;
			for (int k = 0; k < 4; k++) {
				if (x + mx[k] < 0 || x + mx[k] >= C || y + my[k] < 0 || y + my[k] >= R) // ������ ����� �Ѿ 
					continue;

				if (map[y + my[k]][x + mx[k]] != '#' && checked[y + my[k]][x + mx[k]] == false) {

					checked[y + my[k]][x + mx[k]] = true;
					queue.offer(new point(y + my[k], x + mx[k]));

					if (map[y + my[k]][x + mx[k]] == 'v')
						countV++;
					if (map[y + my[k]][x + mx[k]] == 'k')
						countK++;
					// ���� ������ ���̳� ���밡 ������ �� ���� ���� ��Ŵ 

				}

			}

		}

		if (countK > countV)
			K += countK;
		else
			V += countV;
		// ���� bfs�� ����� �κ��߿��� ��� ������ ���� ���Ͽ� ��ü�� ���� 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C];
		checked = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String data = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = data.charAt(j);
			}
		} // map �ʱ�ȭ 

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (checked[i][j] == false && map[i][j] != '#')
					bfs(i, j);
			}
		} // map�߿��� �湮���� �ʰ� ��Ÿ���� �ƴ� ������ ������ bfs���� 
		
		System.out.println(K +" "+ V);

	}

}
