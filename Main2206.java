import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 		Baekjoon Online Judge 2206�� - �� �μ��� �̵��ϱ�
 * 
 * 		https://www.acmicpc.net/problem/2206
 */

public class Main2206 {

	static char[][] map;
	static boolean[][][] checked;

	static int[] my = { -1, 1, 0, 0 };
	static int[] mx = { 0, 0, -1, 1 };
	static int N;
	static int M;
	static int minLength = Integer.MAX_VALUE;

	static class state {
		int y;
		int x;
		int length;
		boolean distroy;

		public state(int y, int x, int length, boolean distroy) {
			super();
			this.y = y;
			this.x = x;
			this.length = length;
			this.distroy = distroy;
		}
	} // ���� ��ǥ�� ���� ��ġ������ ����� ����, ���� �ν����� ���θ� ������ Ŭ���� 

	public static void BFS() {


		Queue<state> queue = new LinkedList<>();
		queue.offer(new state(1, 1, 1, false));
		checked[1][1][0] = true;

		while (!queue.isEmpty()) {		
			state now = queue.poll(); // ���� ��ġ�� ���� 
			if(now.y == N && now.x == M) {
				if(now.length < minLength)
					minLength = now.length;
				continue;
			} // �������� ���������� ����� ���̰� �ּҰ� �ǵ��� ��ü 
			
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + my[i];
				int nextX = now.x + mx[i];
				if (map[nextY][nextX] != ' ') {
					if(now.distroy == false) { // ���� �μ����� 
						if (checked[nextY][nextX][0] == false && map[nextY][nextX] == '0') { // ���������� ���̾ƴҶ�
							checked[nextY][nextX][0] = true;
							checked[nextY][nextX][1] = true;
							queue.offer(new state(nextY,nextX,now.length+1,now.distroy));
						}
						else if (checked[nextY][nextX][1] == false && map[nextY][nextX] == '1' && now.distroy == false) { // ���������� ���϶� 
							checked[nextY][nextX][1] = true;
							queue.offer(new state(nextY,nextX,now.length+1,true));
						}						
					}else { //���� �μ��� 
						if (checked[nextY][nextX][1] == false && map[nextY][nextX] == '0') { // ���� �̹� �ν����Ƿ� 0�� �κи� ���� ���� 
							checked[nextY][nextX][1] = true; 
							queue.offer(new state(nextY,nextX,now.length+1,now.distroy));
						}
						
					}
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		map = new char[N + 2][M + 2];
		checked = new boolean[N + 2][M + 2][2]; // ���� �μ������� �ķ� ������ �湮���θ� üũ

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		} // �ʿ� �׵θ��� �ָ� �ʱ�ȭ 

		BFS();

		System.out.println(minLength == Integer.MAX_VALUE ? -1 : minLength);

	}

}
