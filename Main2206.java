import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 		Baekjoon Online Judge 2206번 - 벽 부수고 이동하기
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
	} // 현재 좌표와 현재 위치까지온 경로의 길이, 벽을 부쉈는지 여부를 저장할 클래스 

	public static void BFS() {


		Queue<state> queue = new LinkedList<>();
		queue.offer(new state(1, 1, 1, false));
		checked[1][1][0] = true;

		while (!queue.isEmpty()) {		
			state now = queue.poll(); // 현재 위치의 정보 
			if(now.y == N && now.x == M) {
				if(now.length < minLength)
					minLength = now.length;
				continue;
			} // 목적지에 도달했을때 경로의 길이가 최소가 되도록 교체 
			
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + my[i];
				int nextX = now.x + mx[i];
				if (map[nextY][nextX] != ' ') {
					if(now.distroy == false) { // 벽을 부수기전 
						if (checked[nextY][nextX][0] == false && map[nextY][nextX] == '0') { // 다음지역이 벽이아닐때
							checked[nextY][nextX][0] = true;
							checked[nextY][nextX][1] = true;
							queue.offer(new state(nextY,nextX,now.length+1,now.distroy));
						}
						else if (checked[nextY][nextX][1] == false && map[nextY][nextX] == '1' && now.distroy == false) { // 다음지점이 벽일때 
							checked[nextY][nextX][1] = true;
							queue.offer(new state(nextY,nextX,now.length+1,true));
						}						
					}else { //벽을 부순후 
						if (checked[nextY][nextX][1] == false && map[nextY][nextX] == '0') { // 벽을 이미 부쉈으므로 0인 부분만 갈수 있음 
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
		checked = new boolean[N + 2][M + 2][2]; // 벽을 부수기전과 후로 나누어 방문여부를 체크

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		} // 맵에 테두리를 주며 초기화 

		BFS();

		System.out.println(minLength == Integer.MAX_VALUE ? -1 : minLength);

	}

}
