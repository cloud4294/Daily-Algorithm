import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 2146번 - 다리만들기
 * 
 * 		https://www.acmicpc.net/problem/2146
 */

public class Main2146 {

	static String[][] map;
	static int[][][] checked;
	static int N;
	static int[] my = { -1, 0, 1, 0 };
	static int[] mx = { 0, 1, 0, -1 };
	static Queue<dot> allqueue;
	static int output = Integer.MAX_VALUE;

	static class dot {
		int y;
		int x;
		int flag;
		int length;

		public dot(int y, int x, int flag, int length) {
			this.y = y;
			this.x = x;
			this.flag = flag;
			this.length = length;
		}
	} // 좌표, 섬번호, 섬으로부터 길이를 저장할 클래스 

	public static void find(int i, int j, int flag) {

		Queue<dot> queue = new LinkedList<>();

		checked[i][j][0] = -1;
		queue.offer(new dot(i, j, flag, 0));

		while (!queue.isEmpty()) {
			dot now = queue.poll();
			boolean check = false;
			for (int k = 0; k < 4; k++) {
				int ny = now.y + my[k];
				int nx = now.x + mx[k];

				if (map[ny][nx] != null) {
					if (map[ny][nx].equals("0") && check == false) {
						allqueue.offer(now); 
						check = true;
					} // 테두리 부분

					if (map[ny][nx].equals("1") && checked[ny][nx][0] == 0) {
						checked[ny][nx][0] = -1;
						queue.offer(new dot(ny, nx, flag, 0));
					} // 방문 체크해가며 bfs 시행 

				}
			}

		}

	}

	public static void allBFS() {

		while (!allqueue.isEmpty()) {
			dot now = allqueue.poll();
			for (int k = 0; k < 4; k++) {
				int ny = now.y + my[k];
				int nx = now.x + mx[k];

				if (map[ny][nx] != null) {
					if (checked[ny][nx][1] != 0 && checked[ny][nx][1] != now.flag) {
						if(now.length + checked[ny][nx][0]<output) {
							output = now.length + checked[ny][nx][0];
						}

					}// 다음 지역에 다른섬의 번호가 찍혀 있고 현재 탐색한 최소 섬길이 보다 작다면 갱신

					if (map[ny][nx].equals("0") && checked[ny][nx][0] == 0) {
						checked[ny][nx][0] = now.length + 1; // 섬으로 부터 현재지점까지 길이 
						checked[ny][nx][1] = now.flag; // 섬번호 
						allqueue.offer(new dot(ny, nx, now.flag, now.length + 1));
					}
				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new String[N + 2][N + 2];
		checked = new int[N + 2][N + 2][2]; 
		allqueue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = st.nextToken();
			}
		}// 입력값 초기화 
		
		int flag = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j].equals("1") && checked[i][j][0] == 0) {
					find(i, j, flag);
					flag++; 
				}
			}
		}// 모든 지점에대하여 bfs를 시행하여 각섬의 테두리에 대한 정보를 큐에 저장 
		
		allBFS(); // 테두리 부분에 대해 bfs 시행 
		System.out.println(output);

		

	}

}
