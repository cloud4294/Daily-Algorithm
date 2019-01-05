import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1824 {

	static int R;
	static int C;
	static char[][] map;
	static int[] my = { 0, 1, 0, -1 };
	static int[] mx = { 1, 0, -1, 0 };
	static boolean[][][][] checked;
	static boolean flag;

	static class dst {
		int y;
		int x;

		public dst(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void DFS(int i, int j, int k, int l) {

		if (flag == false) {

			if (i == R + 1)
				i = 1;
			if (i == 0)
				i = R;
			if (j == C + 1)
				j = 1;
			if (j == 0)
				j = C;
			if (l == -1)
				l = 15;
			if (l == 16)
				l = 0;
			// 맵을 벗어났을 경우 
			
			if (checked[i][j][k][l] == true) {
				return; // 현재위치에 같은 정보를 가지고 방문한 적이 있다면 loop가 생기므로 종료
			} else {
				checked[i][j][k][l] = true;
			}

			if (map[i][j] == '<') {
				DFS(i, j - 1, 2, l);
			} else if (map[i][j] == '>') {
				DFS(i, j + 1, 0, l);
			} else if (map[i][j] == '^') {
				DFS(i - 1, j, 3, l);
			} else if (map[i][j] == 'v') {
				DFS(i + 1, j, 1, l);
			} else if (map[i][j] == '_') {
				if (l == 0)
					DFS(i, j + 1, 0, l);
				else
					DFS(i, j - 1, 2, l);
			} else if (map[i][j] == '|') {
				if (l == 0)
					DFS(i + 1, j, 1, l);
				else
					DFS(i - 1, j, 3, l);
			} else if (map[i][j] == '?') {
				for (int l2 = 0; l2 < 4; l2++) {
					int ny = i + my[l2];
					int nx = j + mx[l2];
					DFS(ny, nx, l2, l);
				}
			} else if (map[i][j] == '.') {
				DFS(i + my[k], j + mx[k], k, l);
			} else if (map[i][j] == '@') {
				flag = true; // 목적지 도착
				return;
			} else if (map[i][j] == '+') {
				DFS(i + my[k], j + mx[k], k, l + 1);
			} else if (map[i][j] == '-') {
				DFS(i + my[k], j + mx[k], k, l - 1);
			} else {
				DFS(i + my[k], j + mx[k], k, Character.getNumericValue(map[i][j]));
			} // 현재 정보에 따라 dfs 시행 
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int k = 1; k <= T; k++) {

			String[] input = br.readLine().split(" ");
			R = Integer.parseInt(input[0]);
			C = Integer.parseInt(input[1]);
			flag = false;
			boolean check = false;
			map = new char[R + 2][C + 2];
			checked = new boolean[R + 2][C + 2][4][16];
			Queue<dst> queue = new LinkedList<>();
			
			for (int i = 1; i <= R; i++) {
				String line = br.readLine();
				for (int j = 1; j <= C; j++) {
					map[i][j] = line.charAt(j - 1);
					if (map[i][j] == '@') {
						queue.offer(new dst(i, j)); // 목적지를 큐에 넣어둠 
					}
				}
			} // char배열에 초기화 

			while (!queue.isEmpty()) {
				dst now = queue.poll();
				for (int i = 0; i < 4; i++) {
					if (i % 2 == 0) {
						if (map[now.y + my[i]][now.x + mx[i]] != 'v' && map[now.y + my[i]][now.x + mx[i]] != '^')
							check = true;
					} else {
						if (map[now.y + my[i]][now.x + mx[i]] != '<' && map[now.y + my[i]][now.x + mx[i]] != '>')
							check = true;

					}
				}
				if(check == true) 
					break;
			} // 목적지가 유효한지 검사 

			if (check == true) // 목적지가 유효한경우 dfs시행
				DFS(1, 1, 0, 0);

			if (flag)
				System.out.println("#" + k + " YES");
			else
				System.out.println("#" + k + " NO");

		}

	}

}
