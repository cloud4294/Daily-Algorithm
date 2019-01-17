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
		public int compareTo(tree o) { // �������� ���� 
			if (o.age <= this.age) {
				return 1;
			}
			return -1;
		}
	}

	public static void aging(int K) {
		Queue<tree> dead = new LinkedList<>();
		for (int m = 0; m < K; m++) {
			// ��
			// ���� ��ġ�� ���� ������ �ľ��ϰ�
			// ���� ���̰� ���� �������� ����� �Կ��ߵ�
			// ������ ���� ������ ���� �Ǿ��־�ߵ�

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					Collections.sort(trees[i][j]); // ���̼����� ���� 
					for (int j2 = 0; j2 < trees[i][j].size(); j2++) {
						tree now = trees[i][j].get(j2);
						if (now.age <= map[i][j]) { //Ʈ���� ������ ��ŭ�� ����� ������
							map[i][j] -= now.age;
							now.age++; 
						} else { // ������ ť�� ���� 
							dead.add(now);
						}
					}
				}
			}
			// ����
			while (!dead.isEmpty()) { // ���� �������� ó�� 
				tree d = dead.poll();
				trees[d.y][d.x].remove(d); 
				map[d.y][d.x] += (d.age / 2); // ��� �߰� 
			}

			// ����
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int j2 = 0; j2 < trees[i][j].size(); j2++) {
						tree now = trees[i][j].get(j2); // ������ġ�� �������� �ϳ��� ���� 
						if (now.age % 5 == 0) { // 5�� ����̸� 8�������� ���̰� 1�� ���� �߰� 
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

			// �ܿ�

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] += A[i][j];
				} // �� ������ ��� �߰� 
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
		} // �ʱ� ��� 

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				trees[i][j] = new ArrayList<>();
			}
		} // ���� ��ġ�� ���� 

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				A[i][j] = sc.nextInt();
			}
		} // �ֱ������� ���Ե� ��� 

		for (int i = 0; i < M; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int age = sc.nextInt();
			trees[y][x].add(new tree(y, x, age));
		} // �� ��ġ�� ������ ���� 

		aging(K); // K�� �� 

		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (trees[i][j].size() > 0) {
					count += trees[i][j].size();					
				}
			}
		} // �� ������ Ʈ���� ������ ��ü ������ �߰� 
		System.out.println(count);

	}

}
