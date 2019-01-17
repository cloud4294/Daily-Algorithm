import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main16235 {

	static int N, M;
	static int[][] A;
	static int[][] map;
	static List<tree>[][] trees;

	static int[] my = { 1, 1, 1, 0, -1, -1, -1, 0 };
	static int[] mx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static class tree implements Comparable<tree> {
		int y;
		int x;
		int age;

		public tree(int y, int x, int age) {
			super();
			this.y = y;
			this.x = x;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) { // 오름차순 정렬 
			if (o.age <= this.age) {
				return 1;
			}
			return -1;
		}
	}

	public static void aging(int K) {
		Queue<tree> dead = new LinkedList<>();
		for (int m = 0; m < K; m++) {
			// 봄
			// 본인 위치의 나무 갯수를 파악하고
			// 가장 나이가 적은 나무부터 양분을 먹여야됨
			// 나무의 나이 순으로 정렬 되어있어야됨

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					Collections.sort(trees[i][j]); // 나이순으로 정렬 
					for (int j2 = 0; j2 < trees[i][j].size(); j2++) {
						tree now = trees[i][j].get(j2);
						if (now.age <= map[i][j]) { //트리가 성장할 만큼의 양분이 있으면
							map[i][j] -= now.age;
							now.age++; 
						} else { // 없으면 큐에 넣음 
							dead.add(now);
						}
					}
				}
			}
			// 여름
			while (!dead.isEmpty()) { // 죽은 나무들을 처리 
				tree d = dead.poll();
				trees[d.y][d.x].remove(d); 
				map[d.y][d.x] += (d.age / 2); // 양분 추가 
			}

			// 가을
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int j2 = 0; j2 < trees[i][j].size(); j2++) {
						tree now = trees[i][j].get(j2); // 현재위치의 나무들중 하나를 선택 
						if (now.age % 5 == 0) { // 5의 배수이면 8방향으로 나이가 1인 나무 추가 
							for (int l = 0; l < 8; l++) {
								int ny = now.y + my[l];
								int nx = now.x + mx[l];
								if (A[ny][nx] != 0) {
									trees[ny][nx].add(0,new tree(ny, nx, 1));
								}

							}
						}
					}
				}
			}

			// 겨울

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] += A[i][j];
				} // 각 정점별 양분 추가 
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		A = new int[N + 2][N + 2];
		map = new int[N + 2][N + 2];
		trees = new ArrayList[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
			}
		} // 초기 양분 

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				trees[i][j] = new ArrayList<>();
			}
		} // 나무 위치및 개수 

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				A[i][j] = sc.nextInt();
			}
		} // 주기적으로 주입될 양분 

		for (int i = 0; i < M; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int age = sc.nextInt();
			trees[y][x].add(new tree(y, x, age));
		} // 각 위치에 나무를 심음 

		aging(K); // K년 후 

		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (trees[i][j].size() > 0) {
					count += trees[i][j].size();					
				}
			}
		} // 각 정점별 트리의 갯수를 전체 갯수에 추가 
		System.out.println(count);

	}

}
