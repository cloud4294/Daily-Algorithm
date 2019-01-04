import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 		Baekjoon Online Judge 2933번 - 미네랄
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

	} // 좌표 정보 클래스 

	public static void solve(int y, int x) {
		map[y][x] = '.'; // 현재 위치 미네랄 파괴 

		for (int i = 0; i < 4; i++) {
			int ny = y + my[i];
			int nx = x + mx[i];
			if (map[ny][nx] != '.' && map[ny][nx] != 'x') // 4방향이 배열 범위를 벗어나면 다음 loop로 
				continue; 

			if (map[ny][nx] == 'x') { // 현재지점으로부터 4방향의 bfs를 시행 
				if (BFS(ny, nx) == false) {
					move(); // bfs 결과가 false인 경우 클러스터를 떨어뜨림 
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
		} // 클러스터의 최하 부분은 하단방향에 '.'만 있으므로 
		int i = 1;
		while (true) {

			for (node n : bottom) {
				if (map[n.y - i][n.x] != '.') {
					return;
				}
			}// 다음칸으로 내려갈수 있는지 확인 
	
			for (node n : list) {
				map[n.y - (i - 1)][n.x] = '.';
			} // 현재 미네랄 위치를 지움
			for (node n : list) {
				map[n.y - i][n.x] = 'x';
			} // 다음 미네랄 위치로 옮김

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
					} // bfs탐색중 바닥을 만날 경우 클러스터가 떨어질 경우가 없으므로 true리턴 
					checked[nexty][nextx] = true;
					node next = new node(nexty, nextx);
					queue.offer(next);
					list.add(next);

				}
			}

		}
		return false; // 바닥을 탐색하지 못한경우 false리턴 

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
		} // 초기 지형 초기화 
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
			} // 짝수번째일 경우 왼쪽, 홀수번째일 경우 오른쪽 탐색 
			
		}

		for (int i = R; i >= 1; i--) {
			for (int j = 1; j <= C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
