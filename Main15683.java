import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 15683�� - ����
 * 
 * 		https://www.acmicpc.net/problem/15683
 * 
 */


public class Main15683 {

	static int N;
	static int M;
	static int[][] map;
	static List<node> list;
	static int min = Integer.MAX_VALUE;

	static class node {
		int idx;
		int y;
		int x;

		public node(int idx, int y, int x) {
			this.idx = idx;
			this.y = y;
			this.x = x;
		}
	}

	public static void detect(int[][] visited, int y, int x, int dir) {

		if (dir == 0) {
			for (int i = y; i < N; i++) {
				if (map[i][x] == 6) // ���� ������ ���� 
					return;
				else
					visited[i][x] = 7; // ���� �ƴϸ� 7�� ä�� �þ߰� Ȯ���Ǵ� ���� üũ
			}
		} else if (dir == 1) {
			for (int i = x; i < M; i++) {
				if (map[y][i] == 6)
					return;
				else
					visited[y][i] = 7;
			}
		} else if (dir == 2) {
			for (int i = y; i >= 0; i--) {
				if (map[i][x] == 6)
					return;
				else
					visited[i][x] = 7;
			}
		} else if (dir == 3) {
			for (int i = x; i >= 0; i--) {
				if (map[y][i] == 6)
					return;
				else
					visited[y][i] = 7;
			}
		}
	}

	public static void search(int count, int[][] prev) {
		int[][] visited = new int[N][M]; // cctv�� ���̴� �κ��� üũ�� �迭 ���� 
		if (count == list.size()) { // cctv�� ������ ����Ʈ�� ����� �Ǹ� ��� üũ �Ѱ��̹Ƿ� 0�� ������ ���� �簢���� ��� 

			int area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(prev[i][j] == 0)
						area++;
				}
			}
			
			
			if(area < min)
				min = area;
			
		} else {
			node now = list.get(count);
			int index = now.idx; // cctv���� 
			int y = now.y;
			int x = now.x;

			if (index == 1) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < N; j++) {
						visited[j] = Arrays.copyOf(prev[j], M); // ���� ���� ������ ���� **Arrays.copyof
					}
					detect(visited, y, x, i); //visited �迭�� ���⿡ ���� ä�� 
					search(count + 1, visited);
				}
			} else if (index == 2) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < N; j++) {
						visited[j] = Arrays.copyOf(prev[j], M);
					}
					detect(visited, y, x, i);
					detect(visited, y, x, i + 2);
					search(count + 1, visited);
				}
			} else if (index == 3) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < N; j++) {
						visited[j] = Arrays.copyOf(prev[j], M);
					}
					detect(visited, y, x, i % 4);
					detect(visited, y, x, (i + 1) % 4);
					search(count + 1, visited);
				}
			} else if (index == 4) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < N; j++) {
						visited[j] = Arrays.copyOf(prev[j], M);
					}
					detect(visited, y, x, i % 4);
					detect(visited, y, x, (i + 1) % 4);
					detect(visited, y, x, (i + 2) % 4);
					search(count + 1, visited);
				}
			} else if (index == 5) {

				for (int j = 0; j < N; j++) {
					visited[j] = Arrays.copyOf(prev[j], M);
				}
				detect(visited, y, x, 0);
				detect(visited, y, x, 1);
				detect(visited, y, x, 2);
				detect(visited, y, x, 3);
				search(count + 1, visited);

			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					list.add(new node(map[i][j], i, j));
				}
			}
		} // �ʱ� ������ �����ϰ� CCTV�� ������ ����Ʈ�� �־�� 

		search(0, map);
		
		System.out.println(min);

	}

}
