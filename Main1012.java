import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 1012�� - ����� ����
 * 
 * https://www.acmicpc.net/problem/1012
 * 
 */


public class Main1012 {

	static int[][] map;

	static int M;
	static int N;
	static int count;

	static class vet {
		int i;
		int j;

		vet(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	static void solve(int i, int j) { //bfs�� �����Ͽ� ���߰� �ִ������� ���üũ�ϰ� �������� �ϳ� ������Ų��

		Queue<vet> queue = new LinkedList<vet>();

		vet start = new vet(i, j);

		queue.offer(start);
		map[start.i][start.j] = 0;

		while (!queue.isEmpty()) {

			vet current = queue.poll();

			if (current.i + 1 < N && map[current.i + 1][current.j] == 1) {
				vet next = new vet(current.i + 1, current.j);
				map[current.i+1][current.j] = 0;
				queue.offer(next);
			}

			if (current.j + 1 < M && map[current.i][current.j + 1] == 1) {
				vet next = new vet(current.i, current.j + 1);
				map[current.i][current.j+1] = 0;
				queue.offer(next);
			}

			if (current.i - 1 >= 0 && map[current.i - 1][current.j] == 1) {
				vet next = new vet(current.i - 1, current.j);
				map[current.i-1][current.j] = 0;
				queue.offer(next);
			}

			if (current.j - 1 >= 0 && map[current.i][current.j - 1] == 1) {
				vet next = new vet(current.i, current.j - 1);
				map[current.i][current.j-1] = 0;
				queue.offer(next);
			}

		} 

		count++; 
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] output = new int[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			count = 0;

			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (map[j][j2] == 1)
						solve(j, j2);
				}
			}
			output[i] = count;
		}

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
