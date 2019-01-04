import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 		Baekjoon Online Judge 2933�� - �̳׶�
 * 
 * 		https://www.acmicpc.net/problem/2933
 */

public class Main2933 {

	static char[][] map;
	static int R, C;
	static int[] my = { -1, 0, 1, 0 };
	static int[] mx = { 0, -1, 0, 1 };
	static List<node> list;

	static class node {
		int y;
		int x;

		public node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	} // ��ǥ ���� Ŭ���� 

	public static void solve(int y, int x) {
		map[y][x] = '.'; // ���� ��ġ �̳׶� �ı� 

		for (int i = 0; i < 4; i++) {
			int ny = y + my[i];
			int nx = x + mx[i];
			if (map[ny][nx] != '.' && map[ny][nx] != 'x') // 4������ �迭 ������ ����� ���� loop�� 
				continue; 

			if (map[ny][nx] == 'x') { // �����������κ��� 4������ bfs�� ���� 
				if (BFS(ny, nx) == false) {
					move(); // bfs ����� false�� ��� Ŭ�����͸� ����߸� 
				}
			}
		}
	}

	public static void move() {
		List<node> bottom = new ArrayList<>();
		for (node n : list) {
			if (map[n.y - 1][n.x] == '.') {
				bottom.add(n);
			}
		} // Ŭ�������� ���� �κ��� �ϴܹ��⿡ '.'�� �����Ƿ� 
		int i = 1;
		while (true) {

			for (node n : bottom) {
				if (map[n.y - i][n.x] != '.') {
					return;
				}
			}// ����ĭ���� �������� �ִ��� Ȯ�� 
	
			for (node n : list) {
				map[n.y - (i - 1)][n.x] = '.';
			} // ���� �̳׶� ��ġ�� ����
			for (node n : list) {
				map[n.y - i][n.x] = 'x';
			} // ���� �̳׶� ��ġ�� �ű�

			i++;
		}

	}

	public static boolean BFS(int ny, int nx) {

		list.clear();
		boolean[][] checked = new boolean[R + 1][C + 1];

		Queue<node> queue = new LinkedList<>();
		queue.offer(new node(ny, nx));
		checked[ny][nx] = true;
		list.add(new node(ny, nx));

		while (!queue.isEmpty()) {
			node now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = now.y + my[i];
				int nextx = now.x + mx[i];
				if (map[nexty][nextx] == 'x' && checked[nexty][nextx] == false) {
					if (nexty == 1) {
						return true;
					} // bfsŽ���� �ٴ��� ���� ��� Ŭ�����Ͱ� ������ ��찡 �����Ƿ� true���� 
					checked[nexty][nextx] = true;
					node next = new node(nexty, nextx);
					queue.offer(next);
					list.add(next);

				}
			}

		}
		return false; // �ٴ��� Ž������ ���Ѱ�� false���� 

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R + 2][C + 2];
		list = new ArrayList<>();

		for (int i = R; i >= 1; i--) {
			String data = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = data.charAt(j - 1);
			}
		} // �ʱ� ���� �ʱ�ȭ 
		int N = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(input[i]);
			if (i % 2 == 0) {
				for (int j = 1; j <= C; j++) {
					if (map[now][j] == 'x') {
						solve(now, j);
						break;
					}
				}
			} else {
				for (int j = C; j >= 1; j--) {
					if (map[now][j] == 'x') {
						solve(now, j);
						break;
					}
				}
			} // ¦����°�� ��� ����, Ȧ����°�� ��� ������ Ž�� 
			
		}

		for (int i = R; i >= 1; i--) {
			for (int j = 1; j <= C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
