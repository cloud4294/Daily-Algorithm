import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  Baekjoon Online Judge 3190�� - ��
 * 
 *  https://www.acmicpc.net/problem/3190
 *  
 */


public class Main3190 {

	static int[] dir_x = { 1, 0, -1, 0 };
	static int[] dir_y = { 0, -1, 0, 1 };


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[][] map = new int[102][102];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[l][c] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		int[] timer = new int[L];
		char[] c_dir = new char[L];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			timer[i] = time;
			c_dir[i] = dir;
		
		}
		
		Queue<Integer>lengthY = new LinkedList<Integer>();
		Queue<Integer>lengthX = new LinkedList<Integer>();
		map[1][1] = 2; 
		
		lengthY.offer(1);
		lengthX.offer(1); // ť�� �쿡 ��ġ�� �־���
		
		int y = 1;
		int x = 2; 
		int time = 1;
		int dir = 0;
		int check = 0;
		
		while (true) {

			if (y == 0 || x == 0 || y == N + 1 || x == N + 1) {
				System.out.println(time);
				return;
			} //���� �ε������� �����

			if (check < L) {
				if (timer[check] == time) {
					char d = c_dir[check];
					if (d == 'L') {
						dir++;
						if (dir == 4)
							dir = 0;
					} else if (d == 'D') {
						dir--;
						if (dir == -1)
							dir = 3;
					}
					check++;
				}
			} // ���� ��ȯ ����� ����������� �ش� �ð��� �Ǹ� ������ ��ȯ��

			lengthX.offer(x);
			lengthY.offer(y); // ���� ��ġ�� ť�� ����
			if (map[y][x] == 0) {
				int tx = lengthX.poll();
				int ty = lengthY.poll();
				map[ty][tx] = 0;
				// ����� ������ ť���� ���������Ҹ� �����ϰ� ������ ������ ��ġ�� 0���� �ٲ� 
			}
			map[y][x] = 2; // ���� ������ġ�� ����
			y += dir_y[dir];
			x += dir_x[dir];
			time++;

			if (map[y][x] == 2) { // ���� �̵��� ������ġ�� ���� ���� ������ ����
				System.out.println(time);
				return;
			}
		}

	}

}
