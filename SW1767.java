import java.util.ArrayList;
import java.util.Scanner;

public class SW1767 {

	static class Core {
		int i;
		int j;

		Core(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	static int[][] map;
	static int min;
	static int MaxCore;
	static int N;

	static boolean isLine(int x, int y, int dir) {
		if (dir == 0) {
			for (int i = y + 1; i < N; i++) {
				if (map[x][i] != 0)
					return false;
			}
		} else if (dir == 1) {
			for (int i = x + 1; i < N; i++) {
				if (map[i][y] != 0)
					return false;
			}
		} else if (dir == 2) {
			for (int i = 0; i < y; i++) {
				if (map[x][i] != 0)
					return false;
			}
		} else {
			for (int i = 0; i < x; i++) {
				if (map[i][y] != 0)
					return false;
			}
		}
		return true;
	}

	static int drawLine(int x, int y, int dir, int flag) {
		int ans = 0;
		if (dir == 0) {
			for (int i = y + 1; i < N; i++) {
				
				if (flag == 0) {
					map[x][i] = 2;
				} else
					map[x][i] = 0;
				
				ans++;
			}
		} else if (dir == 1) {
			for (int i = x + 1; i < N; i++) {
				if (flag == 0) {
					map[i][y] = 2;
				} else
					map[i][y] = 0;
				ans++;
			}
		} else if (dir == 2) {
			for (int i = 0; i < y; i++) {
				if (flag == 0) {
					map[x][i] = 2;
				} else
					map[x][i] = 0;
				ans++;
			}
		} else {
			for (int i = 0; i < x; i++) {
				if (flag == 0) {
					map[i][y] = 2;
				} else
					map[i][y] = 0;
				ans++;
			}
		}
		return ans;
	}

	static void dfs(ArrayList<Core> list, int idx, int num, int line) {
		if (idx == list.size()) {
			if (MaxCore < num) {
				min = line;
				MaxCore = num;
			}
			else if (MaxCore == num) {
				if (min > line)
					min = line;
			}
		} else {
			for (int i = 0; i < 4; i++) {
				if (isLine(list.get(idx).i, list.get(idx).j, i)) {
					dfs(list, idx + 1, num + 1, line + drawLine(list.get(idx).i, list.get(idx).j, i, 0));
					drawLine(list.get(idx).i, list.get(idx).j, i, 1);
				}
			}
			dfs(list, idx + 1, num, line);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			N = sc.nextInt();
			ArrayList<Core> list = new ArrayList<Core>();
			map = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					map[j][k] = sc.nextInt();

					if (map[j][k] == 1) {
						Core core = new Core(j, k);
						list.add(core);
					}
				}
			}
			min = Integer.MAX_VALUE;
			MaxCore = 0;
			dfs(list, 0, 0, 0);
			System.out.println("#" + i + " " + min);
	
		}

	}

}
